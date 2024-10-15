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
            try {
                System.out.println("\nTipo de pregunta:");
                System.out.println("1. Verdadero/Falso");
                System.out.println("2. Respuesta Corta");
                System.out.println("3. Seleccion Multiple");
                System.out.println("4. Finalizar examen");
                
                System.out.print("Seleccione una opcion: ");
                int opcion = Integer.parseInt(scanner.nextLine().trim());
                
                switch (opcion) {
                    case 1:
                        examen.agregaPregunta(crearPreguntaTF());
                        break;
                    case 2:
                        examen.agregaPregunta(crearPreguntaRC());
                        break;
                    case 3:
                        examen.agregaPregunta(crearPreguntaSM());
                        break;
                    case 4:
                        return examen;
                    default:
                        System.out.println("Opcion no valida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
        
        System.out.println("Se ha alcanzado el limite maximo de preguntas.");
        return examen;
    }

    private TFpregunta crearPreguntaTF() {
        String texto = leerEntrada("Ingrese el texto de la pregunta: ");
        
        boolean respuestaCorrecta = false;
        while (true) {
            try {
                System.out.print("Ingrese la respuesta correcta (true/false): ");
                respuestaCorrecta = Boolean.parseBoolean(scanner.nextLine().trim());
                break;
            } catch (Exception e) {
                System.out.println("Error: Ingrese 'true' o 'false'.");
            }
        }
        
        int peso = leerEnteroPositivo("Ingrese el peso de la pregunta: ");
        
        return new TFpregunta(texto, respuestaCorrecta, peso);
    }

    private Resp_Cortas_Pregunta crearPreguntaRC() {
        String texto = leerEntrada("Ingrese el texto de la pregunta: ");
        String respuestaCorrecta = leerEntrada("Ingrese la respuesta correcta: ");
        int peso = leerEnteroPositivo("Ingrese el peso de la pregunta: ");
        
        return new Resp_Cortas_Pregunta(texto, respuestaCorrecta, peso);
    }

    private Selec_Mul_Pregunta crearPreguntaSM() {
        String texto = leerEntrada("Ingrese el texto de la pregunta: ");
        
        int numOpciones = leerEnteroPositivo("Ingrese el numero de opciones (minimo 2): ");
        while (numOpciones < 2) {
            System.out.println("Error: Debe haber al menos 2 opciones.");
            numOpciones = leerEnteroPositivo("Ingrese el numero de opciones (minimo 2): ");
        }
        
        String[] opciones = new String[numOpciones];
        for (int i = 0; i < numOpciones; i++) {
            opciones[i] = leerEntrada("Ingrese la opcion " + (i + 1) + ": ");
        }
        
        int respuestaCorrecta = leerEnteroEnRango("Ingrese el numero de la opcion correcta", 1, numOpciones) - 1;
        
        int peso = leerEnteroPositivo("Ingrese el peso de la pregunta: ");
        
        return new Selec_Mul_Pregunta(texto, opciones, respuestaCorrecta, peso);
    }

    private String leerEntrada(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private int leerEnteroPositivo(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor > 0) {
                    return valor;
                } else {
                    System.out.println("Error: Ingrese un numero positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
            }
        }
    }

    private int leerEnteroEnRango(String mensaje, int min, int max) {
        while (true) {
            try {
                System.out.print(mensaje + " (" + min + "-" + max + "): ");
                int valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Error: Ingrese un numero entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
            }
        }
    }
}