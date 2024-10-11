public class Resp_Cortas_Pregunta extends Pregunta {
    private String respuestaCorrecta;

    public Resp_Cortas_Pregunta(String texto, String respuestaCorrecta, int peso) {
        // TODO: Implementar constructor
        // 1. Llamar al constructor de la clase padre (Pregunta) con texto y peso
        // 2. Inicializar respuestaCorrecta
    }

    @Override
    public boolean buscar() {
        // TODO: Implementar método buscar
        // 1. Mostrar el texto de la pregunta (usar getTexto())
        // 2. Informar al usuario que puede omitir la pregunta ingresando "#"
        // 3. Solicitar y leer la respuesta del usuario
        // 4. Si la respuesta es "#", informar que la pregunta fue omitida y retornar false
        // 5. Comparar la respuesta del usuario con respuestaCorrecta usando equalsIgnoreCase
        // 6. Mostrar mensaje de "Correcto" o "Incorrecto" según corresponda
        // 7. Si es incorrecto, mostrar la respuesta correcta
        // 8. Retornar true si la respuesta es correcta, false si no lo es

        return false; // Placeholder return, reemplazar con la lógica correcta
    }

    public String getRespuestaCorrecta() {
        // TODO: Implementar getter para respuestaCorrecta
        return null; // Placeholder return, reemplazar con el return correcto
    }
}