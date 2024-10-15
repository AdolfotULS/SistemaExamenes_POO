import java.util.Scanner;

public class Selec_Mul_Pregunta extends Pregunta {

    private String[] elecciones;
    private int respuestaCorrecta;

    public Selec_Mul_Pregunta(String texto, String[] elecciones, int respuestaCorrecta, int peso) {
        super(texto, peso); // 1. Llama al constructor de la clase padre

        if (elecciones == null || elecciones.length < 2) {
            // 2. Verifica que haya al menos 2 opciones
            throw new IllegalArgumentException("Debe haber al menos dos opciones.");
        }

        this.elecciones = elecciones; // 3. Inicializa las opciones
        this.respuestaCorrecta = respuestaCorrecta; // 3. Inicializa la respuesta correcta
    }

    @Override
    public boolean buscar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(getTexto()); // 1. Muestra el texto de la pregunta

        // 2. Muestra las opciones etiquetadas (a, b, c, ...)
        for (int i = 0; i < elecciones.length; i++) {
            System.out.println((char) ('a' + i) + ") " + elecciones[i]);
        }

        while (true) {
            try {
                System.out.println("Si deseas omitir la pregunta, ingresa '#'"); // 3. Informa sobre la opcion de omitir
                System.out.print("Su respuesta (a, b, c, ...): ");

                if (!scanner.hasNextLine()) {
                    System.out.println("Error: No se pudo leer la entrada del usuario.");
                    return false;
                }

                String respuestaUsuario = scanner.nextLine().trim().toLowerCase(); // 4. Lee la respuesta del usuario

                if (respuestaUsuario.equals("#")) { // 5. Verifica si el usuario desea omitir la pregunta
                    System.out.println("Pregunta omitida.");
                    return false;
                }

                if (respuestaUsuario.length() == 1 &&
                        respuestaUsuario.charAt(0) >= 'a' &&
                        respuestaUsuario.charAt(0) < 'a' + elecciones.length) {

                    int indiceRespuestaUsuario = respuestaUsuario.charAt(0) - 'a'; // 6. Convierte la respuesta a un
                                                                                   // indice numerico

                    if (indiceRespuestaUsuario == respuestaCorrecta) { // 7. Compara el indice con la respuesta correcta
                        System.out.println("Correcto"); // 8. Muestra "Correcto" si la respuesta es correcta
                        return true;
                    } else {
                        System.out.println(
                                "Incorrecto. La respuesta correcta es: " + (char) ('a' + respuestaCorrecta) + ") "
                                        + elecciones[respuestaCorrecta]);
                        return false; // 9. Muestra "Incorrecto" y la respuesta correcta si la respuesta es incorrecta
                    }
                } else {
                    System.out.println("Respuesta invalida. Por favor, ingrese una letra entre 'a' y '" +
                            (char) ('a' + elecciones.length - 1) + "'.");
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Error: Entrada vacia. Por favor, ingrese una respuesta valida.");
            } catch (IllegalStateException e) {
                System.out.println("Error: El scanner ha sido cerrado inesperadamente.");
                return false;
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                System.out.println("Por favor, intente nuevamente.");
            }
        }
    }

    public String[] getElecciones() {
        return elecciones; // Devuelve el array de opciones
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta; // Devuelve el indice de la respuesta correcta
    }
}