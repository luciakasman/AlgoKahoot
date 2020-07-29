package edu.fiuba.algo3;


import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.RespuestaMultipleChoiceParcial;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuestaMultipleChoiceParcial {

    List<Opcion> opcionesCorrectas;

    @Test
    public void TestObtenerPuntajeEsCorrecto(){

        List<Opcion> respuesta = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();
        Opcion opcionA = new Opcion("1");
        Opcion opcionB = new Opcion("2");
        Opcion opcionC = new Opcion("3");
        Opcion opcionD = new Opcion("4");
        Opcion opcionE = new Opcion("5");
        respuesta.add(opcionB);
        respuesta.add(opcionD);
        respuesta.add(opcionE);

        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesCorrectas.add(opcionC);
        opcionesCorrectas.add(opcionD);

        RespuestaMultipleChoiceParcial respuestaMultipleChoiceParcial = new RespuestaMultipleChoiceParcial(respuesta);
        int puntaje = respuestaMultipleChoiceParcial.obtenerPuntaje(opcionesCorrectas);
        assertEquals(puntaje,0);
    }

}
