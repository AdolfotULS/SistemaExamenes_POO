/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SheratoD
 */
public abstract class Pregunta {
    public int peso;
    String texto;

    public Pregunta(String texto, int peso) {
        this.peso = peso;
        this.texto = texto;
    }

    public int getPeso() {
        return peso;
    }

    public String getTexto() {
        return texto;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    abstract boolean buscar();
}
