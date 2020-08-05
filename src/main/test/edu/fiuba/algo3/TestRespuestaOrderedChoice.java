package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.RespuestaOrderedChoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuestaOrderedChoice {

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
        void testObtenerAcertandoElOrdenEsCorrecto() {
            opcionesCorrectas.add(opcionA);
            opcionesCorrectas.add(opcionC);
            opcionesCorrectas.add(opcionB);

            respuesta.add(opcionA);
            respuesta.add(opcionC);
            respuesta.add(opcionB);

            RespuestaOrderedChoice respuestaOrderedChoice = new RespuestaOrderedChoice(respuesta);
            int puntaje = respuestaOrderedChoice.obtenerPuntaje(opcionesCorrectas);

            assertEquals(1, puntaje);
        }
    @Test
    void testObtenerAcertandoAlgunasDevuelveCero() {
        opcionesCorrectas.add(opcionA);
        opcionesCorrectas.add(opcionB);
        opcionesCorrectas.add(opcionC);

        respuesta.add(opcionA);
        respuesta.add(opcionC);
        respuesta.add(opcionB);

        RespuestaOrderedChoice respuestaOrderedChoice = new RespuestaOrderedChoice(respuesta);
        int puntaje = respuestaOrderedChoice.obtenerPuntaje(opcionesCorrectas);

        assertEquals(0, puntaje);
    }



}
