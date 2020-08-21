package edu.fiuba.algo3.vista.checkboxmultiplechoice;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public interface EstadoCheckBoxMultipleChoice {

    EstadoCheckBoxMultipleChoice modificarRespuesta(List<Opcion> respuesta, String opcion);

}
