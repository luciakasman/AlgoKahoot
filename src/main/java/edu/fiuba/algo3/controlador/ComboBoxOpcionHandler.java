package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.vista.botones.ComboBoxOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComboBoxOpcionHandler implements EventHandler<ActionEvent> {

    private HashMap<String, Integer> respuesta;
    private String opcion;
    private List<Opcion> respuestaFinal;
    private ComboBoxOrderedChoice comboBox;

    public ComboBoxOpcionHandler(ComboBoxOrderedChoice comboBox, int cantOpciones, String opcion, List<Opcion> respuestaFinal) {
        this.comboBox = comboBox;
        //this.respuesta = respuesta;
        this.respuestaFinal = new ArrayList<>(cantOpciones);
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.respuestaFinal.add(Integer.parseInt(this.comboBox.getValue().toString()) - 1, new Opcion(opcion));
        System.out.println("RESPUESTAS");
        this.respuestaFinal.forEach(o ->
                System.out.println(o.getOpcion())
                );

    }
}
