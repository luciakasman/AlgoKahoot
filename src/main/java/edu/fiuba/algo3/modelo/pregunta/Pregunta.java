package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestaVerdaderoOFalso;

public interface Pregunta {

    int obtenerPuntaje(Respuesta respuesta);

    RespuestaVerdaderoOFalso armarRespuesta(Opcion respuesta);
}
