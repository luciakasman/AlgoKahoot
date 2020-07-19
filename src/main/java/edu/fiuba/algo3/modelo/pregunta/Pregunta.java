package edu.fiuba.algo3.modelo.pregunta;

import java.util.List;

public class Pregunta {
    public final String pregunta;
    public final List<String> opciones;
    public final List<String> opcionesCorrectas;

    public Pregunta(String pregunta, List<String> opciones, List<String> opcionesCorrectas) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.opcionesCorrectas = opcionesCorrectas;
    }

    public List<String> obtenerOpcionesCorrectas() {
        return opcionesCorrectas;
    }

    public String obtenerPregunta() {
        return pregunta;
    }
}
