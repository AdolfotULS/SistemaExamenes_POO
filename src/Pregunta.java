/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SheratoD
 */
public abstract class Pregunta {
    // El peso de la pregunta es protected para permitir acceso desde las subclases
    protected int peso;
    // El texto de la pregunta es private ya que no necesita ser modificado
    private String texto;

    public Pregunta(String texto, int peso) {
        this.texto = texto;
        this.peso = peso;
    }

    // Obtiene el peso de la pregunta.
    public int getPeso() {
        return peso;
    }

    // Establece el peso de la pregunta.=
    public void setPeso(int peso) {
        this.peso = peso;
    }

    // Obtiene el texto de la pregunta.
    public String getTexto() {
        return texto;
    }

    /**
     * Método abstracto que debe ser implementado por las subclases.
     * Este método se encargará de pedir la pregunta, leer la respuesta del usuario
     * y determinar si la respuesta es correcta.
     */
    public abstract boolean buscar();
}