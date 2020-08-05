package edu.fiuba.algo3.modelo.pregunta;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.fiuba.algo3.modelo.Opcion;

import java.util.List;

public class LotePreguntas {

    public List<Pregunta> preguntas;

    @JsonCreator
    public LotePreguntas(@JsonProperty("preguntas") final List<Pregunta> preguntas) {
        super();
        this.preguntas = preguntas;
    }

    /*public String obtenerPreguntaVoFNumero(int numero) {
        return this.verdaderoOFalso.get(numero).getPregunta();
    }

    public List<Opcion> obtenerOpcionesIncorrectasPreguntaVoFNumero(int numero) {
        return this.verdaderoOFalso.get(numero).getOpcionesIncorrectas();
    }

    public List<Opcion> obtenerOpcionesCorrectasPreguntaVoFNumero(int numero) {
        return this.verdaderoOFalso.get(numero).getOpcionesCorrectas();
    }

    public String obtenerPreguntaMultipleChoiceClasicoNumero(int numero) {
        return this.multipleChoiceClasico.get(numero).getPregunta();
    }

    public List<Opcion> obtenerOpcionesIncorrectasPreguntaMultipleChoiceClasicoNumero(int numero) {
        return this.multipleChoiceClasico.get(numero).getOpcionesIncorrectas();
    }

    public List<Opcion> obtenerOpcionesCorrectasPreguntaMultipleChoiceClasicoNumero(int numero) {
        return this.multipleChoiceClasico.get(numero).getOpcionesCorrectas();
    }


    public List<Pregunta> getVerdaderoOFalso() {
        return verdaderoOFalso;
    }

    public void setVerdaderoOFalso(List<Pregunta> verdaderoOFalso) {
        this.verdaderoOFalso = verdaderoOFalso;
    }

    public List<Pregunta> getMultipleChoiceClasico() {
        return multipleChoiceClasico;
    }

    public void setMultipleChoiceClasico(List<Pregunta> multipleChoiceClasico) {
        this.multipleChoiceClasico = multipleChoiceClasico;
    }
*/}
