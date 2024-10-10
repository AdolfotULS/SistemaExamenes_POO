public class CreadorExamen {
//    private InterfazConsola consola;
//    private Scanner scanner;
//
//    public CreadorExamen(InterfazConsola consola) {
//        this.consola = consola;
//        this.scanner = new Scanner(System.in);
//    }

//    public Exam crearExamen() {
//        Exam examen = new Exam();
//        consola.mostrarMensaje("Creación de un nuevo examen");
//        
//        while (examen.getContadorPreguntas() < 10) {
//            consola.mostrarMensaje("\nTipo de pregunta:");
//            consola.mostrarMensaje("1. Verdadero/Falso");
//            consola.mostrarMensaje("2. Respuesta Corta");
//            consola.mostrarMensaje("3. Selección Múltiple");
//            consola.mostrarMensaje("4. Finalizar examen");
//            
//            int opcion = Integer.parseInt(consola.leerEntrada("Seleccione una opción: "));
//            
//            switch (opcion) {
//                case 1:
//                    examen.agregaPregunta(crearPreguntaTF());
//                    break;
//                case 2:
//                    examen.agregaPregunta(crearPreguntaRC());
//                    break;
//                case 3:
//                    examen.agregaPregunta(crearPreguntaSM());
//                    break;
//                case 4:
//                    return examen;
//                default:
//                    consola.mostrarMensaje("Opción no válida. Intente de nuevo.");
//            }
//        }
//        
//        consola.mostrarMensaje("Se ha alcanzado el límite máximo de preguntas.");
//        return examen;
//    }
//
//    private TFpregunta crearPreguntaTF() {
//        String texto = consola.leerEntrada("Ingrese el texto de la pregunta: ");
//        boolean respuestaCorrecta = Boolean.parseBoolean(consola.leerEntrada("Ingrese la respuesta correcta (true/false): "));
//        int peso = Integer.parseInt(consola.leerEntrada("Ingrese el peso de la pregunta: "));
//        return new TFpregunta(texto, respuestaCorrecta, peso);
//    }

//    private Resp_Cortas_Pregunta crearPreguntaRC() {
//        String texto = consola.leerEntrada("Ingrese el texto de la pregunta: ");
//        String respuestaCorrecta = consola.leerEntrada("Ingrese la respuesta correcta: ");
//        int peso = Integer.parseInt(consola.leerEntrada("Ingrese el peso de la pregunta: "));
//        return new Resp_Cortas_Pregunta(texto, respuestaCorrecta, peso);
//    }
//
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
