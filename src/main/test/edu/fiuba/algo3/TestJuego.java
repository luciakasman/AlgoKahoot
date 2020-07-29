package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.pregunta.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestJuego {
    
    Pregunta pregunta;
    String preguntaAHacer;
    List<Opcion> opcionesCorrectas;
    List<Opcion> opcionesIncorrectas;
    Juego juego;

    @BeforeEach
    void setUp() {
        juego = new Juego();
        GeneradorDePreguntas generadorDePreguntas = mock(GeneradorDePreguntas.class);
        Queue<Pregunta> preguntas = new LinkedList<>();
        preguntas.add(pregunta);
        when(generadorDePreguntas.obtenerPreguntas()).thenReturn(preguntas);
    }

    @Test
    public void testPreguntaVerdaderoOFalsoRespuestaCorrecta() {

        crearPreguntaVerdaderoOFalso();

        juego.agregarJugador("Galis");

        juego.comenzarJuego();

        Opcion opcionRespuesta = new Opcion("falso");

        Respuesta respuesta = new RespuestaVerdaderoOFalso(opcionRespuesta);

        juego.darPuntosAJugador(pregunta, respuesta);

        assertEquals(1, juego.obtenerJugadorActual().obtenerPuntaje());
    }

    @Test
    public void testPreguntaVerdaderoOFalsoRespuestaIncorrecta() {

        crearPreguntaVerdaderoOFalso();

        juego.agregarJugador("Gisela");

        juego.comenzarJuego();

        Opcion opcionRespuesta = new Opcion("verdadero");
        Respuesta respuesta = new RespuestaVerdaderoOFalso(opcionRespuesta);

        juego.darPuntosAJugador(pregunta, respuesta);

        assertEquals(0, juego.obtenerJugadorActual().obtenerPuntaje());
    }

    @Test
    public void testPreguntaVerdaderoOFalsoConPenalidadRespuestaCorrecta() {

        crearPreguntaVerdaderoOFalso();

        juego.agregarJugador("Galis");

        juego.comenzarJuego();

        Opcion opcionRespuesta = new Opcion("falso");

        Respuesta respuesta = new RespuestaVerdaderoOFalsoConPenalidad(opcionRespuesta);

        juego.darPuntosAJugador(pregunta, respuesta);

        assertEquals(1, juego.obtenerJugadorActual().obtenerPuntaje());
    }

    @Test
    public void testPreguntaVerdaderoOFalsoConPenalidadRespuestaIncorrecta() {

        crearPreguntaVerdaderoOFalso();

        juego.agregarJugador("Gisela");

        juego.comenzarJuego();

        Opcion opcionRespuesta = new Opcion("verdadero");
        Respuesta respuesta = new RespuestaVerdaderoOFalsoConPenalidad(opcionRespuesta);

        juego.darPuntosAJugador(pregunta, respuesta);

        assertEquals(-1, juego.obtenerJugadorActual().obtenerPuntaje());
    }

    private void crearPreguntaVerdaderoOFalso() {
        preguntaAHacer = "Los gatitos son malos.";
        Opcion opcionCorrecta = new Opcion("falso");
        Opcion opcionIncorrecta = new Opcion("verdadero");
        opcionesCorrectas = new LinkedList<>();
        opcionesIncorrectas = new LinkedList<>();
        opcionesCorrectas.add(opcionCorrecta);
        opcionesIncorrectas.add(opcionIncorrecta);

        pregunta = new Pregunta(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
    }
    private List<Opcion> crearPreguntaMultipleChoice(){
        preguntaAHacer = "cuales de estas materias son las peores de la facultad?";
        List<Opcion> respuesta = new ArrayList<>();
        opcionesCorrectas = new ArrayList<>();
        Opcion opcionA = new Opcion("AlgebraII");
        Opcion opcionB = new Opcion("FisicaI");
        Opcion opcionC = new Opcion("Algoritmos III");
        Opcion opcionD = new Opcion("Quimica");
        respuesta.add(opcionA);
        respuesta.add(opcionB);
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesCorrectas.add(opcionC);
        opcionesCorrectas.add(opcionD);
        opcionesIncorrectas = new LinkedList<>();
        pregunta = new Pregunta(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
        return respuesta;
    }
    @Test
    public void testMultipleChoiceConPuntajeParcialCorrecto(){
        List<Opcion> respuestaMultipleChoiceParcial = crearPreguntaMultipleChoice();
        juego.agregarJugador("Gisela");

        juego.comenzarJuego();

        Respuesta respuesta = new RespuestaMultipleChoiceParcial(respuestaMultipleChoiceParcial);

        juego.darPuntosAJugador(pregunta, respuesta);

        assertEquals(2, juego.obtenerJugadorActual().obtenerPuntaje());

    }
    @Test
    public void testMultipleChoiceClasico(){
        List<Opcion> respuestaMultipleChoice = crearPreguntaMultipleChoice();
        juego.agregarJugador("Alan");

        juego.comenzarJuego();

        Respuesta respuesta = new RespuestaMultipleChoice(respuestaMultipleChoice);

        juego.darPuntosAJugador(pregunta, respuesta);

        assertEquals(0, juego.obtenerJugadorActual().obtenerPuntaje());
    }
    @Test
    public void testMultipleChoiceConPenalidad(){

        List<Opcion> respuestaMultipleChoiceConPenalidad = crearPreguntaMultipleChoice();

        Opcion opcionE = new Opcion("Discreta");
        respuestaMultipleChoiceConPenalidad.add(opcionE);
        //La respuesta tiene 2 opciones bien y una mal

        juego.agregarJugador("German");

        juego.comenzarJuego();

        Respuesta respuesta = new RespuestaMultipleChoiceConPenalidad(respuestaMultipleChoiceConPenalidad);

        juego.darPuntosAJugador(pregunta, respuesta);

        assertEquals(1, juego.obtenerJugadorActual().obtenerPuntaje());
    }

}