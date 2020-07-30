package edu.fiuba.algo3;


import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.RespuestaMultipleChoiceParcial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuestaMultipleChoiceParcial {

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
    void testObtenerPuntajeEsCorrecto() {
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesCorrectas.add(opcionC);

        respuesta.add(opcionB);
        respuesta.add(opcionC);

        RespuestaMultipleChoiceParcial respuestaMultipleChoiceParcial = new RespuestaMultipleChoiceParcial(respuesta);
        int puntaje = respuestaMultipleChoiceParcial.obtenerPuntaje(opcionesCorrectas);

        assertEquals(2, puntaje);
    }

    @Test
    void testObtenerPuntajeEsIncorrecto() {
        Opcion opcionD = new Opcion("5");

        respuesta.add(opcionB);
        respuesta.add(opcionD);
        respuesta.add(opcionA);

        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesCorrectas.add(opcionC);

        RespuestaMultipleChoiceParcial respuestaMultipleChoiceParcial = new RespuestaMultipleChoiceParcial(respuesta);
        int puntaje = respuestaMultipleChoiceParcial.obtenerPuntaje(opcionesCorrectas);

        assertEquals(0, puntaje);
    }
}
