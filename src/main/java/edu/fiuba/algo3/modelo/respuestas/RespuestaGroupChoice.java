package edu.fiuba.algo3.modelo.respuestas;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class RespuestaGroupChoice implements Respuesta {
    private final List<Opcion> respuestasGrupoUno;
    private final RespuestasHelper respuestasHelper = new RespuestasHelper();

    public RespuestaGroupChoice(List<Opcion> respuestasGrupoUno) {
        this.respuestasGrupoUno = respuestasGrupoUno;
    }

    public int obtenerPuntaje(List<Opcion> opcionesCorrectasGrupoUno) {
        return (respuestasHelper.todasLasRespuestasCoincidenConLasOpcionesCorrectas(opcionesCorrectasGrupoUno, respuestasGrupoUno)
                && opcionesCorrectasGrupoUno.size() == respuestasGrupoUno.size()) ? 1 : 0;
    }
}