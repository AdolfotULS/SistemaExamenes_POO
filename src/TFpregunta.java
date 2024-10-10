import java.util.Scanner;

public class TFpregunta extends Pregunta {
    private boolean respuestaCorrecta;

    // Constructor
    public TFpregunta(String texto, boolean respuestaCorrecta, int peso) {
        super(texto, peso);
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public boolean buscar() {
        Scanner scanner = new Scanner(System.in);
        boolean respuestaUsuario;
        
        while (true) {
            // Muestra el texto de la pregunta
            System.out.println(getTexto());
            // Informa al usuario sobre la opcion de no responder
            System.out.println("[!] Si desea no responder, ingrese #.");
            // Solicita la respuesta al usuario
            System.out.print("Ingrese 't' para Verdadero o 'f' para Falso: ");
            String entrada = scanner.nextLine().toLowerCase();
            
            // Verifica la respuesta del usuario
            if (entrada.equals("t") || entrada.equals("f")) {
                respuestaUsuario = entrada.equals("t");
                break; // Sale del bucle si la respuesta es valida
            } else if (entrada.equals("#")) {
                return false; // Retorna falso si el usuario decide no responder
            } else {
                // Mensaje de error para respuestas invalidas
                System.out.println("Respuesta invalida. Por favor, ingrese 't' o 'f'.");
            }
        }
        
        // Compara la respuesta del usuario con la respuesta correcta
        boolean esCorrecta = (respuestaUsuario == respuestaCorrecta);
        
        // Muestra el resultado al usuario
        if (esCorrecta) {
            System.out.println("¡Correcto!");
        } else {
            System.out.println("Incorrecto. La respuesta correcta es: " + 
                               (respuestaCorrecta ? "Verdadero" : "Falso"));
        }
        
        // Retorna el resultado de la pregunta
        return esCorrecta;
    }
}
