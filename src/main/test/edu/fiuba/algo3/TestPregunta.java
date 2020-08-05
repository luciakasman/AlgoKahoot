package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.pregunta.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.pregunta.LotePreguntas;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPregunta {

    Pregunta pregunta;
    String preguntaAHacer;
    List<Opcion> opcionesCorrectas;
    GeneradorDePreguntas generadorDePreguntas = new GeneradorDePreguntas();
    //LotePreguntas preguntas = generadorDePreguntas.leerPreguntasJSON();

    @BeforeEach
    void setUp() {
        generadorDePreguntas.leerPreguntasJSON();
        /*preguntaAHacer = preguntas.obtenerPreguntaVoFNumero(0);
        opcionesCorrectas = preguntas.obtenerOpcionesCorrectasPreguntaVoFNumero(0);
        List<Opcion> opcionesIncorrectas = preguntas.obtenerOpcionesIncorrectasPreguntaVoFNumero(0);

        pregunta = new Pregunta(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);*/
    }

    @Test
    void testPuedeCrearseIndicandoleRespuestaCorrecta() {

        assertEquals(preguntaAHacer, "hola"/*pregunta.obtenerPregunta()*/);

        assertEquals(opcionesCorrectas, "hola"/*pregunta.obtenerOpcionesCorrectas()*/);
    }
}
