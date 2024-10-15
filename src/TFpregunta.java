import java.util.Scanner;

public class TFpregunta extends Pregunta {
    private boolean respuestaCorrecta;

    public TFpregunta(String texto, boolean respuestaCorrecta, int peso) {
        super(texto, peso);
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public boolean buscar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(getTexto()); // 1. Muestra el texto de la pregunta
                System.out.println("Si deseas omitir la pregunta, ingresa '#'"); // 2. Informa sobre la opcion de omitir
                System.out.print("Ingrese 't' para Verdadero o 'f' para Falso: "); // 3. Solicita la respuesta al
                                                                                   // usuario

                if (!scanner.hasNextLine()) {
                    System.out.println("Error: No se pudo leer la entrada del usuario.");
                    return false;
                }

                String entrada = scanner.nextLine().trim().toLowerCase(); // 4. Lee y procesa la respuesta del usuario

                if (entrada.equals("#")) { // 5. Verifica si el usuario desea omitir la pregunta
                    System.out.println("Pregunta omitida.");
                    return false;
                } else if (entrada.equals("t") || entrada.equals("f")) { // 6. Verifica si la respuesta es valida
                    boolean respuestaUsuario = entrada.equals("t");
                    boolean esCorrecta = (respuestaUsuario == respuestaCorrecta); // 7. Compara la respuesta con la
                                                                                  // respuesta correcta

                    System.out.println(esCorrecta ? "¡Correcto!"
                            : "Incorrecto. La respuesta correcta es: " +
                                    (respuestaCorrecta ? "Verdadero" : "Falso")); // 8. Muestra el resultado al usuario

                    return esCorrecta; // 9. Retorna el resultado de la pregunta
                } else {
                    System.out.println("Respuesta invalida. Por favor, ingrese 't' o 'f'."); // 10. Maneja respuestas
                                                                                             // invalidas
                }
            } catch (IllegalStateException e) { // 11. Maneja excepcion por cierre inesperado del scanner
                System.out.println("Error: El scanner ha sido cerrado inesperadamente.");
                return false;
            } catch (Exception e) { // 12. Maneja otras excepciones inesperadas
                System.out.println("Error inesperado: " + e.getMessage());
                System.out.println("Por favor, intente nuevamente.");
            }
        }
    }

    public boolean getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}