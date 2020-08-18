package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.botones.BotonDuplicador;
import edu.fiuba.algo3.vista.botones.BotonTriplicador;
import javafx.scene.layout.HBox;

public class VistaBotonesMultiplicadores extends HBox {
    private final BotonDuplicador botonDuplicador;
    private final BotonTriplicador botonTriplicador;

    public VistaBotonesMultiplicadores(){
        this.setSpacing(30);
        this.botonDuplicador = new BotonDuplicador() ;
        this.botonTriplicador = new BotonTriplicador() ;
        this.getChildren().add(this.botonDuplicador);
        this.getChildren().add(this.botonTriplicador);

    }
    public void actualizar(){
        this.botonDuplicador.actualizar(botonTriplicador);
        this.botonTriplicador.actualizar(botonDuplicador);
    }
}
