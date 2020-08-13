package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.controlador.Controlador;

import java.util.List;

public class Servicio {

    //Clase que no se usa en esta version

    Controlador controlador;

    public Servicio(Controlador controlador) {
        this.controlador = controlador;
    }

    public List<Opcion> obtenerRespuestas() {
        return this.controlador.obtenerRespuestas();
    }
}
