package edu.fiuba.algo3.modelo.preguntas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Queue;

public class LotePreguntas {

    private final Queue<Pregunta> preguntas;

    @JsonCreator
    public LotePreguntas(@JsonProperty("preguntas") final Queue<Pregunta> preguntas) {
        super();
        this.preguntas = preguntas;
    }

    public Queue<Pregunta> obtenerPreguntas() {
        return this.preguntas;
    }
}
