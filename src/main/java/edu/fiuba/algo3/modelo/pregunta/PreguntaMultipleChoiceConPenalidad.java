package edu.fiuba.algo3.modelo.pregunta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.RespuestaVerdaderoOFalso;

import java.util.List;

public class PreguntaMultipleChoiceConPenalidad implements Pregunta {

    public final String pregunta;
    public final List<Opcion> opcionesIncorrectas;
    public final List<Opcion> opcionesCorrectas;
    public RespuestaVerdaderoOFalso respuesta;

    @JsonCreator
    public PreguntaMultipleChoiceConPenalidad(@JsonProperty("pregunta") String pregunta,
                                              @JsonProperty("opcionesCorrectas") List<Opcion> opcionesCorrectas,
                                              @JsonProperty("opcionesIncorrectas") List<Opcion> opcionesIncorrectas) {
        this.pregunta = pregunta;
        this.opcionesIncorrectas = opcionesIncorrectas;
        this.opcionesCorrectas = opcionesCorrectas;
    }

    public int obtenerPuntaje(Respuesta respuesta) {
        return respuesta.obtenerPuntaje(this.opcionesCorrectas);
    }

    public Respuesta armarRespuesta(List<Opcion> respuesta) {
        return new RespuestaMultipleChoiceConPenalidad(respuesta);
    }

    public String getPregunta() {
        return pregunta;
    }

    public List<Opcion> getOpcionesCorrectas() {
        return opcionesCorrectas;
    }

    public List<Opcion> getOpcionesIncorrectas() {
        return opcionesIncorrectas;
    }
}
