import java.util.Scanner;

public class InterfazConsola {
    private Scanner scanner;

    public InterfazConsola() {
        this.scanner = new Scanner(System.in);
    }

    private void limpiarConsola(){ //Creo que no funciona XD
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
            
            switch(opcion) {
                case 1:
                    System.out.println("Opcion elegida: Cargar Examen");
                    examenActual = cargarExamen();
                    mostrarOpcionesDespuesDeExamen(examenActual);
                    break;
                    
                case 2:
                    System.out.println("Opcion elegida: Crear Examen");
                    examenActual = crearExamen();
                    limpiarConsola();
                    
                    System.out.println("Opciones");
                    System.out.println(" 1. Guardar y dar examen");
                    System.out.println(" 2. Guardar y salir");
                    System.out.println(" 3. Dar examen sin guardar");
                    System.out.println(" 4. Salir al menu principal");
                    System.out.print("Selecciona una opcion: ");
                    
                    int subOpcionCrear = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (subOpcionCrear == 1) {
                        guardarExamen(examenActual);
                        darExamen(examenActual);
                        limpiarConsola();
                    } else if (subOpcionCrear == 2) {
                        guardarExamen(examenActual);
                        System.out.println("Examen guardado. Regresando al menu principal...");
                    } else if (subOpcionCrear == 3) {
                        darExamen(examenActual);
                        limpiarConsola();
                    } else if (subOpcionCrear == 4) {
                        System.out.println("Regresando al menu principal...");
                    } else {
                        System.out.println("Opcion invalida. Intenta nuevamente.");
                    }
                    break;
                    
                case 3:
                    System.out.println("Opcion elegida: Salir");
                    System.out.println("Presiona Enter para salir...");
                    scanner.nextLine();
                    break;
                    
                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
            }

            System.out.println();

        } while(opcion != 3);

        scanner.close();
    }

    private Exam cargarExamen() { 
        System.out.println();
        System.out.println("Cargando examen...");
        System.out.println("Introduce el nombre del examen: ");
        String nombreExamen = scanner.nextLine();
           
        return Exam.cargarDeArchivo(nombreExamen);
    }

    private Exam crearExamen() { 
        System.out.println();
        System.out.println("Creando examen...");
        CreadorExamen creador = new CreadorExamen(scanner);
        return creador.crearExamen();
    }

    private void darExamen(Exam examen) { 
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
        System.out.println("Puntaje Obtenido: " + puntajeObtenido);
        System.out.println("Total Preguntas: " + totalPreguntas);
        System.out.println("Porcentaje de aciertos: " + String.format("%.2f", porcentaje) + "%");
    }
    
private void guardarExamen(Exam examen) {
    System.out.println();
    System.out.println("Guardando examen...");
    System.out.print("Introduce el nombre del archivo para guardar el examen: ");
    String nombreArchivo = scanner.nextLine(); // Solicita el nombre del archivo al usuario

    examen.guardarEnArchivo(nombreArchivo); // Pasa el nombre del archivo al método
    System.out.println("Examen guardado exitosamente como " + nombreArchivo);
}

    
    private void mostrarOpcionesDespuesDeExamen(Exam examenActual) {
        System.out.println();
        System.out.println("Opciones");
        System.out.println(" 1. Dar examen");
        System.out.println(" 2. Salir al menu principal");
        System.out.print("Selecciona una opcion: ");
        int subOpcion = scanner.nextInt();
        scanner.nextLine();

        if (subOpcion == 1) {
            darExamen(examenActual);
            limpiarConsola();
        } else if (subOpcion == 2) {
            System.out.println("Regresando al menu principal...");
        } else {
            System.out.println("Opcion invalida. Intenta nuevamente.");
        }
    }
}
