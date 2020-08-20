package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.vista.Observador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.mockito.Mockito.*;

public class TestJuego {

    Queue<Pregunta> preguntas;
    String preguntaAHacer;
    List<Opcion> opcionesCorrectas;
    List<Opcion> opcionesIncorrectas;
    List<Opcion> respuestas;
    String falso = "falso";
    String verdadero = "verdadero";
    Opcion opcionA = new Opcion("AnalisisII");
    Opcion opcionB = new Opcion("FisicaI");
    Opcion opcionC = new Opcion("AlgoritmosII");
    Opcion opcionD = new Opcion("Quimica");
    String preguntaMultipleChoice = "Que materias son del primer cuatrimestre?";
    String preguntaVerdaderoOFalso = "Los gatitos son malos?";
    GeneradorDePreguntas generadorDePreguntas;

    @BeforeEach
    void setUp(){
        opcionesCorrectas = new LinkedList<>();
        opcionesIncorrectas = new LinkedList<>();
        respuestas = new LinkedList<>();
        preguntas = new LinkedList<>();
        generadorDePreguntas = mock(GeneradorDePreguntas.class);
    }
    @Test
    public void juegoAsignaLosPuntosCorrespondientesPreguntaVoFRespuestaCorrecta() {
        PreguntaVerdaderoOFalso pregunta = crearPreguntaVerdaderoOFalso();
        preguntas.add(pregunta);
        Opcion respuesta = new Opcion(falso);
        respuestas.add(respuesta);
        when(generadorDePreguntas.obtenerPreguntas()).thenReturn(preguntas);
        Juego sut = new Juego(generadorDePreguntas);
        Observador observador = mock(Observador.class);
        sut.obtenerPreguntaNueva();
        doNothing().when(observador).update();
        sut.guardarObservador(observador);
        sut.agregarJugador("John Lennon");
        sut.jugarTurno(respuestas);
        Assertions.assertEquals(1, sut.obtenerJugadores().peek().obtenerPuntajeDePregunta());
    }
    @Test
    public void JuegoAsignaLosPuntosCorrespondientesPreguntaMultipleChoiceClasico(){
        PreguntaMultipleChoiceClasico pregunta = crearPreguntaMultipleChoiceClasico();
        preguntas.add(pregunta);
        Opcion primerOpcion = new Opcion("AnalisisII");
        Opcion segundoOpcion = new Opcion("FisicaI");
        respuestas.add(primerOpcion);
        respuestas.add(segundoOpcion);
        when(generadorDePreguntas.obtenerPreguntas()).thenReturn(preguntas);
        Juego sut = new Juego(generadorDePreguntas);
        Observador observador = mock(Observador.class);
        sut.obtenerPreguntaNueva();
        doNothing().when(observador).update();
        sut.guardarObservador(observador);
        sut.agregarJugador("John Lennon");
        sut.jugarTurno(respuestas);
        Assertions.assertEquals(1, sut.obtenerJugadores().peek().obtenerPuntajeDePregunta());
    }
    @Test
    public void JuegoAsignaLosPuntosCorrespondientesPreguntaOrderedChoice(){
        PreguntaOrderedChoice pregunta = crearPreguntaOrderedChoice();
        preguntas.add(pregunta);
        Opcion primerOpcion = new Opcion("AlgoritmosII");
        Opcion segundoOpcion = new Opcion("AnalisisII");
        Opcion tercerOpcion = new Opcion("FisicaI");
        Opcion cuartaOpcion = new Opcion("Quimica");
        respuestas.add(primerOpcion);
        respuestas.add(segundoOpcion);
        respuestas.add(tercerOpcion);
        respuestas.add(cuartaOpcion);
        when(generadorDePreguntas.obtenerPreguntas()).thenReturn(preguntas);
        Juego sut = new Juego(generadorDePreguntas);
        Observador observador = mock(Observador.class);
        sut.obtenerPreguntaNueva();
        doNothing().when(observador).update();
        sut.guardarObservador(observador);
        sut.agregarJugador("John Lennon");
        sut.jugarTurno(respuestas);
        Assertions.assertEquals(1, sut.obtenerJugadores().peek().obtenerPuntajeDePregunta());
    }


    private PreguntaVerdaderoOFalso crearPreguntaVerdaderoOFalso() {
        preguntaAHacer = preguntaVerdaderoOFalso;
        Opcion opcionCorrecta = new Opcion(falso);
        Opcion opcionIncorrecta = new Opcion(verdadero);
        opcionesCorrectas.add(opcionCorrecta);
        opcionesIncorrectas.add(opcionIncorrecta);
        return new PreguntaVerdaderoOFalso(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
    }

    private PreguntaMultipleChoiceClasico crearPreguntaMultipleChoiceClasico() {
        preguntaAHacer = preguntaMultipleChoice;
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesIncorrectas.add(opcionC);
        opcionesIncorrectas.add(opcionD);;
        return new PreguntaMultipleChoiceClasico(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
    }

    private PreguntaOrderedChoice crearPreguntaOrderedChoice() {
        preguntaAHacer = "Ordenar las siguientes materias alfabeticamente";
        opcionesCorrectas = new LinkedList<>();
        opcionesCorrectas.add(opcionC);
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesCorrectas.add(opcionD);
        opcionesIncorrectas = new LinkedList<>();

        return new PreguntaOrderedChoice(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
    }

}
