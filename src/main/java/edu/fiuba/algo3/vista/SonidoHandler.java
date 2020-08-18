package edu.fiuba.algo3.vista;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class SonidoHandler {

    private File archivoSonido;

    public SonidoHandler(File file){
        this.archivoSonido = file;
    }

    public void reproducirSonido(){
        Media sound = new Media(this.archivoSonido.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
}
