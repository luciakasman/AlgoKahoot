package edu.fiuba.algo3.vista;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class SonidoHandler {

    private MediaPlayer mediaPlayer;

    public void reproducirSonido(File file){
        detenerSonido();
        Media sound = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public void detenerSonido(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
    }
}
