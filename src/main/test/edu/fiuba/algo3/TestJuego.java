package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.pregunta.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoOFalso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

        juego.darPuntosAJugador(jugador,);

        assertEquals(1, juego.obtenerJugadorActual().obtenerPuntaje());
    }

    @Test
    public void testPreguntaVerdaderoOFalsoRespuestaIncorrecta() {
        crearPreguntaVerdaderoOFalso();
        juego.agregarJugador("Gisela");
        juego.comenzarJuego();
        Opcion opcionRespuesta = new Opcion("verdadero");
        Respuesta respuesta = new RespuestaVerdaderoOFalso(opcionRespuesta);

        juego.darPuntosAJugador(juego.obtenerJugadorActual(), pregunta, respuesta);

        assertEquals(0, juego.obtenerJugadorActual().obtenerPuntaje());
    }

    @Test
    public void testPreguntaVerdaderoOFalsoConPenalidadRespuestaCorrecta() {
        crearPreguntaVerdaderoOFalso();
        juego.agregarJugador("Galis");
        juego.comenzarJuego();
        Opcion opcionRespuesta = new Opcion("falso");
        Respuesta respuesta = new RespuestaVerdaderoOFalsoConPenalidad(opcionRespuesta);

        juego.darPuntosAJugador(juego.obtenerJugadorActual(), pregunta, respuesta);

        assertEquals(1, juego.obtenerJugadorActual().obtenerPuntaje());
    }

    @Test
    public void testPreguntaVerdaderoOFalsoConPenalidadRespuestaIncorrecta() {
        crearPreguntaVerdaderoOFalso();
        juego.agregarJugador("Gisela");
        juego.comenzarJuego();
        Opcion opcionRespuesta = new Opcion("verdadero");
        Respuesta respuesta = new RespuestaVerdaderoOFalsoConPenalidad(opcionRespuesta);

        juego.darPuntosAJugador(juego.obtenerJugadorActual(), pregunta, respuesta);

        assertEquals(-1, juego.obtenerJugadorActual().obtenerPuntaje());
    }

    @Test
    public void testMultipleChoiceConPuntajeParcialCorrecto() {
        List<Opcion> respuestaMultipleChoiceParcial = crearPreguntaMultipleChoice();
        juego.agregarJugador("Gisela");
        juego.comenzarJuego();
        Respuesta respuesta = new RespuestaMultipleChoiceParcial(respuestaMultipleChoiceParcial);

        juego.darPuntosAJugador(juego.obtenerJugadorActual(), pregunta, respuesta);

        assertEquals(2, juego.obtenerJugadorActual().obtenerPuntaje());

    }

    @Test
    public void testMultipleChoiceClasico() {
        List<Opcion> respuestaMultipleChoice = crearPreguntaMultipleChoice();
        juego.agregarJugador("Alan");
        juego.comenzarJuego();
        Respuesta respuesta = new RespuestaMultipleChoiceClasico(respuestaMultipleChoice);

        juego.darPuntosAJugador(juego.obtenerJugadorActual(), pregunta, respuesta);

        assertEquals(1, juego.obtenerJugadorActual().obtenerPuntaje());
    }

    @Test
    public void testMultipleChoiceConPenalidad() {
        List<Opcion> respuestaMultipleChoiceConPenalidad = crearPreguntaMultipleChoice();
        Opcion opcionE = new Opcion("Discreta");
        respuestaMultipleChoiceConPenalidad.add(opcionE);
        juego.agregarJugador("German");
        juego.comenzarJuego();
        Respuesta respuesta = new RespuestaMultipleChoiceConPenalidad(respuestaMultipleChoiceConPenalidad);

        juego.darPuntosAJugador(juego.obtenerJugadorActual(), pregunta, respuesta);

        assertEquals(1, juego.obtenerJugadorActual().obtenerPuntaje());
    }

    private void crearPreguntaVerdaderoOFalso() {
        preguntaAHacer = "Los gatitos son malos.";
        Opcion opcionCorrecta = new Opcion("falso");
        Opcion opcionIncorrecta = new Opcion("verdadero");
        opcionesCorrectas = new LinkedList<>();
        opcionesIncorrectas = new LinkedList<>();
        opcionesCorrectas.add(opcionCorrecta);
        opcionesIncorrectas.add(opcionIncorrecta);

        pregunta = new PreguntaVerdaderoOFalso(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
    }

    private List<Opcion> crearPreguntaMultipleChoice() {
        preguntaAHacer = "cuales de estas materias son las peores de la facultad?";
        List<Opcion> respuesta = new ArrayList<>();
        opcionesCorrectas = new ArrayList<>();
        Opcion opcionA = new Opcion("AlgebraII");
        Opcion opcionB = new Opcion("FisicaI");
        Opcion opcionC = new Opcion("Algoritmos II");
        Opcion opcionD = new Opcion("Quimica");
        respuesta.add(opcionA);
        respuesta.add(opcionB);
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesIncorrectas = new LinkedList<>();
        opcionesIncorrectas.add(opcionC);
        opcionesIncorrectas.add(opcionD);

        pregunta = new Pregunta(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);

        return respuesta;
    }

    private List<Opcion> crearPreguntaOrderedChoice() {
        preguntaAHacer = "Ordenar las siguientes materias alfabeticamente";
        List<Opcion> respuesta = new ArrayList<>();
        opcionesCorrectas = new ArrayList<>();
        Opcion opcionA = new Opcion("AlgebraII");
        Opcion opcionB = new Opcion("Algoritmos II");
        Opcion opcionC = new Opcion("FisicaI");
        Opcion opcionD = new Opcion("Quimica");
        respuesta.add(opcionA);
        respuesta.add(opcionB);
        respuesta.add(opcionD);
        respuesta.add(opcionC);

        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesCorrectas.add(opcionC);
        opcionesCorrectas.add(opcionD);

        opcionesIncorrectas = new LinkedList<>();

        pregunta = new Pregunta(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);

        return respuesta;
    }

    @Test
    public void testOrderedChoiceIncorrecto() {

        List<Opcion> respuestaOrderedChoice = crearPreguntaOrderedChoice();
        juego.agregarJugador("German");
        juego.comenzarJuego();
        Respuesta respuesta = new RespuestaOrderedChoice(respuestaOrderedChoice);

        juego.darPuntosAJugador(juego.obtenerJugadorActual(), pregunta, respuesta);

        assertEquals(0, juego.obtenerJugadorActual().obtenerPuntaje());
    }

    private List<Opcion> crearPreguntaGroupChoice() {
        preguntaAHacer = "Ordenar en grupos pares e impares";
        List<Opcion> respuestaGrupoA = new ArrayList<>();
        List<Opcion> respuestaGrupoB = new ArrayList<>();

        List<Opcion> opcionesCorrectasGrupoA = new ArrayList<>();
        List<Opcion> opcionesCorrectasGrupoB = new ArrayList<>();

        Opcion opcionA = new Opcion("1");
        Opcion opcionB = new Opcion("2");
        Opcion opcionC = new Opcion("3");
        Opcion opcionD = new Opcion("4");
        respuestaGrupoA.add(opcionA);
        respuestaGrupoA.add(opcionB);
        respuestaGrupoA.add(opcionD);
        respuestaGrupoB.add(opcionC);

        opcionesCorrectasGrupoA.add(opcionA);
        opcionesCorrectasGrupoA.add(opcionB);
        opcionesCorrectasGrupoA.add(opcionC);
        opcionesCorrectasGrupoB.add(opcionD);

        opcionesIncorrectas = new LinkedList<>();

        pregunta = new Pregunta(preguntaAHacer, opcionesCorrectasGrupoA, opcionesIncorrectas);

        return respuestaGrupoA;
    }

    @Test
    public void testGruopChoiceCorrecto() {

        List<Opcion> respuestaGrupoA = crearPreguntaGroupChoice();
        juego.agregarJugador("German");
        juego.comenzarJuego();
        Respuesta respuesta = new RespuestaGroupChoice(respuestaGrupoA);

        juego.darPuntosAJugador(juego.obtenerJugadorActual(), pregunta, respuesta);

        assertEquals(0, juego.obtenerJugadorActual().obtenerPuntaje());
    }

}