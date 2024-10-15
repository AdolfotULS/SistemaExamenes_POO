import java.util.Scanner;

public class InterfazConsola {
    private Scanner scanner;

    public InterfazConsola() {
        this.scanner = new Scanner(System.in);
    }
    
    public void mostrarMenu(){
        int opcion;

        do {
            System.out.println(" Menu Principal ");
            System.out.println(" Opciones:");
            System.out.println(" 1. Cargar Examen");
            System.out.println(" 2. Crear Examen");
            System.out.println(" 3. Salir del programa");
            System.out.print(" Selecciona una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            Exam examenActual = new Exam(); // EXAMEN cargado en la memoria
            
            switch(opcion) {
                case 1:
                    System.out.println("Opcion elegida: Cargar Examen");
                    examenActual = cargarExamen();

                    if (opcion == 1 || opcion == 2) {
                        System.out.println("Opciones");
                        System.out.println(" 1. Dar examen");
                        System.out.println(" 2. Salir al menu principal");
                        System.out.print("Selecciona una opcion: ");
                        int subOpcion = scanner.nextInt();
                        scanner.nextLine();

                        if (subOpcion == 1) {
                            darExamen(examenActual);
                        } else if (subOpcion == 2) {
                            System.out.println("Regresando al menu principal...");
                        } else {
                            System.out.println("Opcion invalida. Intenta nuevamente.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Opcion elegida: Crear Examen");
                    examenActual = crearExamen(); 

                    System.out.println("Opciones");
                    System.out.println(" 1. Dar examen");
                    System.out.println(" 2. Salir al menu principal");
                    System.out.print("Selecciona una opcion: ");
                    int subOpcion = scanner.nextInt();
                    scanner.nextLine();

                    if (subOpcion == 1) {
                        darExamen(examenActual); 
                    } else if (subOpcion == 2) {
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

    private Exam cargarExamen(){ 
        System.out.println("Cargando examen...");
        System.out.println("Introduce el nombre del examen: ");
        String nombreExamen = scanner.nextLine();
           
        return Exam.cargarDeArchivo(nombreExamen); //nombre proporcionado
    }

    private Exam crearExamen(){ 
        System.out.println("Creando examen...");
        CreadorExamen creador = new CreadorExamen(scanner);
        return creador.crearExamen();
    }

    private void darExamen(Exam examen){ 
        System.out.println("Dando examen...");
        int puntajeObtenido = examen.darExam();
        mostrarResultados(puntajeObtenido, examen);
    }
    
    private void mostrarResultados(int puntajeObtenido, Exam examen) {
        int totalPreguntas = examen.getContadorPreguntas(); 
        double porcentaje = examen.calcularPorcentaje(puntajeObtenido);

        System.out.println("Resultados del Examen:");
        System.out.println("Puntaje Obtenido: " + puntajeObtenido);
        System.out.println("Total Preguntas: " + totalPreguntas);
        System.out.println("Porcentaje de aciertos: " + String.format("%.2f", porcentaje) + "%");
    }
}
