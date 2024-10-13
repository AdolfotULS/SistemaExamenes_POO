public class Resp_Cortas_Pregunta extends Pregunta {

    private String respuestaCorrecta;

    public Resp_Cortas_Pregunta(String texto, String respuestaCorrecta, int peso) {
        
        super(texto, peso); // Llama al constructor de la clase padre con los parámetros texto y peso
        this.respuestaCorrecta = respuestaCorrecta; // Inicializa el atributo respuestaCorrecta
    }
}

@Override
public boolean buscar() {
    System.out.println(getTexto()); // 1. Muestra el texto de la pregunta
    System.out.println("Si deseas omitir la pregunta, ingresa '#'");

    Scanner scanner = new Scanner(System.in);
    String respuestaUsuario = scanner.nextLine(); // 3. Lee la respuesta del usuario

    if (respuestaUsuario.equals("#")) { // 4. Verifica si el usuario desea omitir la pregunta
        System.out.println("Pregunta omitida.");
        return false;
    }

    if (respuestaUsuario.equalsIgnoreCase(respuestaCorrecta)) { // 5. Compara la respuesta con la respuesta correcta
        System.out.println("Correcto"); // 6. Muestra "Correcto" si la respuesta es correcta
        return true;
    } else {
        System.out.println("Incorrecto. La respuesta correcta es: " + respuestaCorrecta); // 7. Muestra "Incorrecto" y la respuesta correcta si la respuesta es incorrecta
        return false;
    }
}


public String getRespuestaCorrecta() {
    return respuestaCorrecta; // Devuelve la respuesta correcta
}
