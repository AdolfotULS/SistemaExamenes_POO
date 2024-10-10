import java.util.Scanner;

public class InterfazConsola {
    private Scanner scanner;

    public InterfazConsola() {
        this.scanner = new Scanner(System.in);
    }
    
    public void mostrarMenu(){
        int opcion;

        do {
            System.out.println(" ~~ Menu Principal  ~~ ");
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
                    // Luego Dar la OPcion de Slair del Programa
                    // O Dar Examen
                    break;
                case 2:
                    System.out.println("Opcion elegida: Crear Examen");
                    examenActual = crearExamen(); // SISTEMA DE USUSARIO PARA CREAR EXAMEN
                    // Luego Dar la OPcion de Slair del Programa
                    // O Dar Examen
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

    private Exam cargarExamen(){ // FALTA
        // Lógica de cargar Examen
        System.out.println("Cargando examen...");
        // Pedir al ususario el nombre del examen
        String nombreExamen = ""; // Falta logica del pedirsela al usuario
        return Exam.cargarDeArchivo(nombreExamen);
    }

    private Exam crearExamen(){ // LISTO
        System.out.println("Creando examen...");
        CreadorExamen creador = new CreadorExamen(scanner);
        return creador.crearExamen();
    }

    private void darExamen(Exam examen){ // LISTO
        System.out.println("Dando examen...");
        int puntajeObtenido = examen.darExam();
        mostrarResultados(puntajeObtenido, examen);
    }
    
    private void mostrarResultados(int puntajeObtenido, Exam examen) {
        // MOSTRAR PUNTAJE, PORCENTAJE DE BUENAS
    }
}
