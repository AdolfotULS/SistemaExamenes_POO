/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SheratoD
 */
import java.util.Scanner;

public class TFpregunta extends Pregunta {
    public boolean respuestaCorrecta;

    public TFpregunta(String texto, boolean respuestaCorrecta, int peso) {
        super(peso, texto);
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    public boolean buscar() {
        Scanner scanner = new Scanner(System.in);
        boolean respuestaUsuario;
        
        try {
            while (true) {
                System.out.println(getTexto());
                System.out.print("Ingrese 't' para Verdadero o 'f' para Falso: ");
                String entrada = scanner.nextLine().toLowerCase();

                if (entrada.equals("t") || entrada.equals("f")
                        || entrada.equals("T") || entrada.equals("f")) {
                    respuestaUsuario = entrada.equals("t") || entrada.equals("T");
                    break;
                } else {
                    System.out.println("Respuesta invAlida. Por favor, ingrese 't' o 'f'.");
                }
            }
        } finally {}
        return false;
    }
}
