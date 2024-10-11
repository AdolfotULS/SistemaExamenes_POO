public class Selec_Mul_Pregunta extends Pregunta {
    private String[] elecciones;
    private int respuestaCorrecta;

    public Selec_Mul_Pregunta(String texto, String[] elecciones, int respuestaCorrecta, int peso) {
        // TODO: Implementar constructor
        // 1. Llamar al constructor de la clase padre (Pregunta) con texto y peso
        // 2. Verificar que elecciones tiene al menos 2 elementos, si no, lanzar IllegalArgumentException
        // 3. Inicializar elecciones y respuestaCorrecta
    }

    @Override
    public boolean buscar() {
        // TODO: Implementar método buscar
        // 1. Mostrar el texto de la pregunta (usar getTexto())
        // 2. Mostrar las opciones etiquetadas como a), b), c), etc.
        // 3. Informar al usuario que puede omitir la pregunta ingresando "#"
        // 4. Solicitar y leer la respuesta del usuario
        // 5. Si la respuesta es "#", informar que la pregunta fue omitida y retornar false
        // 6. Convertir la respuesta del usuario (a, b, c, ...) al índice correspondiente
        // 7. Comparar el índice de la respuesta del usuario con respuestaCorrecta
        // 8. Mostrar mensaje de "Correcto" o "Incorrecto" según corresponda
        // 9. Si es incorrecto, mostrar la opción correcta
        // 10. Retornar true si la respuesta es correcta, false si no lo es

        return false; // Placeholder return, reemplazar con la lógica correcta
    }

    public String[] getElecciones() {
        // TODO: Implementar getter para elecciones
        return null; // Placeholder return, reemplazar con el return correcto
    }

    public int getRespuestaCorrecta() {
        // TODO: Implementar getter para respuestaCorrecta
        return 0; // Placeholder return, reemplazar con el return correcto
    }
}