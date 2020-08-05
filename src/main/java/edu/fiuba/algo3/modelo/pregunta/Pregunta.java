package edu.fiuba.algo3.modelo.pregunta;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestaVerdaderoOFalso;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value=PreguntaVerdaderoOFalso.class, name = "verdaderoOFalso"),
})
public interface Pregunta {
    int obtenerPuntaje(Respuesta respuesta);

    RespuestaVerdaderoOFalso armarRespuesta(Opcion respuesta);

    public String getPregunta ();
}
