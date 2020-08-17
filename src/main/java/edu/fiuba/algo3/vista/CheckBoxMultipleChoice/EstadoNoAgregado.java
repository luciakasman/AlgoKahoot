package edu.fiuba.algo3.vista.CheckBoxMultipleChoice;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class EstadoNoAgregado implements EstadoCheckBoxMultipleChoice{

    @Override
    public EstadoAgregado modificarRespuesta(List<Opcion> respuesta, String opcion){
        respuesta.add(new Opcion(opcion));
        return new EstadoAgregado();
    }

}
