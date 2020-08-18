package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.botones.BotonEnviarNombre;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class VistaRegistroDeJugadores extends VBox implements Observador {

    private final Stage stage;

    public VistaRegistroDeJugadores(Stage stage) {
        this.setSpacing(20);
        this.stage = stage;
        Juego.getInstance().guardarObservador(this);
        armarVistaPropia();
    }

    private void armarVistaPropia() {
        Image imagen = new Image("file:src/resources/imagen9.gif",512,250,true,false);
        BackgroundImage backgroundImage = new BackgroundImage(imagen, BackgroundRepeat.ROUND,
                BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        Label introducirNombre = new Label();
        introducirNombre.setText("Ingrese su nombre: ");
        introducirNombre.setFont(Font.font("Calibri", FontWeight.BOLD, 50));
        introducirNombre.setTranslateY(30);
        introducirNombre.setTextFill(Color.web("#ffffff"));
        TextField nombreJugador = new TextField();
        nombreJugador.setTranslateY(60);
        nombreJugador.setPromptText("Ingrese el nombre del jugador");
        nombreJugador.setFont(Font.font("Calibri", FontWeight.BOLD, 30));
        Label labelAdvertencia = new Label("");
        Button botonEnviarNombres = new BotonEnviarNombre(nombreJugador, labelAdvertencia);
        this.getChildren().add(introducirNombre);
        this.getChildren().add(nombreJugador);
        this.getChildren().add(botonEnviarNombres);
        this.getChildren().add(labelAdvertencia);
    }

    @Override
    public void update() {
        if (Juego.getInstance().obtenerJugadores().size() == 2) {
            VistaRonda vistaRonda = new VistaRonda(stage);
            final ImageView imagenVista = new ImageView();
            Scene scene = new Scene(vistaRonda, 900, 600);
            imagenVista.fitWidthProperty().bind(scene.widthProperty());
            imagenVista.fitHeightProperty().bind(scene.heightProperty());
            vistaRonda.armarVistaDeRonda(imagenVista);
            stage.setScene(scene);
        }
    }
}
