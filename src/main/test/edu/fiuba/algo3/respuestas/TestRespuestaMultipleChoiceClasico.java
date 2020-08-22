package edu.fiuba.algo3.respuestas;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.respuestas.RespuestaMultipleChoiceClasico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TestRespuestaMultipleChoiceClasico {

    RespuestaMultipleChoiceClasico respuesta;
    List<Opcion> opcionesCorrectas = new LinkedList<>();
    List<Opcion> listaRespuesta;
    Opcion opcionA;
    Opcion opcionB;
    Opcion opcionC;
    int puntaje;

    @BeforeEach
    void setUp() {
        listaRespuesta = new ArrayList<>();
        opcionA = new Opcion("opcionCorr1");
        opcionB = new Opcion("opcionCorr2");
        opcionC = new Opcion("opcionCorr3");
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesCorrectas.add(opcionC);
    }

    @Test
    void testObtenerPuntajeAcertandoTodasEsCorrecto() {
        listaRespuesta.add(new Opcion("opcionCorr1"));
        listaRespuesta.add(new Opcion("opcionCorr3"));
        listaRespuesta.add(new Opcion("opcionCorr2"));
        respuesta = new RespuestaMultipleChoiceClasico(listaRespuesta);
        puntaje = respuesta.obtenerPuntaje(opcionesCorrectas);
        Assertions.assertEquals(1, puntaje);
    }

    @Test
    void testObtenerPuntajeDaCeroConRespuestasFaltantes() {
        listaRespuesta.add(new Opcion("opcionCorr1"));
        listaRespuesta.add(new Opcion("opcionCorr3"));
        respuesta = new RespuestaMultipleChoiceClasico(listaRespuesta);
        puntaje = respuesta.obtenerPuntaje(opcionesCorrectas);
        Assertions.assertEquals(0, puntaje);
    }

    @Test
    void testObtenerPuntajeDaCeroConRespuestasIncorrectas() {
        listaRespuesta.add(new Opcion("opcionCorr1"));
        listaRespuesta.add(new Opcion("opcionCorr3"));
        listaRespuesta.add(new Opcion("opcionCorr4"));
        respuesta = new RespuestaMultipleChoiceClasico(listaRespuesta);
        puntaje = respuesta.obtenerPuntaje(opcionesCorrectas);
        Assertions.assertEquals(0, puntaje);
    }

    @Test
    void testObtenerPuntajeDaCeroConTodasLasRespuestasCorrectasYUnaRespuestaIncorrecta(){
        listaRespuesta.add(new Opcion("opcionCorr1"));
        listaRespuesta.add(new Opcion("opcionCorr2"));
        listaRespuesta.add(new Opcion("opcionCorr3"));
        listaRespuesta.add(new Opcion("opcionCorr4"));
        respuesta = new RespuestaMultipleChoiceClasico(listaRespuesta);
        puntaje = respuesta.obtenerPuntaje(opcionesCorrectas);
        Assertions.assertEquals(0, puntaje);
    }
}