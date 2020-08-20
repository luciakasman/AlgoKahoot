package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class VistaGeneral extends Application {

    Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        StackPane root =  new StackPane();
        SonidoHandler sonido = new SonidoHandler();
        sonido.reproducirSonido(new File("src/resources/kahoot-lobby-music.mp3"));
        Button botonInicio = new Button();
        botonInicio.setStyle("-fx-background-radius: 25");
        Image imagen = new Image("file:src/resources/ImagenInicio.jpg",512,250,true,false);
        final ImageView imagenVista = new ImageView(imagen);
        root.getChildren().addAll(imagenVista, botonInicio);
        Scene escena = new Scene(root, 1000, 700);
        imagenVista.fitWidthProperty().bind(escena.widthProperty());
        imagenVista.fitHeightProperty().bind(escena.heightProperty());
        botonInicio.setText("Iniciar juego");
        botonInicio.setFont(Font.font("Calibri",FontWeight.BOLD, 30));
        botonInicio.setOnAction(new IniciarJuegoHandler(stage, sonido));
        botonInicio.setMaxSize(300,100);
        botonInicio.setTranslateX(10);
        botonInicio.setTranslateY(170);
        stage.setTitle("Kahoot");
        stage.setScene(escena);
        stage.show();
    }
}
