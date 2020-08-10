package edu.fiuba.algo3.modelo.asignadores;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.List;

public class AsignadorComun implements Asignador{

    @Override
    public Asignador aplicarExclusividad(){
        return new AsignadorExclusivo(2);
    }

    @Override
    public void asignarPuntos(List<Jugador> jugadores){
        jugadores.stream().forEach(Jugador::asignarPuntajeTotal);
    }

}
