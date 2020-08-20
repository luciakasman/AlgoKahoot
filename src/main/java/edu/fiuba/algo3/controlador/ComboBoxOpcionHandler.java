package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.ComboBoxOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComboBoxOpcionHandler implements EventHandler<ActionEvent> {

    private final String opcion;
    private List<Opcion> respuestaFinal;
    private final ComboBoxOrderedChoice comboBox;
    private final Map<String, Integer> respuesta;
    private final BotonEnviarRespuesta botonEnviarRespuesta;
    private final int cantidadOpciones;
    private Map<Integer,String> respuestasElegidasSinRepetir;

    public ComboBoxOpcionHandler(ComboBoxOrderedChoice comboBox, int cantidadOpciones, String opcion, Map<String, Integer> respuesta, BotonEnviarRespuesta botonEnviarRespuesta, Map<Integer,String> respuestasElegidasSinRepetir, List<Opcion> respuestaFinal) {
        this.comboBox = comboBox;
        this.respuesta = respuesta;
        this.cantidadOpciones = cantidadOpciones;
        this.respuestaFinal = respuestaFinal;
        this.opcion = opcion;
        this.botonEnviarRespuesta = botonEnviarRespuesta;
        this.respuestasElegidasSinRepetir = respuestasElegidasSinRepetir;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int value = Integer.parseInt(this.comboBox.getValue().toString());
        this.respuesta.put(opcion, value);
        botonEnviarRespuesta.setDisable(seDesactivaBotonEnviar(respuesta));
        armarRespuestaFinal();
    }

    private void armarRespuestaFinal(){
        respuestaFinal.clear();
        for (int i = 1; i <= respuesta.size(); i++) {
            respuestaFinal.add(new Opcion(respuestasElegidasSinRepetir.get(i)));
        }
    }

    private boolean seDesactivaBotonEnviar(Map<String, Integer> opcionesElegidas) {
        respuestasElegidasSinRepetir = invertirRespuestas();
        return !(opcionesElegidas.size() == this.cantidadOpciones && opcionesElegidas.size() == respuestasElegidasSinRepetir.size());
    }

    private Map<Integer, String> invertirRespuestas() {
        Map<Integer, String> opcionesElegidasSinRepetir = new HashMap<>();
        for (Map.Entry<String, Integer> entry : respuesta.entrySet()) {
            opcionesElegidasSinRepetir.put(entry.getValue(), entry.getKey());
        }
        return opcionesElegidasSinRepetir;
    }
}
