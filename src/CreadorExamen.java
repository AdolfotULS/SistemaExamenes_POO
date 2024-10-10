
import java.util.Scanner;

public class CreadorExamen {
    private Scanner scanner;

    public CreadorExamen(Scanner scanner) {
        this.scanner = scanner;
    }

    public Exam crearExamen() {
        Exam examen = new Exam();
        System.out.println("Creacion del usuario un nuevo examen");
        
        while (examen.getContadorPreguntas() < 10) {
            System.out.println("\nTipo de pregunta:");
            System.out.println("1. Verdadero/Falso");
            System.out.println("2. Respuesta Corta");
            System.out.println("3. Selección Múltiple");
            System.out.println("4. Finalizar examen");
            
            System.out.println("Seleccione una opcion: ");
            int opcion = Integer.parseInt(scanner.nextLine().trim());
            
            switch (opcion) {
                case 1:
                    examen.agregaPregunta(crearPreguntaTF());
                    break;
                case 2:
                    //examen.agregaPregunta(crearPreguntaRC());
                    break;
                case 3:
                    //examen.agregaPregunta(crearPreguntaSM());
                    break;
                case 4:
                    return examen;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
        
        System.out.println("Se ha alcanzado el límite maximo de preguntas.");
        return examen;
    }

    private TFpregunta crearPreguntaTF() {
        String texto = consola.leerEntrada("Ingrese el texto de la pregunta: ");
        boolean respuestaCorrecta = Boolean.parseBoolean(consola.leerEntrada("Ingrese la respuesta correcta (true/false): "));
        int peso = Integer.parseInt(consola.leerEntrada("Ingrese el peso de la pregunta: "));
        return new TFpregunta(texto, respuestaCorrecta, peso);
    }

//    private Resp_Cortas_Pregunta crearPreguntaRC() {
//        String texto = consola.leerEntrada("Ingrese el texto de la pregunta: ");
//        String respuestaCorrecta = consola.leerEntrada("Ingrese la respuesta correcta: ");
//        int peso = Integer.parseInt(consola.leerEntrada("Ingrese el peso de la pregunta: "));
//        return new Resp_Cortas_Pregunta(texto, respuestaCorrecta, peso);
//    }

//    private Selec_Mul_Pregunta crearPreguntaSM() {
//        String texto = consola.leerEntrada("Ingrese el texto de la pregunta: ");
//        int numOpciones = Integer.parseInt(consola.leerEntrada("Ingrese el número de opciones: "));
//        String[] opciones = new String[numOpciones];
//        for (int i = 0; i < numOpciones; i++) {
//            opciones[i] = consola.leerEntrada("Ingrese la opción " + (i + 1) + ": ");
//        }
//        int respuestaCorrecta = Integer.parseInt(consola.leerEntrada("Ingrese el número de la opción correcta (1-" + numOpciones + "): ")) - 1;
//        int peso = Integer.parseInt(consola.leerEntrada("Ingrese el peso de la pregunta: "));
//        return new Selec_Mul_Pregunta(texto, opciones, respuestaCorrecta, peso);
//    }
}
