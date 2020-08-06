package edu.fiuba.algo3.modelo;


import java.util.LinkedList;
import java.util.List;

public class Controlador {

    public List<Opcion> obtenerRespuestas() {
        List<Opcion> respuestas = new LinkedList<>();
        respuestas.add(new Opcion("v"));
        return respuestas;
    }
}
