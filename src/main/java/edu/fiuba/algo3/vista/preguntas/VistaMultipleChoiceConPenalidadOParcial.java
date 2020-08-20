package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;

public class VistaMultipleChoiceConPenalidadOParcial extends VistaAbstracta implements Observador {

    private final List<Opcion> respuesta = new LinkedList<>();
    private final VistaOpcionesMultipleChoice vistaOpciones;
    private final VistaBotonesMultiplicadores vistaBotonesMultiplicadores;
    private final int tiempoDisponible = 30;
    private final Label pregunta;
    private final List<Opcion> opciones;
    private final BotonEnviarRespuesta botonEnviar;

    public VistaMultipleChoiceConPenalidadOParcial(Pregunta pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        super(stage, imagenVista, sonido, juego);
        this.vistaBotonesMultiplicadores = new VistaBotonesMultiplicadores(juego);
        this.labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        this.opciones = pregunta.obtenerOpciones();
        this.pregunta = new Label(pregunta.getPregunta());
        this.botonEnviar = new BotonEnviarRespuesta(respuesta, juego);
        this.vistaOpciones = new VistaOpcionesMultipleChoice(opciones, respuesta);
    }

    public void armarVistaPropia(String clase) {
        juego.guardarObservador(this);
        Label tipoPregunta = new Label("Multiple Choice " + clase + " : ");
        Image imagen = new Image("file:src/resources/imagen1.gif", 512, 250, true, false);
        imagenVista.setImage(imagen);
        VBox vBox = new VBox(vistaOpciones, botonEnviar, vistaBotonesMultiplicadores);
        vBox.setTranslateY(350);
        vBox.setSpacing(30.0);
        this.getChildren().addAll(imagenVista, labelTiempo, infoJugador, tipoPregunta, pregunta, vBox);
        DiseñadorDeVistas diseñadorDeVistas = new DiseñadorDeVistas();
        diseñadorDeVistas.diseñarVistaMultipleChoice(tipoPregunta, pregunta, labelTiempo, infoJugador, botonEnviar);
        update();
    }

    @Override
    protected void updatePropio(Jugador jugadorActual){
        respuesta.clear();
        vistaOpciones.update();
        vistaBotonesMultiplicadores.actualizar();
    }
}