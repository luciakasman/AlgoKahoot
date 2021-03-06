package edu.fiuba.algo3.respuestas;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.respuestas.RespuestaGroupChoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRespuestaGroupChoice {

        List<Opcion> opcionesCorrectasGrupoA;
        List<Opcion> opcionesCorrectasGrupoB;
        List<Opcion> respuestaGrupoA;
        List<Opcion> respuestaGrupoB;

        Opcion opcionA;
        Opcion opcionB;
        Opcion opcionC;
        Opcion opcionD;

        @BeforeEach
        void setUp() {
            respuestaGrupoA = new ArrayList<>();
            respuestaGrupoB = new ArrayList<>();
            opcionesCorrectasGrupoA = new ArrayList<>();
            opcionesCorrectasGrupoB = new ArrayList<>();

            opcionA = new Opcion("1");
            opcionB = new Opcion("2");
            opcionC = new Opcion("3");
            opcionD = new Opcion("4");
        }

        @Test
        void testObtenerPuntajeAgrupandoBienEsCorrecto() {

            opcionesCorrectasGrupoA.add(opcionA);
            opcionesCorrectasGrupoA.add(opcionB);
            opcionesCorrectasGrupoB.add(opcionC);
            opcionesCorrectasGrupoB.add(opcionD);


            respuestaGrupoA.add(opcionB);
            respuestaGrupoA.add(opcionA);
            respuestaGrupoB.add(opcionD);
            respuestaGrupoB.add(opcionC);


            RespuestaGroupChoice respuestaGroupChoice = new RespuestaGroupChoice(respuestaGrupoA);
            int puntaje = respuestaGroupChoice.obtenerPuntaje(opcionesCorrectasGrupoA);

            assertEquals(1, puntaje);
        }


    @Test
    void testObtenerPuntajeAgrupandoMalDevuelveCero() {

        opcionesCorrectasGrupoA.add(opcionA);
        opcionesCorrectasGrupoA.add(opcionB);
        opcionesCorrectasGrupoB.add(opcionC);
        opcionesCorrectasGrupoB.add(opcionD);


        respuestaGrupoB.add(opcionA);
        respuestaGrupoB.add(opcionB);
        respuestaGrupoA.add(opcionC);
        respuestaGrupoA.add(opcionC);


        RespuestaGroupChoice respuestaGroupChoice = new RespuestaGroupChoice(respuestaGrupoA);
        int puntaje = respuestaGroupChoice.obtenerPuntaje(opcionesCorrectasGrupoA);

        assertEquals(0, puntaje);
    }

}