package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoOFalso;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPreguntaVerdaderoOFalsoClasico {

    @Test
    void testPuedeCrearseIndicandoleRespuestaCorrecta() {

        String opcionCorrecta = "verdadero";
        String opcionIncorrecta = "falso";
        String preguntaAHacer = "Estamos hechxs de torta?";
        List<String> opciones = new LinkedList<>();
        List<String> opcionesCorrectas = new LinkedList<>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        opcionesCorrectas.add(opcionCorrecta);

        PreguntaVerdaderoOFalso pregunta = new PreguntaVerdaderoOFalso(preguntaAHacer, opciones, opcionesCorrectas);

        assertEquals(preguntaAHacer, pregunta.obtenerPregunta());

        assertEquals(opcionCorrecta, pregunta.obtenerOpcionCorrecta());
    }

    @Test
    void testRecibeRespuestasYAsignaPuntos() {

        String opcionCorrecta = "verdadero";
        String opcionIncorrecta = "falso";
        String preguntaAHacer = "Estamos hechxs de torta?";
        List<String> opciones = new LinkedList<>();
        List<String> opcionesCorrectas = new LinkedList<>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        opcionesCorrectas.add(opcionCorrecta);

        Jugador jugadorUno = new Jugador("Lucia");
        Jugador jugadorDos = new Jugador("Alan");

        List<String> respuestasJugadorUno = new LinkedList<>();
        List<String> respuestasJugadorDos = new LinkedList<>();
        respuestasJugadorUno.add("verdadero");
        respuestasJugadorDos.add("falso");

        PreguntaVerdaderoOFalso pregunta = new PreguntaVerdaderoOFalso(preguntaAHacer, opciones, opcionesCorrectas);

        pregunta.asignarPuntaje(jugadorUno, respuestasJugadorUno);
        pregunta.asignarPuntaje(jugadorDos, respuestasJugadorDos);

        assertEquals(1, jugadorUno.obtenerPuntaje());
        assertEquals(0, jugadorDos.obtenerPuntaje());
    }
}
