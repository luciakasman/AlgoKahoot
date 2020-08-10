package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Servicio;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestJuego {

    List<Pregunta> preguntas;
    String preguntaAHacer;
    List<Opcion> opcionesCorrectas;
    List<Opcion> opcionesIncorrectas;
    List<Opcion> respuestas;
    String falso = "falso";
    String verdadero = "verdadero";
    Opcion opcionA = new Opcion("AlgebraII");
    Opcion opcionB = new Opcion("FisicaI");
    Opcion opcionC = new Opcion("Algoritmos II");
    Opcion opcionD = new Opcion("Quimica");
    String preguntaMultipleChoice = "Que materias son del primer año?";
    String preguntaVerdaderoOFalso = "Los gatitos son malos?";
    GeneradorDePreguntas generadorDePreguntas;
    Servicio servicio;

    @BeforeEach
    void setUp(){
        opcionesCorrectas = new LinkedList<>();
        opcionesIncorrectas = new LinkedList<>();
        respuestas = new LinkedList<>();
        preguntas = new LinkedList<>();
        generadorDePreguntas = mock(GeneradorDePreguntas.class);
        servicio = mock(Servicio.class);
    }
    /*@Test
    public void juegoAsignaLosPuntosCorrespondientesPreguntaVoFRespuestaCorrecta() {
        preguntas.add(crearPreguntaVerdaderoOFalso());
        Opcion respuesta = new Opcion(falso);
        respuestas.add(respuesta);

        when(generadorDePreguntas.obtenerPreguntas()).thenReturn(preguntas);
        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        Juego sut = Juego.getInstance();
        //Juego sut = new Juego(servicio, generadorDePreguntas);
        sut.agregarJugador("John Lennon");

        sut.comenzarJuego();

        Assertions.assertEquals(1, sut.obtenerJugadores().get(0).obtenerPuntajeTotal());
    }*/

    private Pregunta crearPreguntaVerdaderoOFalso() {
        preguntaAHacer = preguntaVerdaderoOFalso;
        Opcion opcionCorrecta = new Opcion(falso);
        Opcion opcionIncorrecta = new Opcion(verdadero);
        opcionesCorrectas.add(opcionCorrecta);
        opcionesIncorrectas.add(opcionIncorrecta);
        return new PreguntaVerdaderoOFalso(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
    }

    private Pregunta crearPreguntaMultipleChoiceClasico() {
        preguntaAHacer = preguntaMultipleChoice;
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesIncorrectas.add(opcionC);
        opcionesIncorrectas.add(opcionD);;
        return new PreguntaMultipleChoiceClasico(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
    }

    private Pregunta crearPreguntaOrderedChoice() {
        preguntaAHacer = "Ordenar las siguientes materias alfabeticamente";
        opcionesCorrectas = new LinkedList<>();
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesCorrectas.add(opcionC);
        opcionesCorrectas.add(opcionD);
        opcionesIncorrectas = new LinkedList<>();

        return new PreguntaOrderedChoice(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
    }

}
