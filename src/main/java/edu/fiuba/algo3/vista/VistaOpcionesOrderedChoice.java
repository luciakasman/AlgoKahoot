package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.ComboBoxOrderedChoice;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.List;

public class VistaOpcionesOrderedChoice extends VBox  {

    private final List<Opcion> opciones;
    private final HashMap<Integer, String> respuesta = new HashMap<>();
    private final List<Opcion> respuestaFinal;
    private Pregunta pregunta;

    public VistaOpcionesOrderedChoice(List<Opcion> opciones, List<Opcion> respuestaFinal, Pregunta pregunta) {
        this.setSpacing(20);
        this.opciones = opciones;
        this.pregunta = pregunta;
        this.respuestaFinal = respuestaFinal;
        setearOpciones();
        update();
    }

    private void setearOpciones() {
        this.opciones.forEach(opcion ->{
                this.respuesta.put(0, opcion.getOpcion());
            System.out.println(opcion.getOpcion());
        });

    }

    private void armarVistaPropia() {
        this.opciones.forEach(opcion ->
                this.getChildren().add(armarRespuestaConOpciones(opcion)));
    }

    private HBox armarRespuestaConOpciones(Opcion opcion) {
        HBox hBox = new HBox();
        Label opcionLabel = new Label(opcion.getOpcion());

        hBox.getChildren().add(opcionLabel);

        ComboBoxOrderedChoice ordenComboBox = new ComboBoxOrderedChoice(opciones.size(), respuesta, opcion, respuestaFinal);
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
