package edu.fiuba.algo3.modelo;

public class Multiplicador {
    private final int multiplo;
    private Boolean disponibilidad;

    public Multiplicador(int multiplo){
        this.multiplo = multiplo;
        this.disponibilidad = true;
    }

    public boolean esActivable(){
        return this.disponibilidad;
    }
    public int activar(){
        this.disponibilidad = false;
        return this.multiplo;
    }


}
