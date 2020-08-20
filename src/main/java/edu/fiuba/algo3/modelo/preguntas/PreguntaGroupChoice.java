package edu.fiuba.algo3.modelo.preguntas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.respuestas.RespuestaGroupChoice;

import java.util.List;

public class PreguntaGroupChoice extends Pregunta {

    private String nombrePrimerGrupo;
    private String nombreSegundoGrupo;

    @JsonCreator
    public PreguntaGroupChoice(@JsonProperty("pregunta") String pregunta,
                                              @JsonProperty("opcionesCorrectas")List<Opcion> opcionesCorrectas,
                                              @JsonProperty("opcionesIncorrectas")List<Opcion> opcionesIncorrectas,
                               @JsonProperty("nombrePrimerGrupo") String nombrePrimerGrupo,
                               @JsonProperty("nombreSegundoGrupo") String nombreSegundoGrupo) {

        super(pregunta, opcionesCorrectas, opcionesIncorrectas);
        this.nombrePrimerGrupo = nombrePrimerGrupo;
        this.nombreSegundoGrupo = nombreSegundoGrupo;
    }

    public Respuesta armarRespuesta(List<Opcion> respuesta) {
        return new RespuestaGroupChoice(respuesta);
    }

    public String getNombrePrimerGrupo() {
        return nombrePrimerGrupo;
    }

    public void setNombrePrimerGrupo(String nombrePrimerGrupo) {
        this.nombrePrimerGrupo = nombrePrimerGrupo;
    }

    public String getNombreSegundoGrupo() {
        return nombreSegundoGrupo;
    }

    public void setNombreSegundoGrupo(String nombreSegundoGrupo) {
        this.nombreSegundoGrupo = nombreSegundoGrupo;
    }
}
