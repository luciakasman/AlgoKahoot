package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.preguntas.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPregunta {

    Queue<Pregunta> preguntas;
    GeneradorDePreguntas generadorDePreguntas = new GeneradorDePreguntas();

    @BeforeEach
    void setUp() {
        preguntas = generadorDePreguntas.obtenerPreguntas();
    }

    @Test
    void testPuedeCrearseIndicandoleRespuestaCorrecta() {
        Pregunta pregunta = preguntas.remove();
        assertEquals("Estamos hechxs de torta?", pregunta.getPregunta());
        assertEquals("falso", pregunta.getOpcionesCorrectas().get(0).getOpcion());
        assertEquals("verdadero", pregunta.getOpcionesIncorrectas().get(0).getOpcion());
        pregunta = preguntas.remove();
        assertEquals("Materias mas aburridas de la facu?", pregunta.getPregunta());
        assertEquals("Quimica", pregunta.getOpcionesCorrectas().get(0).getOpcion());
        assertEquals("AMII", pregunta.getOpcionesIncorrectas().get(0).getOpcion());
        assertEquals("AlgoritmosIII", pregunta.getOpcionesIncorrectas().get(1).getOpcion());
        assertEquals("AlgebraII", pregunta.getOpcionesIncorrectas().get(2).getOpcion());
    }
}
