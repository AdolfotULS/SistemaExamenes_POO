import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exam {
    private List<Pregunta> preguntas;
    private int contadorPreguntas;
    private int puntajeTotal;
    private static final int MAX_PREGUNTAS = 10;

    public Exam() {
        this.preguntas = new ArrayList<>();
        this.contadorPreguntas = 0;
        this.puntajeTotal = 0;
    }

    public void agregaPregunta(Pregunta pregunta) {
        if (contadorPreguntas < MAX_PREGUNTAS) {
            preguntas.add(pregunta);
            contadorPreguntas++;
            puntajeTotal += pregunta.getPeso();
        } else {
            System.out.println("No se pueden agregar mas preguntas. Limite alcanzado.");
        }
    }

    public int getContadorPreguntas() {
        return contadorPreguntas;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public int darExam() {
        int puntajeObtenido = 0;
        int numeroPregunta = 1; // Contador para el numero de la pregunta

        for (Pregunta pregunta : preguntas) {
            System.out.println("\n---------------------------------------------------------------------");
            System.out.println("Pregunta " + numeroPregunta + "\n");
            if (pregunta.buscar()) {
                puntajeObtenido += pregunta.getPeso();
            }
            numeroPregunta++; // Incrementa el nUmero de la pregunta
        }

        return puntajeObtenido;
    }

    public double calcularPorcentaje(int puntajeObtenido) {
        return ((double) puntajeObtenido * 100) / puntajeTotal;
    }

    public void guardarEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo + ".txt"))) {
            writer.write(contadorPreguntas + "\n");
            writer.write(puntajeTotal + "\n");
            for (Pregunta pregunta : preguntas) {
                if (pregunta instanceof TFpregunta) {
                    TFpregunta tfp = (TFpregunta) pregunta;
                    writer.write(
                            "TF," + tfp.getTexto() + "," + tfp.getRespuestaCorrecta() + "," + tfp.getPeso() + "\n");
                } else if (pregunta instanceof Resp_Cortas_Pregunta) {
                    Resp_Cortas_Pregunta rcp = (Resp_Cortas_Pregunta) pregunta;
                    writer.write(
                            "RC," + rcp.getTexto() + "," + rcp.getRespuestaCorrecta() + "," + rcp.getPeso() + "\n");
                } else if (pregunta instanceof Selec_Mul_Pregunta) {
                    Selec_Mul_Pregunta smp = (Selec_Mul_Pregunta) pregunta;
                    writer.write("SM," + smp.getTexto() + "," + String.join("|", smp.getElecciones()) + ","
                            + smp.getRespuestaCorrecta() + "," + smp.getPeso() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el examen: " + e.getMessage());
        }
    }

    public static Exam cargarDeArchivo(String nombreArchivo) {
        Exam examen = new Exam();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo + ".txt"))) {
            examen.contadorPreguntas = Integer.parseInt(reader.readLine());
            examen.puntajeTotal = Integer.parseInt(reader.readLine());
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                Pregunta pregunta = null;
                switch (partes[0]) {
                    case "TF":
                        pregunta = new TFpregunta(partes[1], Boolean.parseBoolean(partes[2]),
                                Integer.parseInt(partes[3]));
                        break;
                    case "RC":
                        pregunta = new Resp_Cortas_Pregunta(partes[1], partes[2], Integer.parseInt(partes[3]));
                        break;
                    case "SM":
                        String[] opciones = partes[2].split("\\|");
                        pregunta = new Selec_Mul_Pregunta(partes[1], opciones, Integer.parseInt(partes[3]),
                                Integer.parseInt(partes[4]));
                        break;
                }
                if (pregunta != null) {
                    examen.preguntas.add(pregunta);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al cargar el examen: " + e.getMessage());
            return null;
        }
        return examen;
    }
}