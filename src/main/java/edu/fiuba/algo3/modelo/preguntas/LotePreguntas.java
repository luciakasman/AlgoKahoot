package edu.fiuba.algo3.modelo.preguntas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LotePreguntas {

    private final List<Pregunta> preguntas;

    @JsonCreator
    public LotePreguntas(@JsonProperty("preguntas") final List<Pregunta> preguntas) {
        super();
        this.preguntas = preguntas;
    }

    public List<Pregunta> obtenerPreguntas() {
        return this.preguntas;
    }
}
