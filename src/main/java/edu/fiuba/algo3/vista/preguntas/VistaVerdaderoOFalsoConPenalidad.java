package edu.fiuba.algo3.vista.preguntas;

import edu.fiuba.algo3.controlador.SonidoHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.opciones.VistaOpcionesVerdaderoOFalso;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class VistaVerdaderoOFalsoConPenalidad extends VistaAbstracta implements Observador {
    private final Label pregunta;
    private final Label tipoPregunta;
    private final VistaBotonesMultiplicadores vistaBotonesMultiplicadores;
    private final VistaOpcionesVerdaderoOFalso opciones;
    private int tiempoDisponible = 15;

    public VistaVerdaderoOFalsoConPenalidad(Pregunta pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        super(stage, imagenVista, sonido, juego);
        labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        vistaBotonesMultiplicadores = new VistaBotonesMultiplicadores(juego);
        this.tipoPregunta = new Label("Verdadero o falso con penalidad: ");
        this.pregunta = new Label(pregunta.getPregunta());
        this.opciones = new VistaOpcionesVerdaderoOFalso(juego);
    }

    public void armarVistaPropia() {
        juego.guardarObservador(this);
        VBox vBox = new VBox(opciones, vistaBotonesMultiplicadores);
        vBox.setTranslateY(350);
        vBox.setSpacing(50);
        this.getChildren().addAll(imagenVista, labelTiempo, infoJugador, tipoPregunta, pregunta, vBox);
        Image imagen = new Image("file:src/resources/imagen2.jpg", 512, 250, true, false);
        imagenVista.setImage(imagen);
        tipoPregunta.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        setMargin(tipoPregunta, new Insets(100, 5, 0, 0));
        DiseñadorDeVistas diseñadorDeVistas = new DiseñadorDeVistas();
        diseñadorDeVistas.diseñarVistaVerdaderoOFalso(tipoPregunta, pregunta, labelTiempo, opciones, infoJugador);
        update();
    }

    @Override
    public void updatePropio(Jugador jugadorActual){
        vistaBotonesMultiplicadores.actualizar();
    }
}
