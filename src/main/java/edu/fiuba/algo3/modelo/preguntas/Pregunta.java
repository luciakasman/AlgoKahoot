package edu.fiuba.algo3.modelo.preguntas;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
              property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PreguntaVerdaderoOFalso.class, name = "verdaderoOFalso"),
        @JsonSubTypes.Type(value = PreguntaVerdaderoOFalsoConPenalidad.class, name = "verdaderoOFalsoPenalidad"),
        @JsonSubTypes.Type(value = PreguntaMultipleChoiceClasico.class, name = "multipleChoiceClasico"),
        @JsonSubTypes.Type(value = PreguntaMultipleChoiceConPenalidad.class, name = "multipleChoicePenalidad"),
        @JsonSubTypes.Type(value = PreguntaMultipleChoiceParcial.class, name = "multipleChoiceParcial"),
        @JsonSubTypes.Type(value = PreguntaOrderedChoice.class, name = "orderedChoice"),
        @JsonSubTypes.Type(value = PreguntaGroupChoice.class, name = "groupChoice"),

})

public abstract class Pregunta {
    private String pregunta;
    private List<Opcion> opcionesIncorrectas;
    private List<Opcion> opcionesCorrectas;

    public Pregunta(String pregunta,
                    List<Opcion> opcionesCorrectas,
                   List<Opcion> opcionesIncorrectas) {
        this.pregunta = pregunta;
        this.opcionesIncorrectas = opcionesIncorrectas;
        this.opcionesCorrectas = opcionesCorrectas;
    }


    public int obtenerPuntaje(Respuesta respuesta) {
        return respuesta.obtenerPuntaje(this.opcionesCorrectas);
    }

    public abstract Respuesta armarRespuesta (List<Opcion> respuesta);

    /* Setters y getters para Jackson*/

    public String getPregunta() {
        return pregunta;
    }

    public List<Opcion> obtenerOpciones(){
        List<Opcion> opciones = new LinkedList<>(getOpcionesCorrectas());
        opciones.addAll(getOpcionesIncorrectas());
        Collections.shuffle(opciones);
        return opciones;
    }

    public List<Opcion> getOpcionesCorrectas() {
        return opcionesCorrectas;
    }

    public List<Opcion> getOpcionesIncorrectas() {
        return opcionesIncorrectas;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setOpcionesIncorrectas(List<Opcion> opcionesIncorrectas) {
        this.opcionesIncorrectas = opcionesIncorrectas;
    }

    public void setOpcionesCorrectas(List<Opcion> opcionesCorrectas) {
        this.opcionesCorrectas = opcionesCorrectas;
    }
}
