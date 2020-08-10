package edu.fiuba.algo3.modelo.asignadores;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.List;

public interface Asignador {

    Asignador aplicarExclusividad();

    void asignarPuntos(List<Jugador> jugadores);
}
