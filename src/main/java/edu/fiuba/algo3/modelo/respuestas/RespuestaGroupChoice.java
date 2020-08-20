package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class RespuestaGroupChoice implements Respuesta {
    private final List<Opcion> respuestasGrupoUno;
    private final RespuestasUtils respuestasUtils = new RespuestasUtils();

    public RespuestaGroupChoice(List<Opcion> respuestasGrupoUno) {
        this.respuestasGrupoUno = respuestasGrupoUno;
    }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectasGrupoUno) {
        return (respuestasUtils.todasLasRespuestasCoincidenConLasOpcionesCorrectas(opcionesCorrectasGrupoUno, respuestasGrupoUno)
                && opcionesCorrectasGrupoUno.size() == respuestasGrupoUno.size()) ? 1 : 0;
    }
}