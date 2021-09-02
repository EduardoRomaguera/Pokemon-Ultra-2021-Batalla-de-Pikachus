package tarea.entities.pikachu;

import tarea.entities.IPokemon;
import tarea.entities.pokemon;

public class pikachu extends pokemon implements IPokemon {

    public pikachu() {
    }

    public pikachu(int puntosVida, String nombre, String tipo, int peso, int nivel) {
        super(puntosVida, nombre, tipo, peso, nivel);
    }

    @Override
    public void hit(int hit) {
        setPuntosVida(getPuntosVida()-hit);
    }

    @Override
    public void subirNivel() {
        int nivel = getNivel()+1;
        if (nivel>5){
            nivel=5;
        }
        setNivel(nivel);
    }

    @Override
    public void curar() {
        setPuntosVida(getPuntosVida()+getNivel());
    }
}
