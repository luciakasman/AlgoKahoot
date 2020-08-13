package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.botones.BotonEnviarNombre;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaRegistroDeJugadores extends VBox implements Observador{

    private TextField nombreJugador;
    private Button botonEnviarNombres;
    private Label labelAdvertencia = new Label("");
    private Stage stage;

    public VistaRegistroDeJugadores(Stage stage){
        this.setSpacing(20);
        Juego.getInstance().agregarObservador(this);
        this.stage = stage;
        nombreJugador = new TextField();
        nombreJugador.setPromptText("Ingrese el nombre del jugador");
        botonEnviarNombres = new BotonEnviarNombre(nombreJugador, labelAdvertencia);
        this.getChildren().add(nombreJugador);
        this.getChildren().add(botonEnviarNombres);
        this.getChildren().add(labelAdvertencia);
    }


    @Override
    public void update(){
        int cantidadJugadores = Juego.getInstance().obtenerJugadores().size(); //despues lo dejo mas lindo
        if (cantidadJugadores == 2){
            VistaRonda vistaRonda = new VistaRonda(stage);
            vistaRonda.armarVistaDeRonda();
            Scene scene = new Scene(vistaRonda);
            stage.setScene(scene);


        }

    }


}
