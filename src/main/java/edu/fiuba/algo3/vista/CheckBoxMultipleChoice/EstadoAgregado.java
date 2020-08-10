package edu.fiuba.algo3.vista.CheckBoxMultipleChoice;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class EstadoAgregado implements EstadoCheckBoxMultipleChoice{

    @Override
    public EstadoNoAgregado modificarRespuesta(List<Opcion> respuesta, String opcion){
        respuesta.remove(new Opcion(opcion));
        return new EstadoNoAgregado();
    }

}
