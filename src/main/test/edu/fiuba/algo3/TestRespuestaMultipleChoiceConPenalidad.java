package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.RespuestaMultipleChoiceConPenalidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuestaMultipleChoiceConPenalidad {

    List<Opcion> opcionesCorrectas;
    List<Opcion> respuesta;
    Opcion opcionA;
    Opcion opcionB;
    Opcion opcionC;
    Opcion opcionD;

    @BeforeEach
    void setUp() {
        respuesta = new ArrayList<>();
        opcionesCorrectas = new ArrayList<>();
        opcionA = new Opcion("1");
        opcionB = new Opcion("2");
        opcionC = new Opcion("3");
        opcionD = new Opcion("4");
    }

    @Test
    void testObtenerPuntajeEsCorrecto() {
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);

        respuesta.add(opcionB);
        respuesta.add(opcionC);
        respuesta.add(opcionD);

        RespuestaMultipleChoiceConPenalidad respuestaMultipleChoiceConPenalidad = new RespuestaMultipleChoiceConPenalidad(respuesta);
        int puntaje = respuestaMultipleChoiceConPenalidad.obtenerPuntaje(opcionesCorrectas);

        assertEquals(-1, puntaje);
    }
}
