package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.vista.Observador;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ronda {

    //Me parecio mas comodo hacer esta clase ronda para poder manejar el modelo

    private Queue<Jugador> jugadores;
    private Pregunta pregunta;
    private Observador observador;

    public Ronda(Queue<Jugador> jugadores, Pregunta pregunta){
        this.jugadores = new LinkedList<Jugador>(jugadores);
        this.pregunta = pregunta;
    }

    public void agregarObservador(Observador observador){
        this.observador = observador;
    }


    //Estos obtener son mas que nada para que la interfaz pueda crearse
    public Jugador obtenerJugadorActual(){
        return jugadores.element();
    }

    public Pregunta obtenerPregunta(){
        return pregunta;
    }

    public void enviarRespuesta(List<Opcion> opcionesRespuesta){
        //Envia la respuesta y los puntos son asignados al primer jugador de la cola. Luego este es removido
        Respuesta respuesta = pregunta.armarRespuesta(opcionesRespuesta);
        int puntaje = pregunta.obtenerPuntaje(respuesta);
        Jugador jugador = jugadores.poll();
        jugador.guardarPuntajeDePregunta(puntaje);
        observador.update();
    }
}
