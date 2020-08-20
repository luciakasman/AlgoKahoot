package edu.fiuba.algo3.vista.preguntas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class VistaOrderedChoice extends VistaAbstracta implements Observador {

    List<Opcion> respuesta = new LinkedList<>();
    private final List<Opcion> opciones = new ArrayList<>();
    private final Pregunta pregunta;
    private VistaOpcionesOrderedChoice vistaOpciones;
    private final int tiempoDisponible = 30;
    private final BotonExclusividad botonExclusividad;
    private final ImageView imagenVista;

    public VistaOrderedChoice(Pregunta pregunta, Stage stage, ImageView imagenVista, SonidoHandler sonido, Juego juego) {
        super(stage, imagenVista, sonido, juego);
        this.juego = juego;
        this.pregunta = pregunta;
        this.stage = stage;
        this.jugadores = new LinkedList<>(juego.obtenerJugadores());
        this.botonExclusividad = new BotonExclusividad(juego);
        this.labelTiempo = new LabelTiempo(tiempoDisponible, juego);
        this.imagenVista = imagenVista;
    }

    public void armarVistaPropia() {
        juego.guardarObservador(this);

        Label tipoPregunta =  new Label("Pregunta Ordered Choice");

        //Agregado de la pregunta
        Label labelPregunta = new Label(this.pregunta.getPregunta());

        this.opciones.addAll(this.pregunta.getOpcionesCorrectas());
        Collections.shuffle(this.opciones);

        //Agregado del enviar
        BotonEnviarRespuesta botonEnviar = new BotonEnviarRespuesta(this.respuesta, this.juego);

        vistaOpciones = new VistaOpcionesOrderedChoice(this.opciones, this.respuesta, botonEnviar);

        Image imagen = new Image("file:src/resources/imagen1.gif", 512, 250, true, false);
        imagenVista.setImage(imagen);

        VBox vBox = new VBox(vistaOpciones, botonEnviar, botonExclusividad);
        vBox.setSpacing(30.0);
        vBox.setTranslateY(250);
        this.getChildren().addAll(imagenVista, labelTiempo, infoJugador, tipoPregunta, labelPregunta, vBox);
        DiseñadorDeVistas diseñadorDeVistas = new DiseñadorDeVistas();
        diseñadorDeVistas.diseñarVistaGroupChoice(tipoPregunta, labelPregunta, labelTiempo, infoJugador, botonEnviar);
        update();
    }

    @Override
    protected void updatePropio(Jugador jugadorActual){
        vistaOpciones.update();
        botonExclusividad.actualizar(jugadorActual);
    }
}
