package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.SonidoHandler;
import edu.fiuba.algo3.vista.botones.BotonInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
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
        BotonInicio botonInicio = new BotonInicio(this.stage,sonido);
        Image imagen = new Image("file:src/resources/ImagenInicio.jpg",512,250,true,false);
        final ImageView imagenVista = new ImageView(imagen);
        root.getChildren().addAll(imagenVista, botonInicio);
        Scene escena = new Scene(root, 1000, 800);
        imagenVista.fitWidthProperty().bind(escena.widthProperty());
        imagenVista.fitHeightProperty().bind(escena.heightProperty());
        stage.setTitle("Kahoot");
        stage.setScene(escena);
        stage.show();
    }
}
