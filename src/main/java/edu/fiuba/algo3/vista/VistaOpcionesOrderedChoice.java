package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ComboBoxOpcionHandler;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaGroupChoice;
import edu.fiuba.algo3.vista.botones.ComboBoxOrderedChoice;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.List;

public class VistaOpcionesOrderedChoice extends VBox  {

    private List<Opcion> opciones;
    private HashMap<String, Integer> respuesta = new HashMap<>();
    private List<Opcion> respuestaFinal;
    private Pregunta pregunta;
    private int cantidadOpciones;

    public VistaOpcionesOrderedChoice(List<Opcion> opciones, List<Opcion> respuestaFinal, Pregunta pregunta) {
        this.setSpacing(20);
        this.opciones = opciones;
        setearOpciones();
        this.pregunta = pregunta;
        this.respuestaFinal = respuestaFinal;
        this.cantidadOpciones = opciones.size();
        update();
    }

    private void setearOpciones() {
        this.opciones.forEach(opcion ->
                this.respuesta.put(opcion.getOpcion(), 0));
    }

    private void armarVistaPropia() {
        this.opciones.forEach(opcion ->
                this.getChildren().add(armarRespuestaConOpciones(opcion)));
    }

    private HBox armarRespuestaConOpciones(Opcion opcion) {
        HBox hBox = new HBox();
        Label opcionLabel = new Label(opcion.getOpcion());
        hBox.getChildren().add(opcionLabel);

        ComboBoxOrderedChoice ordenComboBox = new ComboBoxOrderedChoice(cantidadOpciones, respuesta, opcion, respuestaFinal);
        hBox.getChildren().add(ordenComboBox);
        return hBox;
    }

    public void update() {
        this.getChildren().clear();
        respuestaFinal.clear();
        respuesta.clear();
        armarVistaPropia();
    }
}
