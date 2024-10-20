import java.util.Scanner;

public class InterfazConsola {
    private Scanner scanner;

    public InterfazConsola() {
        this.scanner = new Scanner(System.in);
    }

    private void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println(" Menu Principal ");
            System.out.println();
            System.out.println(" Opciones:");
            System.out.println(" 1. Cargar Examen");
            System.out.println(" 2. Crear Examen");
            System.out.println(" 3. Salir del programa");
            System.out.println();
            System.out.print(" Selecciona una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            Exam examenActual = new Exam();

            switch (opcion) {
                case 1:
                    System.out.println("Opcion elegida: Cargar Examen");
                    examenActual = cargarExamen();
                    if(examenActual != null){
                        mostrarOpcionesDespuesDeExamen(examenActual);
                    }               
                    break;

                case 2:
                    limpiarConsola();
                    System.out.println("Opcion elegida: Crear Examen");
                    examenActual = crearExamen();
                    limpiarConsola();

                    System.out.println("Opciones");
                    System.out.println(" 1. Guardar y dar examen");
                    System.out.println(" 2. Guardar y salir");
                    System.out.println(" 3. Dar examen sin guardar");
                    System.out.println(" 4. Salir al menu principal");
                    System.out.print("Selecciona una opcion: ");

                    int subOpcionCrear = leerEnteroEnRango(1, 4);

                    limpiarConsola();
                    switch (subOpcionCrear) {
                        case 1:
                            guardarExamen(examenActual);
                            darExamen(examenActual);
                            break;
                        case 2:
                            guardarExamen(examenActual);
                            System.out.println("Examen guardado. Regresando al menu principal...");
                            break;
                        case 3:
                            darExamen(examenActual);
                            break;
                        case 4:
                            System.out.println("Regresando al menu principal...");
                            break;
                    }
                    break;

                case 3:
                    limpiarConsola();
                    System.out.println("Opcion elegida: Salir");
                    System.out.println("Presiona Enter para salir...");
                    scanner.nextLine();
                    break;

                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
            }

            System.out.println();
        } while (opcion != 3);

        scanner.close();
    }

    private Exam cargarExamen() {
        System.out.println("\nCargando examen...");
        System.out.print("Introduce el nombre del examen: ");
        String nombreExamen = scanner.nextLine();
    
        Exam examen = Exam.cargarDeArchivo(nombreExamen);
        if (examen == null) {
            System.out.println("Error: No se pudo cargar el examen. Verifique el nombre del archivo.");
            return null;
        }
        System.out.println("Examen cargado exitosamente.");
        return examen;
    }

    private Exam crearExamen() {
        System.out.println();
        System.out.println("Creando examen...");
        CreadorExamen creador = new CreadorExamen(scanner);
        return creador.crearExamen();
    }

    private void darExamen(Exam examen) {
        limpiarConsola();
        System.out.println();
        System.out.println("Dando examen...");
        int puntajeObtenido = examen.darExam();
        mostrarResultados(puntajeObtenido, examen);
    }

    private void mostrarResultados(int puntajeObtenido, Exam examen) {
        int totalPreguntas = examen.getContadorPreguntas();
        double porcentaje = examen.calcularPorcentaje(puntajeObtenido);

        System.out.println();
        System.out.println("Resultados del Examen:");
        System.out.println("Puntaje Obtenido: " + puntajeObtenido + "/" + examen.getPuntajeTotal());
        System.out.println("Total Preguntas: " + totalPreguntas);
        System.out.println("Porcentaje de aciertos: " + String.format("%.2f", porcentaje) + "%");
    }

    private void guardarExamen(Exam examen) {
        System.out.println("\nGuardando examen...");
        System.out.print("Introduce el nombre del archivo para guardar el examen: ");
        String nombreArchivo = scanner.nextLine();
    
        try {
            examen.guardarEnArchivo(nombreArchivo);
            System.out.println("Examen guardado exitosamente como " + nombreArchivo);
        } catch (Exception e) {
            System.out.println("Error al guardar el examen: " + e.getMessage());
        }
    }

    private void mostrarOpcionesDespuesDeExamen(Exam examenActual) {
        if (examenActual == null) return;
        
        while (true) {
            System.out.println();
            System.out.println("Opciones");
            System.out.println(" 1. Dar examen");
            System.out.println(" 2. Salir al menu principal");
            System.out.print("Selecciona una opcion: ");
            
            try {
                int subOpcion = Integer.parseInt(scanner.nextLine().trim());
                
                if (subOpcion == 1) {
                    darExamen(examenActual);
                    break;
                } else if (subOpcion == 2) {
                    System.out.println("Regresando al menu principal...");
                    break;
                } else {
                    System.out.println("Opcion invalida. Por favor, selecciona 1 o 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un numero valido (1 o 2).");
            }
        }
    }

    private int leerEnteroEnRango(int min, int max) {
        while (true) {
            try {
                int opcion = Integer.parseInt(scanner.nextLine().trim());
                if (opcion >= min && opcion <= max) {
                    return opcion;
                } else {
                    System.out.println("Por favor, ingrese un numero entre " + min + " y " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un numero valido.");
            }
        }
    }
}
