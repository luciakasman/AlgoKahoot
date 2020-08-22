package edu.fiuba.algo3.vista.preguntas;

import edu.fiuba.algo3.controlador.SonidoHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.DiseñadorDeVistas;
import edu.fiuba.algo3.vista.LabelTiempo;
import edu.fiuba.algo3.vista.Observador;
import edu.fiuba.algo3.vista.VistaAbstracta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import edu.fiuba.algo3.vista.opciones.VistaOpcionesVerdaderoOFalso;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class VistaVerdaderoOFalso extends VistaAbstracta implements Observador {


    private final BotonExclusividad botonExclusividad;
    private final Label pregunta;
    private final Label tipoPregunta;
    private final VistaOpcionesVerdaderoOFalso opciones;

    public VistaVerdaderoOFalso(Pregunta pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        super(stage, imagenVista, sonido, juego);
        labelTiempo = new LabelTiempo(15, juego);
        botonExclusividad = new BotonExclusividad(juego);
        this.tipoPregunta = new Label("Verdadero o falso clasico: ");
        this.pregunta = new Label(pregunta.getPregunta());
        this.opciones = new VistaOpcionesVerdaderoOFalso(juego);
    }

    public void armarVistaPropia() {
        juego.guardarObservador(this);
        VBox vBox = new VBox(opciones, botonExclusividad);
        vBox.setTranslateY(350);
        vBox.setSpacing(30.0);
        this.getChildren().addAll(imagenVista, labelTiempo, infoJugador, tipoPregunta, pregunta, vBox);
        sonido.reproducirSonido(new File("src/resources/sweet-dreams-kahoot.mp3"));
        Image imagen = new Image("file:src/resources/imagen3.gif", 512, 250, true, false);
        imagenVista.setImage(imagen);
        botonExclusividad.armarDiseño();
        tipoPregunta.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        setMargin(tipoPregunta, new Insets(80, 5, 0, 0));

        DiseñadorDeVistas diseñadorDeVistas = new DiseñadorDeVistas();
        diseñadorDeVistas.diseñarVistaVerdaderoOFalso(tipoPregunta, pregunta, labelTiempo, opciones, infoJugador);
        update();
    }

    @Override
    protected void updatePropio(Jugador jugadorActual) {
        botonExclusividad.actualizar(jugadorActual);
    }
}