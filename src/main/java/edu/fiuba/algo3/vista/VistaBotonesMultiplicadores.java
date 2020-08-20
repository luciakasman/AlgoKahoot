package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.botones.BotonDuplicador;
import edu.fiuba.algo3.vista.botones.BotonTriplicador;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaBotonesMultiplicadores extends HBox {
    private final BotonDuplicador botonDuplicador;
    private final BotonTriplicador botonTriplicador;

    public VistaBotonesMultiplicadores(Juego juego){
        this.setSpacing(30);
        this.botonDuplicador = new BotonDuplicador(juego) ;
        this.botonTriplicador = new BotonTriplicador(juego) ;
        this.getChildren().add(this.botonDuplicador);
        this.getChildren().add(this.botonTriplicador);
        botonDuplicador.setTranslateX(150);
        botonDuplicador.setTranslateY(560);
        botonTriplicador.setTranslateX(200);
        botonTriplicador.setTranslateY(560);
        botonDuplicador.setMaxSize(300, 40);
        botonDuplicador.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        botonDuplicador.setStyle("-fx-background-radius: 15;");
        botonTriplicador.setMaxSize(300, 40);
        botonTriplicador.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        botonTriplicador.setStyle("-fx-background-radius: 15;");

    }
    public void actualizar(){
        this.botonDuplicador.actualizar(botonTriplicador);
        this.botonTriplicador.actualizar(botonDuplicador);
    }
}
