package edu.fiuba.algo3.modelo.preguntas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.respuestas.RespuestaVerdaderoOFalso;

import java.util.List;

public class PreguntaVerdaderoOFalso implements Pregunta {

    public final String pregunta;
    public final List<Opcion> opcionesIncorrectas;
    public final List<Opcion> opcionesCorrectas;
    public RespuestaVerdaderoOFalso respuesta;

    @JsonCreator
    public PreguntaVerdaderoOFalso(@JsonProperty("pregunta") String pregunta,
                                   @JsonProperty("opcionesCorrectas") List<Opcion> opcionesCorrectas,
                                   @JsonProperty("opcionesIncorrectas") List<Opcion> opcionesIncorrectas) {
        this.pregunta = pregunta;
        this.opcionesIncorrectas = opcionesIncorrectas;
        this.opcionesCorrectas = opcionesCorrectas;
    }

    public String obtenerPregunta() {
        return pregunta;
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        return opcionesCorrectas;
    }

    public List<Opcion> obtenerOpcionesIncorrectas() {
        return opcionesIncorrectas;
    }

    public int obtenerPuntaje(Respuesta respuesta) {
        return respuesta.obtenerPuntaje(this.opcionesCorrectas);
    }

    public Respuesta armarRespuesta(List<Opcion> respuesta) {
        return new RespuestaVerdaderoOFalso(respuesta.get(0));
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
