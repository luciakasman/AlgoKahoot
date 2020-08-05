package edu.fiuba.algo3.modelo.pregunta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LotePreguntas {

    public List<Pregunta> preguntas;

    @JsonCreator
    public LotePreguntas(@JsonProperty("preguntas") final List<Pregunta> preguntas) {
        super();
        this.preguntas = preguntas;
    }
}
