package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controladores.botonhandler.EnviarNombresEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.botones.BotonEnviarNombre;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Observer;

public class VistaRegistroDeJugadores extends VBox implements Observador{

    private TextField nombreJugador;
    private Button botonEnviarNombres;
    private Label labelAdvertencia = new Label("");
    private VistaGeneral vistaGeneral;

    public VistaRegistroDeJugadores(VistaGeneral vistaGeneral){
        Juego.getInstance().agregarObservador(this);
        this.vistaGeneral = vistaGeneral;
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
            vistaGeneral.jugarSiguienteRonda();
        }
    }


}
