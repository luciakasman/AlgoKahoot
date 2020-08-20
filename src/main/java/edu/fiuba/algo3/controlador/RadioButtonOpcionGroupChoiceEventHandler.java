package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.vista.botones.RadioButtonGroupChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RadioButtonOpcionGroupChoiceEventHandler implements EventHandler<ActionEvent> {
    private RadioButtonGroupChoice radioButton;
    private HashMap<String, String> respuesta;
    private String opcion;
    private List<Opcion> respuestaFinal;
    private String opcionCorrecta;

    public RadioButtonOpcionGroupChoiceEventHandler(String opcionCorrecta, RadioButtonGroupChoice radioButton, HashMap<String, String> respuesta, String opcion, List<Opcion> respuestaFinal){
        this.radioButton = radioButton;
        this.respuesta = respuesta;
        this.opcion = opcion;
        this.respuestaFinal = respuestaFinal;
        this.opcionCorrecta = opcionCorrecta;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        respuesta.put(this.opcion, radioButton.getText());
        List<Opcion> lista = new ArrayList<>();
        respuesta.entrySet().stream()
                .filter(o -> o.getValue().equals(this.opcionCorrecta))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                        .forEach((k, v) ->
                            lista.add(new Opcion(k)));
        respuestaFinal.clear();
        respuestaFinal.addAll(lista);
    }

}
