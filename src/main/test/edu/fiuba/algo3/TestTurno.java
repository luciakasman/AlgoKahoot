package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Servicio;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.List;

public class TestTurno {

    Pregunta pregunta;
    String preguntaAHacer;
    List<Opcion> opcionesCorrectas;
    List<Opcion> opcionesIncorrectas;
    Juego juego;
    Servicio servicio;
    List<Opcion> respuestas;
    Jugador jugador1;
    String falso = "falso";
    String verdadero = "verdadero";
    Opcion opcionA = new Opcion("AlgebraII");
    Opcion opcionB = new Opcion("FisicaI");
    Opcion opcionC = new Opcion("Algoritmos II");
    Opcion opcionD = new Opcion("Quimica");
    String preguntaMultipleChoice = "Que materias son del primer año?";
    String preguntaVerdaderoOFalso = "Los gatitos son malos?";

}
/*    @BeforeEach
    void setUp() {
        GeneradorDePreguntas generadorDePreguntas = mock(GeneradorDePreguntas.class);
        servicio = mock(Servicio.class);
        juego = Juego.getInstance();
        //juego = new Juego(servicio, generadorDePreguntas);
        Queue<Pregunta> preguntas = new LinkedList<>();
        preguntas.add(pregunta);
        when(generadorDePreguntas.obtenerPreguntas()).thenReturn(preguntas);
        jugador1 = new Jugador("Galileo");
        respuestas = new LinkedList<>();
        opcionesCorrectas = new LinkedList<>();
        opcionesIncorrectas = new LinkedList<>();
    }

    @Test
    void testPreguntaVerdaderoOFalsoRespuestaCorrecta() {
        Opcion respuesta = new Opcion(falso);
        respuestas.add(respuesta);

        Turno sut = new Turno(crearPreguntaVerdaderoOFalso(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(1, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    void testPreguntaVerdaderoOFalsoRespuestaIncorrecta() {
        Opcion respuesta = new Opcion(verdadero);
        respuestas.add(respuesta);

        Turno sut = new Turno(crearPreguntaVerdaderoOFalso(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(0, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testPreguntaVerdaderoOFalsoConPenalidadRespuestaCorrecta() {
        Opcion respuesta = new Opcion(falso);
        respuestas.add(respuesta);

        Turno sut = new Turno(crearPreguntaVerdaderoOFalsoConPenalidad(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(1, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testPreguntaVerdaderoOFalsoConPenalidadRespuestaIncorrecta() {
        Opcion respuesta = new Opcion(verdadero);
        respuestas.add(respuesta);

        Turno sut = new Turno(crearPreguntaVerdaderoOFalsoConPenalidad(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(-1, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testMultipleChoiceConPuntajeParcialConRespuestasCorrectas() {
        respuestas.add(opcionA);
        respuestas.add(opcionB);

        Turno sut = new Turno(crearPreguntaMultipleChoiceParcial(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(2, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testMultipleChoiceConPuntajeParcialConUnaRespuestaIncorrecta() {
        respuestas.add(opcionA);
        respuestas.add(opcionC);

        Turno sut = new Turno(crearPreguntaMultipleChoiceParcial(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(0, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testMultipleChoiceConPuntajeParcialConTodasRespuestasIncorrectas() {
        respuestas.add(opcionD);
        respuestas.add(opcionC);

        Turno sut = new Turno(crearPreguntaMultipleChoiceParcial(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(0, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testMultipleChoiceClasicoConTodasOpcionesCorrectas() {
        respuestas.add(opcionA);
        respuestas.add(opcionB);

        Turno sut = new Turno(crearPreguntaMultipleChoiceClasico(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(1, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testMultipleChoiceClasicoConUnaOpcionIncorrecta() {
        respuestas.add(opcionA);
        respuestas.add(opcionD);

        Turno sut = new Turno(crearPreguntaMultipleChoiceClasico(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(0, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testMultipleChoiceConPenalidadConTodasRespuestasCorrectas() {
        respuestas.add(opcionA);
        respuestas.add(opcionB);

        Turno sut = new Turno(crearPreguntaMultipleChoiceConPenalidad(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(2, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testMultipleChoiceConPenalidadConUnaRespuestaIncorrecta() {
        respuestas.add(opcionA);
        respuestas.add(opcionD);

        Turno sut = new Turno(crearPreguntaMultipleChoiceConPenalidad(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(0, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testMultipleChoiceConPenalidadConTodasRespuestasIncorrectas() {
        respuestas.add(opcionC);
        respuestas.add(opcionD);

        Turno sut = new Turno(crearPreguntaMultipleChoiceConPenalidad(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(-2, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testOrderedChoiceCorrecto() {
        respuestas.add(opcionA);
        respuestas.add(opcionB);
        respuestas.add(opcionD);
        respuestas.add(opcionC);

        Turno sut = new Turno(crearPreguntaOrderedChoice(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(0, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testOrderedChoiceIncorrecto() {
        respuestas.add(opcionA);
        respuestas.add(opcionB);
        respuestas.add(opcionC);
        respuestas.add(opcionD);

        Turno sut = new Turno(crearPreguntaOrderedChoice(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestas);

        sut.jugarTurno(jugador1);

        assertEquals(1, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testGroupChoiceCorrecto() {
        List<Opcion> respuestaGrupoA = new LinkedList<>();
        respuestaGrupoA.add(opcionA);
        respuestaGrupoA.add(opcionB);
        respuestaGrupoA.add(opcionC);

        Turno sut = new Turno(crearPreguntaGroupChoice(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestaGrupoA);

        sut.jugarTurno(jugador1);

        assertEquals(1, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testGroupChoiceIncorrectoConRespuestaFaltante() {
        List<Opcion> respuestaGrupoA = new LinkedList<>();
        respuestaGrupoA.add(opcionA);
        respuestaGrupoA.add(opcionB);

        Turno sut = new Turno(crearPreguntaGroupChoice(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestaGrupoA);

        sut.jugarTurno(jugador1);

        assertEquals(0, jugador1.obtenerPuntajeDePregunta());
    }

    @Test
    public void testGroupChoiceIncorrectoConRespuestaIncorrecta() {
        List<Opcion> respuestaGrupoA = new LinkedList<>();
        respuestaGrupoA.add(opcionA);
        respuestaGrupoA.add(opcionB);
        respuestaGrupoA.add(opcionD);

        Turno sut = new Turno(crearPreguntaGroupChoice(), servicio);

        when(servicio.obtenerRespuestas()).thenReturn(respuestaGrupoA);

        sut.jugarTurno(jugador1);

        assertEquals(0, jugador1.obtenerPuntajeDePregunta());
    }

    private Pregunta crearPreguntaVerdaderoOFalso() {
        armarPreguntaVerdaderoOFalso();
        return new PreguntaVerdaderoOFalso(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
    }

    private Pregunta crearPreguntaVerdaderoOFalsoConPenalidad() {
        armarPreguntaVerdaderoOFalso();
        return new PreguntaVerdaderoOFalsoConPenalidad(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
    }

    private Pregunta crearPreguntaMultipleChoiceClasico() {
        armarPreguntaMultipleChoice();
        return new PreguntaMultipleChoiceClasico(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
    }

    private Pregunta crearPreguntaMultipleChoiceConPenalidad() {
        armarPreguntaMultipleChoice();
        return new PreguntaMultipleChoiceConPenalidad(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
    }

    private Pregunta crearPreguntaMultipleChoiceParcial() {
        armarPreguntaMultipleChoice();
        return new PreguntaMultipleChoiceParcial(preguntaAHacer, opcionesCorrectas, opcionesIncorrectas);
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

    private Pregunta crearPreguntaGroupChoice() {
        preguntaAHacer = "Ordenar en grupos pares e impares";
        List<Opcion> opcionesCorrectasGrupoA = new LinkedList<>();
        List<Opcion> opcionesCorrectasGrupoB = new LinkedList<>();
        opcionesCorrectasGrupoA.add(opcionA);
        opcionesCorrectasGrupoA.add(opcionB);
        opcionesCorrectasGrupoA.add(opcionC);
        opcionesCorrectasGrupoB.add(opcionD);

        return new PreguntaGroupChoice(preguntaAHacer, opcionesCorrectasGrupoA, opcionesCorrectasGrupoB);
    }

    private void armarPreguntaVerdaderoOFalso() {
        preguntaAHacer = preguntaVerdaderoOFalso;
        Opcion opcionCorrecta = new Opcion(falso);
        Opcion opcionIncorrecta = new Opcion(verdadero);
        opcionesCorrectas.add(opcionCorrecta);
        opcionesIncorrectas.add(opcionIncorrecta);
    }

    private void armarPreguntaMultipleChoice() {
        preguntaAHacer = preguntaMultipleChoice;
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesIncorrectas.add(opcionC);
        opcionesIncorrectas.add(opcionD);
    }
} */