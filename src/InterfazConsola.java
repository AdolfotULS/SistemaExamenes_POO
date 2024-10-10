import java.util.Scanner;

public class InterfazConsola {

    public static void main(String[] args) {
        mostrarMenu();
    }

    static void mostrarMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(" ~~ Menu Principal  ~~ ");
            System.out.println(" Opciones:");
            System.out.println(" 1. Cargar Examen");
            System.out.println(" 2. Crear Examen");
            System.out.println(" 3. Sistema Crear Examen Usuario");
            System.out.println(" 4. Salir del programa");
            System.out.print(" Selecciona una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch(opcion) {
                case 1:
                    System.out.println("Opcion elegida: Cargar Examen");
                    cargarExamen();
                    break;

                case 2:
                    System.out.println("Opcion elegida: Crear Examen");
                    crearExamen(scanner);
                    break;
                    
                case 3:
                    System.out.println("Opcion elegida: Sistema Crear Examen Usuario");
                    sistemaCrearExamenUsuario(scanner);
                    break;

                case 4:
                    System.out.println("Opcion elegida: Salir");
                    System.out.println("Presiona Enter para salir...");
                    scanner.nextLine(); 
                    break;

                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
            }

            System.out.println();

        } while(opcion != 4);

        scanner.close();
    }

    private static void cargarExamen(){
        // Lógica de cargar Examen
        System.out.println("Cargando examen...");
    }

    private static void crearExamen(Scanner scanner){
        // Lógica de crear Examen
        System.out.println("Creando examen...");
    }

       private static void darExamen(){
        // Lógica para dar examen
        System.out.println("Dando examen...");
    }
    
    private static void sistemaCrearExamenUsuario(Scanner scanner) {
        System.out.println("Examen creado.");
        System.out.println("1. Tomar Examen");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        if (opcion == 1) {
            darExamen();
        } else {
            System.out.println("Saliendo...");
        }
    }
}
