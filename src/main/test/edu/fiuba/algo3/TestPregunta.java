package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPregunta {

    Pregunta pregunta;
    String preguntaAHacer;
    List<Opcion> opcionesCorrectas;

    @BeforeEach
    void setUp() {
        String verdadero = "verdadero";
        String falso = "falso";
        preguntaAHacer = "Estamos hechxs de torta?";
        Opcion opcionCorrecta = new Opcion(verdadero);
        Opcion opcionIncorrecta = new Opcion(falso);
        opcionesCorrectas = new LinkedList<>();
        List<Opcion> opcionesIncorrectas = new LinkedList<>();
        opcionesCorrectas.add(opcionCorrecta);
        opcionesCorrectas.add(opcionIncorrecta);

        pregunta = new Pregunta(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
    }

    @Test
    void testPuedeCrearseIndicandoleRespuestaCorrecta() {

        assertEquals(preguntaAHacer, pregunta.obtenerPregunta());

        assertEquals(opcionesCorrectas, pregunta.obtenerOpcionesCorrectas());
    }
}
