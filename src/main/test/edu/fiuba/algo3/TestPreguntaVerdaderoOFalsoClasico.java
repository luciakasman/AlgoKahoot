package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoOFalso;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPreguntaVerdaderoOFalsoClasico {

    PreguntaVerdaderoOFalso pregunta;
    String preguntaAHacer;
    String opcionCorrecta;

    void setUp() {
        opcionCorrecta = "verdadero";
        String opcionIncorrecta = "falso";
        preguntaAHacer = "Estamos hechxs de torta?";
        List<String> opciones = new LinkedList<>();
        List<String> opcionesCorrectas = new LinkedList<>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        opcionesCorrectas.add(opcionCorrecta);

        pregunta = new PreguntaVerdaderoOFalso(preguntaAHacer, opciones, opcionesCorrectas);
    }

    @Test
    void testPuedeCrearseIndicandoleRespuestaCorrecta() {
        setUp();

        assertEquals(preguntaAHacer, pregunta.obtenerPregunta());

        assertEquals(opcionCorrecta, pregunta.obtenerOpcionCorrecta());
    }

    @Test
    void testRecibeRespuestasYAsignaPuntos() {
        setUp();

        Jugador jugadorUno = new Jugador("Lucia");
        Jugador jugadorDos = new Jugador("Alan");

        List<String> respuestasJugadorUno = new LinkedList<>();
        List<String> respuestasJugadorDos = new LinkedList<>();
        respuestasJugadorUno.add("verdadero");
        respuestasJugadorDos.add("falso");

        pregunta.asignarPuntaje(jugadorUno, respuestasJugadorUno);
        pregunta.asignarPuntaje(jugadorDos, respuestasJugadorDos);

        assertEquals(1, jugadorUno.obtenerPuntaje());
        assertEquals(0, jugadorDos.obtenerPuntaje());
    }
}
