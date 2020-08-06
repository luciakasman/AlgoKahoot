package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaGeneral {

    public VBox start(Stage stage) {

        stage.setTitle("El mejor Kahoot del mundo");

       // TextField texto = new TextField();
       // texto.setPromptText("Escriba su nombre");

        Label nombreJugador1 = new Label("Turno de A0");
        Label etiqueta = new Label("Se viene el fin del mundo?");

        Button botonOpcionCorrecta = new Button();
        botonOpcionCorrecta.setText("Verdadero");

        Button botonOpcionIncorrecta = new Button();
        botonOpcionIncorrecta.setText("Falso");

        HBox contenedorHorizontal = new HBox(botonOpcionCorrecta, botonOpcionIncorrecta);
        contenedorHorizontal.setSpacing(10);

      //  Button botonEnviar = new Button();
      //  botonEnviar.setText("Enviar Respuesta");

        VBox contenedorVertical = new VBox(contenedorHorizontal);

        VBox contenedorPrincipal = new VBox(nombreJugador1, etiqueta, contenedorVertical);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));

    //    BotonEnviarRespuestaEventHandler botonEnviarEventHandler = new BotonEnviarRespuestaEventHandler(etiqueta);
    //    botonEnviar.setOnAction(botonEnviarEventHandler);

   //     TextoEventHandler textoEventHandler = new TextoEventHandler(botonOpcionCorrecta);
   //     texto.setOnKeyPressed(textoEventHandler);

        return contenedorPrincipal;
    }
}
