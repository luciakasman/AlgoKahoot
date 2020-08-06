package edu.fiuba.algo3.modelo.preguntas;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value=PreguntaVerdaderoOFalso.class, name = "verdaderoOFalso"),
        @JsonSubTypes.Type(value=PreguntaMultipleChoiceClasico.class, name = "multipleChoiceClasico"),
})
public interface Pregunta {

    int obtenerPuntaje(Respuesta respuesta);

    Respuesta armarRespuesta (List<Opcion> respuesta);

    String getPregunta();

    List<Opcion> getOpcionesCorrectas();

    List<Opcion> getOpcionesIncorrectas();
}
