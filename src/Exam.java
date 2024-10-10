
import com.google.gson.*;
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
        for (Pregunta pregunta : preguntas) {
            if (pregunta.buscar()) {
                puntajeObtenido += pregunta.getPeso();
            }
        }
        return puntajeObtenido;
    }

    public double calcularPorcentaje(int puntajeObtenido) {
        return (double) puntajeObtenido / puntajeTotal * 100;
    }

    public void guardarEnArchivo(String nombreArchivo) {
//        Gson gson = new GsonBuilder()
//            .registerTypeAdapter(Pregunta.class, new PreguntaSerializer())
//            .setPrettyPrinting()
//            .create();
//        
//        String json = gson.toJson(this);
//        
//        try (FileWriter writer = new FileWriter(nombreArchivo)) {
//            writer.write(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static Exam cargarDeArchivo(String nombreArchivo) {
//        Gson gson = new GsonBuilder()
//            .registerTypeAdapter(Pregunta.class, new PreguntaDeserializer())
//            .create();
//        
//        try (Reader reader = new FileReader(nombreArchivo)) {
//            return gson.fromJson(reader, Exam.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
        return null;
    }
}