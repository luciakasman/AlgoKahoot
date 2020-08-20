package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.vista.botones.ComboBoxOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComboBoxOpcionHandler implements EventHandler<ActionEvent> {

    private final String opcion;
    private final HashMap<Integer, Opcion> respuesta = new HashMap<>();
    private final List<Opcion> respuestaFinal;
    private final ComboBoxOrderedChoice comboBox;

    public ComboBoxOpcionHandler(ComboBoxOrderedChoice comboBox, int cantOpciones, String opcion, List<Opcion> respuestaFinal) {
        this.comboBox = comboBox;
        //this.respuesta = respuesta;
        this.respuestaFinal = new ArrayList<>(cantOpciones);
        this.opcion = opcion;
    }

    public List<Opcion> armarRespuestaFinal(){
        for (int i = 1; i <= respuesta.size(); i++) {
            respuestaFinal.add(respuesta.get(i));
        }
        return respuestaFinal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int value = Integer.parseInt(this.comboBox.getValue().toString());
        this.respuesta.put(value - 1, new Opcion(opcion));
        this.comboBox.getItems().remove(String.valueOf(value-1));
        this.respuesta.forEach((v,o) ->
                System.out.println(o.getOpcion())
        );

    }
}
