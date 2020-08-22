package edu.fiuba.algo3.respuestas;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.respuestas.RespuestaVerdaderoOFalso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

public class TestRespuestaVerdaderoOFalso {

    private RespuestaVerdaderoOFalso respuesta;
    private List<Opcion> listaOpcionCorrecta = new LinkedList<>();
    private Opcion opcionRespuesta;
    private Opcion opcionCorrecta = new Opcion("falso");
    private int puntaje;

    @BeforeEach
    void setUp(){
        listaOpcionCorrecta.add(opcionCorrecta);
    }

    @Test
    public void testRespuestaVerdaderoOFalsoEsCorrectaYDevuelve1DePuntaje(){
        opcionRespuesta = new Opcion("falso");
        respuesta = new RespuestaVerdaderoOFalso(opcionRespuesta);
        puntaje = respuesta.obtenerPuntaje(listaOpcionCorrecta);
        Assertions.assertEquals(1, puntaje);
    }

    @Test
    public void testRespuestaVerdaderoOFalsoEsIncorrectaYDevuelve0DePuntaje(){
        opcionRespuesta = new Opcion("verdadero");
        respuesta = new RespuestaVerdaderoOFalso(opcionRespuesta);
        puntaje = respuesta.obtenerPuntaje(listaOpcionCorrecta);
        Assertions.assertEquals(0, puntaje);
    }

}
