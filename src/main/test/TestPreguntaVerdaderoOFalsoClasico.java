import edu.fiuba.algo3.modelo.PreguntaVerdaderoOFalso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestPreguntaVerdaderoOFalsoClasico {

    @Test

    public void testPuedeCrearseIndicandoleRespuestaCorrecta(){

        PreguntaVerdaderoOFalso pregunta = new PreguntaVerdaderoOFalso() ;

        String preguntaObtenida = pregunta.obtenerPregunta();

        assertNotNull(preguntaObtenida);



        assertEquals("verdadero",pregunta.obtenerRespuestaCorrecta());


    }


}
