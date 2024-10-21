import java.util.Scanner;

public class CreadorExamen {
    // Atributo scanner para leer entradas desde la consola
    private Scanner scanner;

    // Constructor que recibe un objeto Scanner para inicializar la clase
    public CreadorExamen(Scanner scanner) {
        this.scanner = scanner;
    }

    // Metodo principal para crear un nuevo examen
    public Exam crearExamen() {
        Exam examen = new Exam(); // Crea una nueva instancia del examen
        System.out.println("Creacion del usuario un nuevo examen");

        // Bucle para agregar preguntas hasta que el limite de 10 se alcance
        while (examen.getContadorPreguntas() < 10) {
            try {
                // Muestra las opciones para el tipo de pregunta
                System.out.println("\nTipo de pregunta:");
                System.out.println("1. Verdadero/Falso");
                System.out.println("2. Respuesta Corta");
                System.out.println("3. Seleccion Multiple");
                System.out.println("4. Finalizar examen");

                // Solicita la opcion del usuario
                System.out.print("Seleccione una opcion: ");
                int opcion = Integer.parseInt(scanner.nextLine().trim()); // Lee y convierte la entrada a entero

                // Ejecuta el caso segun la opcion seleccionada
                switch (opcion) {
                    case 1:
                        // Crea y agrega una pregunta de Verdadero/Falso
                        examen.agregaPregunta(crearPreguntaTF());
                        break;
                    case 2:
                        // Crea y agrega una pregunta de Respuesta Corta
                        examen.agregaPregunta(crearPreguntaRC());
                        break;
                    case 3:
                        // Crea y agrega una pregunta de Seleccion Multiple
                        examen.agregaPregunta(crearPreguntaSM());
                        break;
                    case 4:
                        // Finaliza el examen y lo retorna
                        return examen;
                    default:
                        // Opcion no valida
                        System.out.println("Opcion no valida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                // Maneja error si la entrada no es un numero valido
                System.out.println("Error: Ingrese un numero valido.");
            } catch (Exception e) {
                // Maneja errores inesperados
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }

        // Muestra un mensaje cuando se alcanzan las 10 preguntas
        System.out.println("Se ha alcanzado el limite maximo de preguntas.");
        return examen;
    }

    // Metodo para crear una pregunta de Verdadero/Falso
    private TFpregunta crearPreguntaTF() {
        // Lee el texto de la pregunta
        String texto = leerEntrada("Ingrese el texto de la pregunta: ");

        // Ciclo para asegurar que se ingrese un valor booleano valido
        boolean respuestaCorrecta = false;
        while (true) {
            try {
                System.out.print("Ingrese la respuesta correcta (true/false): ");
                respuestaCorrecta = Boolean.parseBoolean(scanner.nextLine().trim()); // Convierte la entrada a booleano
                break; // Sale del ciclo si la conversion es correcta
            } catch (Exception e) {
                System.out.println("Error: Ingrese 'true' o 'false'.");
            }
        }

        // Lee y valida el peso de la pregunta
        int peso = leerEnteroPositivo("Ingrese el peso de la pregunta: ");

        // Crea una nueva pregunta de tipo Verdadero/Falso y la retorna
        return new TFpregunta(texto, respuestaCorrecta, peso);
    }

    // Metodo para crear una pregunta de Respuesta Corta
    private Resp_Cortas_Pregunta crearPreguntaRC() {
        // Lee el texto de la pregunta
        String texto = leerEntrada("Ingrese el texto de la pregunta: ");
        // Lee la respuesta correcta
        String respuestaCorrecta = leerEntrada("Ingrese la respuesta correcta: ");
        // Lee y valida el peso de la pregunta
        int peso = leerEnteroPositivo("Ingrese el peso de la pregunta: ");

        // Crea una nueva pregunta de tipo Respuesta Corta y la retorna
        return new Resp_Cortas_Pregunta(texto, respuestaCorrecta, peso);
    }

    // Metodo para crear una pregunta de Seleccion Multiple
    private Selec_Mul_Pregunta crearPreguntaSM() {
        // Lee el texto de la pregunta
        String texto = leerEntrada("Ingrese el texto de la pregunta: ");

        // Lee y valida el numero de opciones
        int numOpciones = leerEnteroPositivo("Ingrese el numero de opciones (minimo 2): ");
        while (numOpciones < 2) {
            System.out.println("Error: Debe haber al menos 2 opciones.");
            numOpciones = leerEnteroPositivo("Ingrese el numero de opciones (minimo 2): ");
        }

        // Crea un arreglo de opciones
        String[] opciones = new String[numOpciones];
        // Lee cada opcion individualmente
        for (int i = 0; i < numOpciones; i++) {
            opciones[i] = leerEntrada("Ingrese la opcion " + (i + 1) + ": ");
        }

        // Lee y valida el numero de la opcion correcta
        int respuestaCorrecta = leerEnteroEnRango("Ingrese el numero de la opcion correcta", 1, numOpciones) - 1;

        // Lee y valida el peso de la pregunta
        int peso = leerEnteroPositivo("Ingrese el peso de la pregunta: ");

        // Crea una nueva pregunta de Seleccion Multiple y la retorna
        return new Selec_Mul_Pregunta(texto, opciones, respuestaCorrecta, peso);
    }

    // Metodo auxiliar para leer una entrada de texto desde la consola
    private String leerEntrada(String mensaje) {
        System.out.print(mensaje); // Muestra el mensaje
        return scanner.nextLine().trim(); // Retorna la entrada del usuario sin espacios en blanco
    }

    // Metodo auxiliar para leer un entero positivo
    private int leerEnteroPositivo(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje); // Muestra el mensaje
                int valor = Integer.parseInt(scanner.nextLine().trim()); // Lee la entrada y la convierte a entero
                if (valor > 0) { // Verifica que el valor sea positivo
                    return valor; // Retorna el valor si es valido
                } else {
                    System.out.println("Error: Ingrese un numero positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
            }
        }
    }

    // Metodo auxiliar para leer un entero dentro de un rango especifico
    private int leerEnteroEnRango(String mensaje, int min, int max) {
        while (true) {
            try {
                // Muestra el mensaje y el rango permitido
                System.out.print(mensaje + " (" + min + "-" + max + "): ");
                int valor = Integer.parseInt(scanner.nextLine().trim()); // Lee la entrada y la convierte a entero
                if (valor >= min && valor <= max) { // Verifica que el valor este dentro del rango
                    return valor; // Retorna el valor si es valido
                } else {
                    System.out.println("Error: Ingrese un numero entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
            }
        }
    }
}
