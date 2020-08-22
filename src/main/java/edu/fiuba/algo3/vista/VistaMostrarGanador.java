package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.Comparator;
import java.util.Queue;

import static javafx.animation.Animation.INDEFINITE;

public class VistaMostrarGanador {
    private final Stage stage;
    private int tiempo = 3;

    public VistaMostrarGanador(Stage stage) {
        this.stage = stage;
    }

    public void mostrarGanador(Queue<Jugador> jugadores) {
        Label labelResultado = new Label();
        Jugador jugadorGanador = jugadores.stream().max(Comparator.comparing(Jugador::obtenerPuntajeTotal)).get();
        Jugador jugadorPerdedor = jugadores.stream().min(Comparator.comparing(Jugador::obtenerPuntajeTotal)).get();
        String textoGanador = "El ganador es " + jugadorGanador.obtenerNombre() + " con " + jugadorGanador.obtenerPuntajeTotal() + " puntos.";
        String textoPerdedor = "Pero el perdedor es " + jugadorPerdedor.obtenerNombre() + " con " + jugadorPerdedor.obtenerPuntajeTotal() + " puntos.";
        labelResultado.setText(textoGanador);
        labelResultado.setFont(Font.font("Calibri", FontWeight.BOLD, 35));
        labelResultado.setTranslateY(-200);
        labelResultado.setStyle("-fx-text-fill: #FFFFFF;");
        Media media = new Media(new File("src/resources/resultado.mp4").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        MediaView mediaView = new MediaView (mediaPlayer);
        Group root = new Group();
        root.getChildren().add(mediaView);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), event -> {
            tiempo--;
            if (tiempo == 0) {
                labelResultado.setText(textoPerdedor);
            }
        }));
        timeline.playFromStart();
        StackPane stack = new StackPane(root, labelResultado);
        Scene escenaGanador = new Scene(stack, 900, 600);
        stage.setScene(escenaGanador);
    }
}