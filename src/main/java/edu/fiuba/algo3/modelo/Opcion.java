package edu.fiuba.algo3.modelo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Opcion {

    private String opcion;

    @JsonCreator
    public Opcion(@JsonProperty("opcion") String opcion) {
        this.opcion = opcion;
    }


    public String obtenerOpcion() {
        return opcion;
    }

    @Override
    public boolean equals(Object comparado) {
        if (comparado instanceof Opcion) {
            Opcion opcionComparada = (Opcion) comparado;
            return this.opcion.equals(opcionComparada.obtenerOpcion());
        }
        return false;
    }

    /* Getters, setters y constructor vacio creados para poder leer desde un JSON*/

    public Opcion() { }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
}
