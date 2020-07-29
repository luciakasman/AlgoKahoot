package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.RespuestaMultipleChoiceParcial;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuestaMultipleChoiceClasico {

    List<Opcion> opcionesCorrectas;



    @Test
    public void TestObtenerPuntajeAcertandoTodasEsCorrecto(){
        List<Opcion> respuesta = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();
        Opcion opcionA = new Opcion("1");
        Opcion opcionB = new Opcion("2");
        respuesta.add(opcionA);
        respuesta.add(opcionB);

        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        RespuestaMultipleChoice respuestaMultipleChoice = new RespuestaMultipleChoice(respuesta);
        int puntaje = respuestaMultipleChoice.obtenerPuntaje(opcionesCorrectas);
        assertEquals(puntaje,1);

    }
    @Test
    public void TestObtenerPuntajeFallandoEsCorrecto(){
        List<Opcion> respuesta = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();
        Opcion opcionA = new Opcion("1");
        Opcion opcionB = new Opcion("2");
        Opcion opcionC = new Opcion("3");
        Opcion opcionD = new Opcion("4");

        respuesta.add(opcionA);

        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesCorrectas.add(opcionC);
        opcionesCorrectas.add(opcionD);

        RespuestaMultipleChoice respuestaMultipleChoice = new RespuestaMultipleChoice(respuesta);
        int puntaje = respuestaMultipleChoice.obtenerPuntaje(opcionesCorrectas);
        assertEquals(puntaje,0);
    }
    @Test
    public void TestObtenerPuntajeFallandoConRespuestasDeMas(){
        List<Opcion> respuesta = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();
        Opcion opcionA = new Opcion("1");
        Opcion opcionB = new Opcion("2");
        Opcion opcionC = new Opcion("3");
        Opcion opcionD = new Opcion("4");

        respuesta.add(opcionA);
        respuesta.add(opcionB);
        respuesta.add(opcionC);

        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);

        RespuestaMultipleChoice respuestaMultipleChoice = new RespuestaMultipleChoice(respuesta);
        int puntaje = respuestaMultipleChoice.obtenerPuntaje(opcionesCorrectas);
        assertEquals(puntaje,0);
    }
}
