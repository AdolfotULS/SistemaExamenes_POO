import java.util.Scanner;

public class Resp_Cortas_Pregunta extends Pregunta {

    private String respuestaCorrecta;

    public Resp_Cortas_Pregunta(String texto, String respuestaCorrecta, int peso) {

        super(texto, peso); // Llama al constructor de la clase padre con los parametros texto y peso
        this.respuestaCorrecta = respuestaCorrecta; // Inicializa el atributo respuestaCorrecta
    }

    @Override
    public boolean buscar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(getTexto()); // 1. Muestra el texto de la pregunta
                System.out.println("Si deseas omitir la pregunta, ingresa '#'");
                System.out.print("Su respuesta: ");

                if (!scanner.hasNextLine()) {
                    System.out.println("Error: No se pudo leer la entrada del usuario.");
                    return false;
                }

                String respuestaUsuario = scanner.nextLine().trim(); // 3. Lee la respuesta del usuario

                if (respuestaUsuario.equals("#")) { // 4. Verifica si el usuario desea omitir la pregunta
                    System.out.println("Pregunta omitida.");
                    return false;
                }

                if (respuestaUsuario.equalsIgnoreCase(respuestaCorrecta)) { // 5. Compara la respuesta con la respuesta
                                                                            // correcta
                    System.out.println("Correcto."); // 6. Muestra "Correcto" si la respuesta es correcta
                    return true;
                } else {
                    // 7. Muestra "Incorrecto" y la respuesta correcta si la respuesta es incorrecta
                    System.out.println("Incorrecto. La respuesta correcta es: " + respuestaCorrecta);
                    return false;
                }
            } catch (IllegalStateException e) {
                System.out.println("Error: El scanner ha sido cerrado inesperadamente.");
                return false;
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                System.out.println("Por favor, intente nuevamente.");
            }
        }
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta; // Devuelve la respuesta correcta
    }
}