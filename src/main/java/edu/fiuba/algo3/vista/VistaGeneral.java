package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.preguntas.PreguntaVerdaderoOFalso;
import javafx.beans.Observable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class VistaGeneral {

    Juego juego = Juego.getInstance();
    Stage stage;

    public void jugarSiguienteRonda(){
        try{
            Ronda ronda = juego.armarSiguienteRonda();
            VistaRonda vistaRonda = new VistaRonda(ronda, this);
            Scene escenaRonda = new Scene(vistaRonda);
            stage.setScene(escenaRonda);
        } catch(NoSuchElementException e){
            mostrarGanador(juego.obtenerJugadores());
        }
    }

    public void mostrarGanador(List<Jugador> jugadores){
        Jugador jugadorGanador = jugadores.stream().max(Comparator.comparing(Jugador::obtenerPuntajeTotal)).get();
        Jugador jugadorPerdedor = jugadores.stream().min(Comparator.comparing(Jugador::obtenerPuntajeTotal)).get();
        String textoGanador = "El ganador es " + jugadorGanador.obtenerNombre() + " con " + jugadorGanador.obtenerPuntajeTotal() + " puntos.";
        String textoPerdedor = "El perdedor es " + jugadorPerdedor.obtenerNombre() + " con " + jugadorPerdedor.obtenerPuntajeTotal() + " puntos.";
        Label labelGanador = new Label(textoGanador);
        Label labelPerdedor = new Label(textoPerdedor);
        VBox vboxFinal = new VBox(labelGanador, labelPerdedor);
        Scene escenaGanador = new Scene(vboxFinal);
        stage.setScene(escenaGanador);
    }

    public void start(Stage stage) {
        this.stage = stage;
        VistaRegistroDeJugadores vistaRegistroDeJugadores = new VistaRegistroDeJugadores(this);
        stage.setTitle("El mejor Kahoot del mundo");
        Scene escena = new Scene(vistaRegistroDeJugadores);
        stage.setScene(escena);
        stage.show();

       /*// TextField texto = new TextField();
       // texto.setPromptText("Escriba su nombre");

        Label nombreJugador1 = new Label("Turno de A0");
        Label etiqueta = new Label("Se viene el fin del mundo?");

        Button botonOpcionCorrecta = new Button();
        botonOpcionCorrecta.setText("Verdadero");

        Button botonOpcionIncorrecta = new Button();
        botonOpcionIncorrecta.setText("Falso");

        HBox contenedorHorizontal = new HBox(botonOpcionCorrecta, botonOpcionIncorrecta);
        contenedorHorizontal.setSpacing(10);

      //  Button botonEnviar = new Button();
      //  botonEnviar.setText("Enviar Respuesta");

        VBox contenedorVertical = new VBox(contenedorHorizontal);

        VBox contenedorPrincipal = new VBox(nombreJugador1, etiqueta, contenedorVertical);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));

    //    BotonEnviarRespuestaEventHandler botonEnviarEventHandler = new BotonEnviarRespuestaEventHandler(etiqueta);
    //    botonEnviar.setOnAction(botonEnviarEventHandler);

   //     TextoEventHandler textoEventHandler = new TextoEventHandler(botonOpcionCorrecta);
   //     texto.setOnKeyPressed(textoEventHandler);*/

    }
}
