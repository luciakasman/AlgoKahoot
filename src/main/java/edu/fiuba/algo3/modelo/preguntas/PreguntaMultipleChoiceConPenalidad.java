package edu.fiuba.algo3.modelo.preguntas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.respuestas.RespuestaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.respuestas.RespuestaVerdaderoOFalso;

import java.util.List;

public class PreguntaMultipleChoiceConPenalidad extends Pregunta {

    @JsonCreator
    public PreguntaMultipleChoiceConPenalidad(@JsonProperty("pregunta") String pregunta,
                                         @JsonProperty("opcionesCorrectas")List<Opcion> opcionesCorrectas,
                                         @JsonProperty("opcionesIncorrectas")List<Opcion> opcionesIncorrectas) {
        super(pregunta, opcionesCorrectas, opcionesIncorrectas);
    }

    public Respuesta armarRespuesta(List<Opcion> respuesta) {
        return new RespuestaMultipleChoiceConPenalidad(respuesta);
    }
}
