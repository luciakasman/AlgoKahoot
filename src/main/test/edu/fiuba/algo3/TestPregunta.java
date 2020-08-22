package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.preguntas.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TestPregunta {

    Queue<Pregunta> preguntas;
    GeneradorDePreguntas generadorDePreguntas = new GeneradorDePreguntas();

    @BeforeEach
    void setUp() {
        preguntas = generadorDePreguntas.obtenerPreguntas();
    }

    @Test
    void testPuedeCrearseIndicandoleRespuestaCorrecta() {
        Pregunta pregunta = preguntas.remove();
        Pregunta preguntaVerdaderoOFalso = pregunta;
        assertAll(
                () -> assertEquals("Estamos hechxs de torta?", preguntaVerdaderoOFalso.getPregunta()),
                () -> assertEquals("falso", preguntaVerdaderoOFalso.obtenerOpcionesCorrectas().get(0).getOpcion()),
                () -> assertEquals("verdadero", preguntaVerdaderoOFalso.obtenerOpcionesIncorrectas().get(0).getOpcion()));
        pregunta = preguntas.remove();
        Pregunta preguntaMultipleChoice = pregunta;
        assertAll(
                () -> assertEquals("Qué animales son mamíferos?", preguntaMultipleChoice.getPregunta()),
                () -> assertEquals("Gato", preguntaMultipleChoice.obtenerOpcionesCorrectas().get(0).getOpcion()),
                () -> assertEquals("Ballena", preguntaMultipleChoice.obtenerOpcionesCorrectas().get(1).getOpcion()),
                () -> assertEquals("Tiburón", preguntaMultipleChoice.obtenerOpcionesIncorrectas().get(0).getOpcion()),
                () -> assertEquals("Iguana", preguntaMultipleChoice.obtenerOpcionesIncorrectas().get(1).getOpcion()));
        pregunta = preguntas.remove();
        Pregunta preguntaVerdaderoOFalsoConPenalidad = pregunta;
        assertAll(
                () -> assertEquals("Pluton es un planeta", preguntaVerdaderoOFalsoConPenalidad.getPregunta()),
                () -> assertEquals("falso", preguntaVerdaderoOFalsoConPenalidad.obtenerOpcionesCorrectas().get(0).getOpcion()),
                () -> assertEquals("verdadero", preguntaVerdaderoOFalsoConPenalidad.obtenerOpcionesIncorrectas().get(0).getOpcion()));
        pregunta = preguntas.remove();
        Pregunta preguntaMultipleChoiceConPenalidad = pregunta;
        assertAll(
                () -> assertEquals("En qué años ganó Boca la Copa Libertadores?", preguntaMultipleChoiceConPenalidad.getPregunta()),
                () -> assertEquals("2000", preguntaMultipleChoiceConPenalidad.obtenerOpcionesCorrectas().get(0).getOpcion()),
                () -> assertEquals("1978", preguntaMultipleChoiceConPenalidad.obtenerOpcionesCorrectas().get(1).getOpcion()),
                () -> assertEquals("2001", preguntaMultipleChoiceConPenalidad.obtenerOpcionesCorrectas().get(2).getOpcion()),
                () -> assertEquals("1986", preguntaMultipleChoiceConPenalidad.obtenerOpcionesIncorrectas().get(0).getOpcion()));
        pregunta = preguntas.remove();
        Pregunta preguntaOrderedChoice = pregunta;
        assertAll(
                () -> assertEquals("Ordene estos momentos historicos", preguntaOrderedChoice.getPregunta()),
                () -> assertEquals("Creacion de la escritura", preguntaOrderedChoice.obtenerOpcionesCorrectas().get(0).getOpcion()),
                () -> assertEquals("Caida del muro de Berlin", preguntaOrderedChoice.obtenerOpcionesCorrectas().get(1).getOpcion()),
                () -> assertEquals("Construccion de las piramides", preguntaOrderedChoice.obtenerOpcionesCorrectas().get(2).getOpcion()),
                () -> assertEquals("COVID-19", preguntaOrderedChoice.obtenerOpcionesCorrectas().get(3).getOpcion()));
        pregunta = preguntas.remove();
        Pregunta preguntaMultipleChoiceParcial = pregunta;
        assertAll(
                () -> assertEquals("Cuáles son cantantes de cumbia?", preguntaMultipleChoiceParcial.getPregunta()),
                () -> assertEquals("Gardel", preguntaMultipleChoiceParcial.obtenerOpcionesIncorrectas().get(0).getOpcion()),
                () -> assertEquals("Cerati", preguntaMultipleChoiceParcial.obtenerOpcionesIncorrectas().get(1).getOpcion()),
                () -> assertEquals("Justin Bieber", preguntaMultipleChoiceParcial.obtenerOpcionesIncorrectas().get(2).getOpcion()),
                () -> assertEquals("Pablo Lescano", preguntaMultipleChoiceParcial.obtenerOpcionesCorrectas().get(0).getOpcion()));
        pregunta = preguntas.remove();
        Pregunta preguntaGroupChoice = pregunta;
        assertAll(
                () -> assertEquals("Capitales de Europa y capitales de America", preguntaGroupChoice.getPregunta()),
                () -> assertEquals("Paris", preguntaGroupChoice.obtenerOpcionesCorrectas().get(0).getOpcion()),
                () -> assertEquals("Madrid", preguntaGroupChoice.obtenerOpcionesCorrectas().get(1).getOpcion()),
                () -> assertEquals("Roma", preguntaGroupChoice.obtenerOpcionesCorrectas().get(2).getOpcion()),
                () -> assertEquals("Buenos Aires", preguntaGroupChoice.obtenerOpcionesIncorrectas().get(0).getOpcion()),
                () -> assertEquals("Santiago", preguntaGroupChoice.obtenerOpcionesIncorrectas().get(1).getOpcion()),
                () -> assertEquals("Lima", preguntaGroupChoice.obtenerOpcionesIncorrectas().get(2).getOpcion()),
                () -> assertEquals("La Paz", preguntaGroupChoice.obtenerOpcionesIncorrectas().get(3).getOpcion()));
    }
}
