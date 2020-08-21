package edu.fiuba.algo3.vista.opciones;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.ComboBoxOrderedChoice;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VistaOpcionesOrderedChoice extends VBox {

    private final List<Opcion> opciones;
    private final Map<String, Integer> respuesta = new HashMap<>();
    private final List<Opcion> respuestaFinal;
    private final BotonEnviarRespuesta botonEnviarRespuesta;
    private Map<Integer,String> respuestasElegidasSinRepetir = new HashMap<>();

    public VistaOpcionesOrderedChoice(List<Opcion> opciones, List<Opcion> respuestaFinal, BotonEnviarRespuesta botonEnviarRespuesta) {
        this.setSpacing(20);
        this.opciones = opciones;
        this.respuestaFinal = respuestaFinal;
        this.botonEnviarRespuesta = botonEnviarRespuesta;
        update();
    }

    private void armarVistaPropia() {
        this.opciones.forEach(opcion ->
                this.getChildren().add(armarRespuestaConOpciones(opcion)));
        this.setTranslateX(350);
        this.setMaxSize(500, 200);
    }

    private HBox armarRespuestaConOpciones(Opcion opcion) {
        HBox hBox = new HBox();
        hBox.setSpacing(50);
        ComboBoxOrderedChoice ordenComboBox = new ComboBoxOrderedChoice(opciones.size(), respuesta, opcion, respuestaFinal, botonEnviarRespuesta,respuestasElegidasSinRepetir);
        hBox.getChildren().add(ordenComboBox);
        ordenComboBox.setMaxSize(900,100);
        Label opcionLabel = new Label(opcion.getOpcion());
        opcionLabel.setMinWidth(600);
        opcionLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 30));
        hBox.getChildren().add(opcionLabel);
        return hBox;
    }

    public void update() {
        this.getChildren().clear();
        respuestaFinal.clear();
        respuesta.clear();
        armarVistaPropia();
    }
}
