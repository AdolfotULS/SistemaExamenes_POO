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
            System.out.println(getTexto());
            System.out.println("[!] Si desea no responder, ingrese #.");
            System.out.print("Ingrese 't' para Verdadero o 'f' para Falso: ");
            String entrada = scanner.nextLine().trim().toLowerCase();
            
            if (entrada.equals("#")) {
                System.out.println("Pregunta omitida.");
                return false;
            } else if (entrada.equals("t") || entrada.equals("f")) {
                boolean respuestaUsuario = entrada.equals("t");
                boolean esCorrecta = (respuestaUsuario == respuestaCorrecta);
                
                System.out.println(esCorrecta ? "¡Correcto!" : "Incorrecto. La respuesta correcta es: " + 
                                   (respuestaCorrecta ? "Verdadero" : "Falso"));
                
                return esCorrecta;
            } else {
                System.out.println("Respuesta invalida. Por favor, ingrese 't' o 'f'.");
            }
        }
    }

    public boolean getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}