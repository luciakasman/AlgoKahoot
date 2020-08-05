/*
package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.RespuestaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.pregunta.GeneradorDePreguntas;
import edu.fiuba.algo3.modelo.pregunta.LotePreguntas;
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
    GeneradorDePreguntas generadorDePreguntas = new GeneradorDePreguntas();
    LotePreguntas preguntas = generadorDePreguntas.leerPreguntasJSON();

    @BeforeEach
    void setUp() {
        respuesta = new ArrayList<>();
        opcionA = new Opcion("opcionCorr1");
        opcionB = new Opcion("opcionCorr2");
        opcionC = new Opcion("opcionCorr3");
    }

    @Test
    void testObtenerPuntajeAcertandoTodasEsCorrecto() {
        opcionesCorrectas = preguntas.obtenerOpcionesCorrectasPreguntaMultipleChoiceClasicoNumero(0);

        respuesta.add(opcionA);
        respuesta.add(opcionB);
        respuesta.add(opcionC);

        RespuestaMultipleChoiceClasico respuestaMultipleChoice = new RespuestaMultipleChoiceClasico(respuesta);
        int puntaje = respuestaMultipleChoice.obtenerPuntaje(opcionesCorrectas);

        assertEquals(1, puntaje);
    }

    @Test
    void testObtenerPuntajeDaCeroConRespuestasFaltantes() {
        opcionesCorrectas = preguntas.obtenerOpcionesCorrectasPreguntaMultipleChoiceClasicoNumero(0);

        respuesta.add(opcionA);
        respuesta.add(opcionB);

        RespuestaMultipleChoiceClasico respuestaMultipleChoice = new RespuestaMultipleChoiceClasico(respuesta);
        int puntaje = respuestaMultipleChoice.obtenerPuntaje(opcionesCorrectas);

        assertEquals(0, puntaje);
    }

    @Test
    void testObtenerPuntajeDaCeroConRespuestasIncorrectas() {
        opcionesCorrectas = preguntas.obtenerOpcionesCorrectasPreguntaMultipleChoiceClasicoNumero(1);

        respuesta.add(opcionA);
        respuesta.add(opcionB);
        respuesta.add(opcionC);

        RespuestaMultipleChoiceClasico respuestaMultipleChoice = new RespuestaMultipleChoiceClasico(respuesta);
        int puntaje = respuestaMultipleChoice.obtenerPuntaje(opcionesCorrectas);

        assertEquals(0, puntaje);
    }
}
*/
