package edu.fiuba.algo3.modelo.preguntas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.respuestas.RespuestaVerdaderoOFalso;

import java.util.List;

public class PreguntaVerdaderoOFalso extends Pregunta {
    @JsonCreator
    public PreguntaVerdaderoOFalso(@JsonProperty("pregunta") String pregunta,
                                   @JsonProperty("opcionesCorrectas")List<Opcion> opcionesCorrectas,
                                   @JsonProperty("opcionesIncorrectas")List<Opcion> opcionesIncorrectas) {
        super(pregunta, opcionesCorrectas, opcionesIncorrectas);
    }

    public Respuesta armarRespuesta(List<Opcion> respuesta) {
        return new RespuestaVerdaderoOFalso(respuesta.get(0));
    }
}
