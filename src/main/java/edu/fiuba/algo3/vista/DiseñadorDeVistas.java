package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.botones.BotonEnviarRespuesta;
import edu.fiuba.algo3.vista.opciones.VistaOpcionesVerdaderoOFalso;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static javafx.scene.layout.StackPane.setAlignment;
import static javafx.scene.layout.StackPane.setMargin;

public class DiseñadorDeVistas {

    public void diseñarVistaVerdaderoOFalso(Label tipoPregunta, Label pregunta, LabelTiempo labelTiempo, VistaOpcionesVerdaderoOFalso opciones, Label infoJugador) {
        pregunta.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        labelTiempo.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        labelTiempo.setTextFill(Color.web("#ff0000"));

        setAlignment(labelTiempo, Pos.TOP_RIGHT);
        setMargin(labelTiempo, new Insets(20, 100, 0, 0));
        setAlignment(infoJugador, Pos.TOP_LEFT);
        setMargin(infoJugador, new Insets(20, 100, 0, 0));
        setAlignment(pregunta, Pos.CENTER);
        setMargin(pregunta, new Insets(0, 0, 180, 0));
        setAlignment(opciones, Pos.BOTTOM_CENTER);
        setAlignment(tipoPregunta, Pos.TOP_LEFT);

        infoJugador.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
    }

    public void diseñarVistaMultipleChoice(Label tipoPregunta, Label pregunta, LabelTiempo labelTiempo, Label infoJugador, BotonEnviarRespuesta botonEnviar) {
        pregunta.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        labelTiempo.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        labelTiempo.setTextFill(Color.web("#ff0000"));

        setAlignment(labelTiempo, Pos.TOP_RIGHT);
        setMargin(labelTiempo, new Insets(20, 100, 0, 0));
        setAlignment(infoJugador, Pos.TOP_LEFT);
        setMargin(infoJugador, new Insets(20, 100, 0, 0));
        setAlignment(pregunta, Pos.CENTER);
        setMargin(pregunta, new Insets(0, 0, 200, 0));
        setAlignment(tipoPregunta, Pos.TOP_LEFT);
        setAlignment(botonEnviar, Pos.BOTTOM_CENTER);
        setMargin(botonEnviar, new Insets(0, 0, 100, 0));
        tipoPregunta.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        setMargin(tipoPregunta, new Insets(100, 5, 0, 0));

        infoJugador.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
    }
}
