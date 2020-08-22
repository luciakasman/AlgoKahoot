package edu.fiuba.algo3.respuestas;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.respuestas.RespuestaVerdaderoOFalsoConPenalidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

public class TestRespuestaVerdaderoOFalsoConPenalidad {

    private RespuestaVerdaderoOFalsoConPenalidad respuesta;
    private List<Opcion> listaOpcionCorrecta = new LinkedList<>();
    private Opcion opcionRespuesta;
    private Opcion opcionCorrecta = new Opcion("falso");
    private int puntaje;

    @BeforeEach
    void setUp(){
        listaOpcionCorrecta.add(opcionCorrecta);
    }

    @Test
    public void testRespuestaVerdaderoOFalsoConPenalidadEsCorrectaYDevuelve1DePuntaje(){
        opcionRespuesta = new Opcion("falso");
        respuesta = new RespuestaVerdaderoOFalsoConPenalidad(opcionRespuesta);
        puntaje = respuesta.obtenerPuntaje(listaOpcionCorrecta);
        Assertions.assertEquals(1, puntaje);
    }

    @Test
    public void testRespuestaVerdaderoOFalsoConPenalidadEsIncorrectaYDevuelveMenos1DePuntaje(){
        opcionRespuesta = new Opcion("verdadero");
        respuesta = new RespuestaVerdaderoOFalsoConPenalidad(opcionRespuesta);
        puntaje = respuesta.obtenerPuntaje(listaOpcionCorrecta);
        Assertions.assertEquals(-1, puntaje);
    }

}
