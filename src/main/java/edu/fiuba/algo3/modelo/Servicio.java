package edu.fiuba.algo3.modelo;

import java.util.List;

public class Servicio {

    Controlador controlador;

    public Servicio(Controlador controlador) {
        this.controlador = controlador;
    }

    public List<Opcion> obtenerRespuestas() {
        return this.controlador.obtenerRespuestas();
    }
}
