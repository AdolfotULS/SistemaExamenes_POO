import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exam {
    // Lista que almacenara las preguntas del examen
    private List<Pregunta> preguntas;
    // Contador de preguntas agregadas al examen
    private int contadorPreguntas;
    // Suma del puntaje total del examen
    private int puntajeTotal;
    // Constante que define el maximo numero de preguntas permitidas en el examen
    private static final int MAX_PREGUNTAS = 10;

    // Constructor de la clase Exam
    public Exam() {
        // Inicializa la lista de preguntas, contador de preguntas y puntaje total
        this.preguntas = new ArrayList<>();
        this.contadorPreguntas = 0;
        this.puntajeTotal = 0;
    }

    // Metodo que agrega una pregunta al examen
    public void agregaPregunta(Pregunta pregunta) {
        // Verifica si no se ha alcanzado el maximo numero de preguntas
        if (contadorPreguntas < MAX_PREGUNTAS) {
            // Agrega la pregunta a la lista
            preguntas.add(pregunta);
            // Incrementa el contador de preguntas
            contadorPreguntas++;
            // Suma el peso de la pregunta al puntaje total
            puntajeTotal += pregunta.getPeso();
        } else {
            // Si se alcanza el limite, muestra un mensaje
            System.out.println("No se pueden agregar mas preguntas. Limite alcanzado.");
        }
    }

    // Metodo que devuelve el numero de preguntas agregadas
    public int getContadorPreguntas() {
        return contadorPreguntas;
    }

    // Metodo que devuelve el puntaje total del examen
    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    // Metodo que ejecuta el examen, presentando las preguntas y calculando el
    // puntaje obtenido
    public int darExam() {
        int puntajeObtenido = 0;
        int numeroPregunta = 1; // Contador para el numero de la pregunta

        // Recorre todas las preguntas del examen
        for (Pregunta pregunta : preguntas) {
            System.out.println("\n---------------------------------------------------------------------");
            System.out.println("Pregunta " + numeroPregunta + "\n");
            // Si la respuesta de la pregunta es correcta, se suma el puntaje
            if (pregunta.buscar()) {
                puntajeObtenido += pregunta.getPeso();
            }
            numeroPregunta++; // Incrementa el numero de la pregunta
        }

        // Devuelve el puntaje obtenido tras realizar el examen
        return puntajeObtenido;
    }

    // Metodo que calcula el porcentaje de aciertos basandose en el puntaje obtenido
    public double calcularPorcentaje(int puntajeObtenido) {
        return ((double) puntajeObtenido * 100) / puntajeTotal;
    }

    // Metodo que guarda el examen en un archivo de texto
    public void guardarEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo + ".txt"))) {
            // Escribe el numero de preguntas y el puntaje total
            writer.write(contadorPreguntas + "\n");
            writer.write(puntajeTotal + "\n");
            // Recorre cada pregunta y la guarda segun su tipo
            for (Pregunta pregunta : preguntas) {
                if (pregunta instanceof TFpregunta) {
                    TFpregunta tfp = (TFpregunta) pregunta;
                    // Guarda una pregunta de verdadero/falso en formato TF
                    writer.write(
                            "TF," + tfp.getTexto() + "," + tfp.getRespuestaCorrecta() + "," + tfp.getPeso() + "\n");
                } else if (pregunta instanceof Resp_Cortas_Pregunta) {
                    Resp_Cortas_Pregunta rcp = (Resp_Cortas_Pregunta) pregunta;
                    // Guarda una pregunta de respuesta corta en formato RC
                    writer.write(
                            "RC," + rcp.getTexto() + "," + rcp.getRespuestaCorrecta() + "," + rcp.getPeso() + "\n");
                } else if (pregunta instanceof Selec_Mul_Pregunta) {
                    Selec_Mul_Pregunta smp = (Selec_Mul_Pregunta) pregunta;
                    // Guarda una pregunta de seleccion multiple en formato SM
                    writer.write("SM," + smp.getTexto() + "," + String.join("|", smp.getElecciones()) + ","
                            + smp.getRespuestaCorrecta() + "," + smp.getPeso() + "\n");
                }
            }
        } catch (IOException e) {
            // Muestra un mensaje si ocurre un error al guardar
            System.out.println("Error al guardar el examen: " + e.getMessage());
        }
    }

    // Metodo que carga un examen desde un archivo de texto
    public static Exam cargarDeArchivo(String nombreArchivo) {
        Exam examen = new Exam();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo + ".txt"))) {
            // Lee el numero de preguntas y el puntaje total
            examen.contadorPreguntas = Integer.parseInt(reader.readLine());
            examen.puntajeTotal = Integer.parseInt(reader.readLine());
            String linea;
            // Lee cada linea del archivo y crea las preguntas correspondientes
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                Pregunta pregunta = null;
                // Identifica el tipo de pregunta por el prefijo (TF, RC, SM)
                switch (partes[0]) {
                    case "TF":
                        // Crea una pregunta de tipo Verdadero/Falso
                        pregunta = new TFpregunta(partes[1], Boolean.parseBoolean(partes[2]),
                                Integer.parseInt(partes[3]));
                        break;
                    case "RC":
                        // Crea una pregunta de tipo Respuesta Corta
                        pregunta = new Resp_Cortas_Pregunta(partes[1], partes[2], Integer.parseInt(partes[3]));
                        break;
                    case "SM":
                        // Crea una pregunta de tipo Seleccion Multiple
                        String[] opciones = partes[2].split("\\|");
                        pregunta = new Selec_Mul_Pregunta(partes[1], opciones, Integer.parseInt(partes[3]),
                                Integer.parseInt(partes[4]));
                        break;
                }
                // Si la pregunta fue creada correctamente, se agrega al examen
                if (pregunta != null) {
                    examen.preguntas.add(pregunta);
                }
            }
        } catch (IOException | NumberFormatException e) {
            // Muestra un mensaje si ocurre un error al cargar
            System.out.println("Error al cargar el examen: " + e.getMessage());
            return null;
        }
        return examen;
    }
}
