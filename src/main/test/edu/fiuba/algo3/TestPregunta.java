package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPregunta {

    Queue<Pregunta> preguntas;
    String preguntaAHacer;
    List<Opcion> opcionesCorrectas;
    GeneradorDePreguntas generadorDePreguntas = new GeneradorDePreguntas();

    @BeforeEach
    void setUp() {
        preguntas = generadorDePreguntas.obtenerPreguntas();
    }

    @Test
    void testPuedeCrearseIndicandoleRespuestaCorrecta() {
        System.out.println("OPCIONES CORRECTAS");
        preguntas.forEach(pregunta -> {
            pregunta.getOpcionesCorrectas().forEach(opcion ->
                    System.out.println(pregunta.getPregunta() + "\t" +opcion.getOpcion()));
        });
        System.out.println("OPCIONES INCORRECTAS");
        preguntas.forEach(pregunta -> {
            pregunta.getOpcionesIncorrectas().forEach(opcion ->
                    System.out.println(pregunta.getPregunta() + "\t" + opcion.getOpcion()));
        });

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
