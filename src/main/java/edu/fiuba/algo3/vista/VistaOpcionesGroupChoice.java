package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaGroupChoice;
import edu.fiuba.algo3.vista.botones.RadioButtonGroupChoice;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.HashMap;
import java.util.List;

public class VistaOpcionesGroupChoice extends VBox {

    private List<Opcion> opciones;
    private HashMap<String, String> respuesta = new HashMap<>();
    private List<Opcion> respuestaFinal;
    private PreguntaGroupChoice pregunta;

    public VistaOpcionesGroupChoice(List<Opcion> opciones, List<Opcion> respuestaFinal, PreguntaGroupChoice pregunta) {
        this.setSpacing(20);
        this.opciones = opciones;
        setearOpciones();
        this.pregunta = pregunta;
        this.respuestaFinal = respuestaFinal;
        update();
    }

    private void setearOpciones() {
        this.opciones.forEach(opcion ->
                this.respuesta.put(opcion.getOpcion(), ""));
    }

    private void armarVistaPropia() {
        this.opciones.forEach(opcion -> {
            this.getChildren().add(armarRespuestaConOpciones(opcion));
        });
        this.setTranslateX(50);
        this.setMaxWidth(700);
    }

    private HBox armarRespuestaConOpciones(Opcion opcion) {
        HBox hBox = new HBox();
        ToggleGroup grupo = new ToggleGroup();
        // suponemos siempre que el primer grupo es el nombre de las opciones correctas
        RadioButtonGroupChoice firstGroupButton = new RadioButtonGroupChoice(pregunta.getNombrePrimerGrupo(), pregunta.getNombrePrimerGrupo(), respuesta, opcion.getOpcion(), respuestaFinal);
        firstGroupButton.setToggleGroup(grupo);
        RadioButtonGroupChoice secondGroupButton = new RadioButtonGroupChoice(pregunta.getNombrePrimerGrupo(), pregunta.getNombreSegundoGrupo(), respuesta, opcion.getOpcion(), respuestaFinal);
        secondGroupButton.setToggleGroup(grupo);
        Label opcionLabel = new Label(opcion.getOpcion());
        opcionLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        firstGroupButton.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
        secondGroupButton.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
        Region region1 = new Region();
        hBox.setHgrow(region1, Priority.ALWAYS);
//        Region region2 = new Region();
//        hBox.setHgrow(region2, Priority.ALWAYS);

        hBox.getChildren().add(opcionLabel);
        hBox.getChildren().add(region1);
        hBox.getChildren().add(firstGroupButton);
        hBox.getChildren().add(secondGroupButton);
        hBox.setSpacing(30);
        return hBox;
    }

    public void update() {
        this.getChildren().clear();
        respuestaFinal.clear();
        respuesta.clear();
        armarVistaPropia();
    }
}
