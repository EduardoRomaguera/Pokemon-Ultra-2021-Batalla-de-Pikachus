package tarea.entities;

import java.util.Objects;

public class pokemon {
    private int puntosVida;
    private String nombre;
    private String tipo;
    private int peso;
    private int nivel;

    public pokemon() {
    }

    public pokemon(int puntosVida, String nombre, String tipo, int peso, int nivel) {
        this.puntosVida = puntosVida;
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
        this.nivel = nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pokemon pokemon = (pokemon) o;
        return getPuntosVida() == pokemon.getPuntosVida() && getPeso() == pokemon.getPeso() && getNivel() == pokemon.getNivel() && Objects.equals(getNombre(), pokemon.getNombre()) && Objects.equals(getTipo(), pokemon.getTipo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPuntosVida(), getNombre(), getTipo(), getPeso(), getNivel());
    }

    @Override
    public String toString() {
        return "pokemon{" +
                "puntosVida=" + puntosVida +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", peso=" + peso +
                ", nivel=" + nivel +
                '}';
    }
}
