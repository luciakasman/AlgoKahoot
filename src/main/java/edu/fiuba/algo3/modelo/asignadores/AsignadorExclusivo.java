package edu.fiuba.algo3.modelo.asignadores;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.Comparator;
import java.util.List;

public class AsignadorExclusivo implements Asignador{

    private int multiplicador;

    public AsignadorExclusivo(int multiplicador){
        this.multiplicador = multiplicador;
    }

    @Override
    public Asignador aplicarExclusividad(){
        return new AsignadorExclusivo(multiplicador * 2);
    }

    @Override
    public void asignarPuntos(List<Jugador> jugadores){
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);
        if (jugador1.obtenerPuntajeDePregunta() == jugador2.obtenerPuntajeDePregunta()){
            return;
        }
        Jugador jugadorExclusivo = jugadores.stream().max(Comparator.comparing(Jugador::obtenerPuntajeDePregunta)).get();
        int puntajeActual = jugadorExclusivo.obtenerPuntajeDePregunta();
        jugadorExclusivo.guardarPuntajeDePregunta(puntajeActual * multiplicador);
        jugadorExclusivo.asignarPuntajeTotal();
    }

}
