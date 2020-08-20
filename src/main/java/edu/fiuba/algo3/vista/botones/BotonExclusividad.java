package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.AplicarExclusividadEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BotonExclusividad extends HBox {

    private final Juego juego;
    private Button boton;

    public BotonExclusividad(Juego juego){
        this.juego = juego;
        this.boton = new Button();
    }

    public void armarDiseño() {
        boton.setMaxSize(300, 40);
        boton.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        boton.setStyle("-fx-background-radius: 15;");
        boton.setTranslateY(100);
        this.getChildren().add(boton);
    }

    public void actualizar(Jugador jugadorActual) {
        int exclusividadJugador = jugadorActual.obtenerExclusividadDisponible();
        if(exclusividadJugador != 0){
            AplicarExclusividadEventHandler botonExclusividadEventHandler = new AplicarExclusividadEventHandler(this.boton, juego);
            boton.setOnAction(botonExclusividadEventHandler);
            boton.setDisable(false);
        } else {
            this.setDisable(true);
        }
        String text = "Aplicar exclusividad (" + exclusividadJugador + ")";
        boton.setText(text);
        this.setAlignment(Pos.CENTER);
    }
}