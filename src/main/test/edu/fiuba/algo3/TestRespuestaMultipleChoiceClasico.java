package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.RespuestaMultipleChoiceClasico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuestaMultipleChoiceClasico {

    List<Opcion> opcionesCorrectas;
    List<Opcion> respuesta;
    Opcion opcionA;
    Opcion opcionB;
    Opcion opcionC;

    @BeforeEach
    void setUp() {
        respuesta = new ArrayList<>();
        opcionesCorrectas = new ArrayList<>();
        opcionA = new Opcion("1");
        opcionB = new Opcion("2");
        opcionC = new Opcion("3");
    }

    @Test
    void testObtenerPuntajeAcertandoTodasEsCorrecto() {
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesCorrectas.add(opcionC);

        respuesta.add(opcionA);
        respuesta.add(opcionB);
        respuesta.add(opcionC);

        RespuestaMultipleChoiceClasico respuestaMultipleChoice = new RespuestaMultipleChoiceClasico(respuesta);
        int puntaje = respuestaMultipleChoice.obtenerPuntaje(opcionesCorrectas);

        assertEquals(1, puntaje);
    }

    @Test
    void testObtenerPuntajeDaCeroConRespuestasFaltantes() {
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesCorrectas.add(opcionC);

        respuesta.add(opcionA);
        respuesta.add(opcionB);

        RespuestaMultipleChoiceClasico respuestaMultipleChoice = new RespuestaMultipleChoiceClasico(respuesta);
        int puntaje = respuestaMultipleChoice.obtenerPuntaje(opcionesCorrectas);

        assertEquals(0, puntaje);
    }

    @Test
    void testObtenerPuntajeDaCeroConRespuestasIncorrectas() {
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);

        respuesta.add(opcionA);
        respuesta.add(opcionB);
        respuesta.add(opcionC);

        RespuestaMultipleChoiceClasico respuestaMultipleChoice = new RespuestaMultipleChoiceClasico(respuesta);
        int puntaje = respuestaMultipleChoice.obtenerPuntaje(opcionesCorrectas);

        assertEquals(0, puntaje);
    }
}
