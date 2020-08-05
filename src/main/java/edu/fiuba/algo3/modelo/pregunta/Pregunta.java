package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.List;

public class Pregunta {
    private String pregunta;
    private List<Opcion> opcionesIncorrectas;
    private List<Opcion> opcionesCorrectas;

    public Pregunta(String pregunta, List<Opcion> opcionesCorrectas, List<Opcion> opcionesIncorrectas) {
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

    /* Getters, setters y constructor vacio creados para poder leer desde un JSON*/

    public Pregunta(){ }

    public String getPregunta() {
        return pregunta;
    }

    public List<Opcion> getOpcionesIncorrectas() {
        return opcionesIncorrectas;
    }

    public List<Opcion> getOpcionesCorrectas() {
        return opcionesCorrectas;
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
