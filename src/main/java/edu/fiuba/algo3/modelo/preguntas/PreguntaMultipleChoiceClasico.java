package edu.fiuba.algo3.modelo.preguntas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.respuestas.RespuestaMultipleChoiceClasico;

import java.util.List;

public class PreguntaMultipleChoiceClasico extends Pregunta {

    @JsonCreator
    public PreguntaMultipleChoiceClasico(@JsonProperty("pregunta") String pregunta,
                                   @JsonProperty("opcionesCorrectas")List<Opcion> opcionesCorrectas,
                                   @JsonProperty("opcionesIncorrectas")List<Opcion> opcionesIncorrectas) {
        super(pregunta, opcionesCorrectas, opcionesIncorrectas);
    }

    public Respuesta armarRespuesta(List<Opcion> respuesta) {
        return new RespuestaMultipleChoiceClasico(respuesta);
    }
}
