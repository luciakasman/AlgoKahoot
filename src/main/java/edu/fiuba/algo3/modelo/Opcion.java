package edu.fiuba.algo3.modelo;

public class Opcion {

    private String opcion;

    public Opcion(String opcion) {
        this.opcion = opcion;
    }

    public String obtenerOpcion(){
        return opcion;
    }

    //Redefinicion del metodo equals para comparacion de instancias de Opcion
    @Override
    public boolean equals(Object comparado){
        if(comparado instanceof Opcion) {
            Opcion opcionComparada = (Opcion) comparado;
            return this.opcion.equals(opcionComparada.obtenerOpcion());
        }
        return false;
    }
}
