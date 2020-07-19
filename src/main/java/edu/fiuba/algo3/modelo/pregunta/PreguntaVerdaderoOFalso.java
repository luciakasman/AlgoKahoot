package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.List;

public class PreguntaVerdaderoOFalso extends Pregunta {

    public PreguntaVerdaderoOFalso(String pregunta, List<String> opciones, List<String> opcionesCorrectas) {
        super(pregunta, opciones, opcionesCorrectas);
    }

    public String obtenerOpcionCorrecta() {
        return super.opcionesCorrectas.get(0);
    }

    public void asignarPuntaje(Jugador jugador, List<String> respuestas){
        int puntaje = opcionesCorrectas.get(0).equals(respuestas.get(0)) ? 1 : 0;
        jugador.asignarPuntaje(puntaje);
    }
}