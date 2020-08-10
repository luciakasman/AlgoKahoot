package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPregunta {

    List<Pregunta> preguntas;
    String preguntaAHacer;
    List<Opcion> opcionesCorrectas;
    GeneradorDePreguntas generadorDePreguntas = new GeneradorDePreguntas();

    /*@BeforeEach
    void setUp() {
        preguntas = generadorDePreguntas.obtenerPreguntas();
    }*/

    /*@Test
    void testPuedeCrearseIndicandoleRespuestaCorrecta() {
        assertEquals("Estamos hechxs de torta?", preguntas.get(0).getPregunta());
        assertEquals("Peores materias de la facu?", preguntas.get(1).getPregunta());

        assertEquals("falso", preguntas.get(0).getOpcionesCorrectas().get(0).getOpcion());
        assertEquals("verdadero", preguntas.get(0).getOpcionesIncorrectas().get(0).getOpcion());

        assertEquals("AlgebraII", preguntas.get(1).getOpcionesCorrectas().get(0).getOpcion());
        assertEquals("Quimica", preguntas.get(1).getOpcionesCorrectas().get(1).getOpcion());
        assertEquals("AMII", preguntas.get(1).getOpcionesIncorrectas().get(0).getOpcion());
        assertEquals("AlgoritmosIII", preguntas.get(1).getOpcionesIncorrectas().get(1).getOpcion());
    }*/

}
