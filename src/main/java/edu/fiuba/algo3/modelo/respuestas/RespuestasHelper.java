package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class RespuestasHelper {

    public Boolean respuestaEsLaOpcionCorrecta(List<Opcion> opcionCorrecta, Opcion respuesta) {
        return opcionCorrecta.stream().anyMatch(opcion ->
                opcion.equals(respuesta));
    }

    public Boolean todasLasRespuestasCoincidenConLasOpcionesCorrectas(List<Opcion> opcionesCorrectas, List<Opcion> respuestas) {
        return respuestas.stream()
                .allMatch(key -> opcionesCorrectas.stream().anyMatch(key::equals));
    }
}