import java.util.Scanner;

public class InterfazConsola {
    // Scanner para leer la entrada del usuario desde la consola
    private Scanner scanner;

    // Constructor que inicializa el Scanner
    public InterfazConsola() {
        this.scanner = new Scanner(System.in);
    }

    // Metodo que "limpia" la consola imprimiendo varias lineas vacias
    private void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // Metodo que muestra el menu principal y gestiona las opciones del usuario
    public void mostrarMenu() {
        int opcion;

        do {
            try {
                // Muestra el menu principal
                System.out.println("\n===== Menu Principal =====\n");
                System.out.println("Opciones:");
                System.out.println("1. Cargar Examen");
                System.out.println("2. Crear Examen");
                System.out.println("3. Salir del programa");
                System.out.print("\nSelecciona una opcion: ");

                // Lee la opcion del usuario y valida que este en el rango adecuado
                opcion = leerEnteroEnRango(1, 3);

                Exam examenActual; // Variable para almacenar el examen actual

                // Segun la opcion elegida, realiza la accion correspondiente
                switch (opcion) {
                    case 1:
                        limpiarConsola();
                        System.out.println("Opcion elegida: Cargar Examen");
                        // Carga un examen desde un archivo
                        examenActual = cargarExamen();
                        if (examenActual != null) {
                            // Si el examen fue cargado exitosamente, muestra mas opciones
                            mostrarOpcionesDespuesDeExamen(examenActual);
                        }
                        break;

                    case 2:
                        limpiarConsola();
                        System.out.println("Opcion elegida: Crear Examen");
                        // Crea un nuevo examen
                        examenActual = crearExamen();
                        limpiarConsola();

                        // Submenu para las opciones despues de crear un examen
                        System.out.println("Opciones:");
                        System.out.println("1. Guardar y dar examen");
                        System.out.println("2. Guardar y salir");
                        System.out.println("3. Dar examen sin guardar");
                        System.out.println("4. Salir al menu principal");
                        System.out.print("Selecciona una opcion: ");

                        int subOpcionCrear = leerEnteroEnRango(1, 4); // Lee y valida la opcion

                        limpiarConsola();
                        // Realiza la accion correspondiente a la opcion elegida
                        switch (subOpcionCrear) {
                            case 1:
                                guardarExamen(examenActual); // Guarda el examen y lo presenta
                                darExamen(examenActual);
                                break;
                            case 2:
                                guardarExamen(examenActual); // Guarda el examen y vuelve al menu principal
                                System.out.println("Examen guardado. Regresando al menu principal...");
                                break;
                            case 3:
                                darExamen(examenActual); // Solo presenta el examen sin guardarlo
                                break;
                            case 4:
                                System.out.println("Regresando al menu principal...");
                                break;
                        }
                        break;

                    case 3:
                        limpiarConsola();
                        System.out.println("Opcion elegida: Salir");
                        // Opcion para salir del programa
                        System.out.println("Gracias por usar el programa. Hasta luego!");
                        return; // Sale del bucle y finaliza el programa
                }
            } catch (Exception e) {
                // Maneja errores inesperados, limpia la consola y muestra un mensaje de error
                limpiarConsola();
                System.out.println("Error inesperado: " + e.getMessage());
                System.out.println("Por favor, intenta de nuevo.\n");
                opcion = 0; // Reinicia el valor de opcion para que vuelva a mostrar el menu
            }
        } while (true); // Ciclo infinito que repite el menu hasta que el usuario salga
    }

    // Metodo para cargar un examen desde un archivo
    private Exam cargarExamen() {
        System.out.println("\nCargando examen...");
        System.out.print("Introduce el nombre del examen: ");
        String nombreExamen = scanner.nextLine(); // Lee el nombre del archivo

        Exam examen = Exam.cargarDeArchivo(nombreExamen); // Intenta cargar el examen
        if (examen == null) {
            // Si el examen no se pudo cargar, muestra un mensaje de error
            System.out.println("Error: No se pudo cargar el examen. Verifique el nombre del archivo.");
            return null;
        }
        System.out.println("Examen cargado exitosamente.");
        return examen; // Retorna el examen cargado
    }

    // Metodo para crear un examen utilizando la clase CreadorExamen
    private Exam crearExamen() {
        System.out.println();
        System.out.println("Creando examen...");
        CreadorExamen creador = new CreadorExamen(scanner); // Crea una instancia de CreadorExamen
        return creador.crearExamen(); // Retorna el examen creado
    }

    // Metodo para presentar el examen al usuario y obtener el puntaje
    private void darExamen(Exam examen) {
        limpiarConsola();
        System.out.println();
        System.out.println("Dando examen...");
        int puntajeObtenido = examen.darExam(); // Ejecuta el examen y obtiene el puntaje
        mostrarResultados(puntajeObtenido, examen); // Muestra los resultados del examen
    }

    // Metodo para mostrar los resultados del examen
    private void mostrarResultados(int puntajeObtenido, Exam examen) {
        int totalPreguntas = examen.getContadorPreguntas(); // Obtiene el total de preguntas
        double porcentaje = examen.calcularPorcentaje(puntajeObtenido); // Calcula el porcentaje de aciertos

        System.out.println();
        System.out.println("Resultados del Examen:");
        System.out.println("Puntaje Obtenido: " + puntajeObtenido + "/" + examen.getPuntajeTotal());
        System.out.println("Total Preguntas: " + totalPreguntas);
        System.out.println("Porcentaje de aciertos: " + String.format("%.2f", porcentaje) + "%");
    }

    // Metodo para guardar el examen en un archivo
    private void guardarExamen(Exam examen) {
        System.out.println("\nGuardando examen...");
        System.out.print("Introduce el nombre del archivo para guardar el examen: ");
        String nombreArchivo = scanner.nextLine(); // Lee el nombre del archivo

        try {
            examen.guardarEnArchivo(nombreArchivo); // Guarda el examen en el archivo
            System.out.println("Examen guardado exitosamente como " + nombreArchivo);
        } catch (Exception e) {
            // Muestra un mensaje de error si ocurre algun problema al guardar
            System.out.println("Error al guardar el examen: " + e.getMessage());
        }
    }

    // Metodo que muestra opciones adicionales despues de cargar un examen
    private void mostrarOpcionesDespuesDeExamen(Exam examenActual) {
        if (examenActual == null)
            return; // Si no hay examen, no muestra nada

        while (true) {
            System.out.println();
            System.out.println("Opciones");
            System.out.println(" 1. Dar examen");
            System.out.println(" 2. Salir al menu principal");
            System.out.print("Selecciona una opcion: ");

            try {
                int subOpcion = Integer.parseInt(scanner.nextLine().trim()); // Lee la opcion del usuario

                if (subOpcion == 1) {
                    darExamen(examenActual); // Si elige 1, presenta el examen
                    break;
                } else if (subOpcion == 2) {
                    // Si elige 2, vuelve al menu principal
                    System.out.println("Regresando al menu principal...");
                    break;
                } else {
                    // Maneja la seleccion de una opcion invalida
                    System.out.println("Opcion invalida. Por favor, selecciona 1 o 2.");
                }
            } catch (NumberFormatException e) {
                // Maneja errores si el usuario no ingresa un numero valido
                System.out.println("Por favor, ingresa un numero valido (1 o 2).");
            }
        }
    }

    // Metodo para leer un entero que este en el rango especificado (min, max)
    private int leerEnteroEnRango(int min, int max) {
        while (true) {
            try {
                int opcion = Integer.parseInt(scanner.nextLine().trim()); // Lee el valor como entero
                if (opcion >= min && opcion <= max) {
                    return opcion; // Retorna el valor si esta dentro del rango
                } else {
                    // Muestra un mensaje de error si esta fuera del rango
                    System.out.println("Por favor, ingrese un numero entre " + min + " y " + max);
                }
            } catch (NumberFormatException e) {
                // Muestra un mensaje de error si la entrada no es un numero valido
                System.out.println("Por favor, ingrese un numero valido.");
            }
        }
    }
}
