package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.asignadores.Asignador;
import edu.fiuba.algo3.modelo.asignadores.AsignadorComun;
import edu.fiuba.algo3.modelo.asignadores.AsignadorExclusivo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class TestAsignadores {

    private Jugador german = new Jugador("German");
    private Jugador alan = new Jugador("Alan");
    private List<Jugador> jugadores = new LinkedList<>();
    private Asignador asignadorExclusivo = new AsignadorExclusivo(2);
    private Asignador asignadorComun = new AsignadorComun();

    @BeforeEach
    void setUp(){
        jugadores.add(german);
        jugadores.add(alan);
    }

    @Test
    public void testAsignadorExclusivoAsigna0PuntosAAmbosJugadoresCuandoSusPuntajesDePreguntaCoinciden(){
        german.guardarPuntajeDePregunta(3);
        alan.guardarPuntajeDePregunta(3);
        asignadorExclusivo.asignarPuntos(jugadores);
        Assertions.assertEquals(0, german.obtenerPuntajeTotal());
        Assertions.assertEquals(0, alan.obtenerPuntajeTotal());
    }

    @Test
    public void testAsignadorExclusivoAsignaElDobleDePuntosAAlanY0AGerman(){
        german.guardarPuntajeDePregunta(1);
        alan.guardarPuntajeDePregunta(2);
        asignadorExclusivo.asignarPuntos(jugadores);
        Assertions.assertEquals(0,german.obtenerPuntajeTotal());
        Assertions.assertEquals(4, alan.obtenerPuntajeTotal());
    }

    @Test
    public void testAplicarExclusividadEnAsignadorExclusivoFuncionaCorrectamente(){
        asignadorExclusivo = asignadorExclusivo.aplicarExclusividad();
        german.guardarPuntajeDePregunta(2);
        alan.guardarPuntajeDePregunta(1);
        asignadorExclusivo.asignarPuntos(jugadores);
        Assertions.assertEquals(8, german.obtenerPuntajeTotal());
        Assertions.assertEquals(0, alan.obtenerPuntajeTotal());
    }

    @Test
    public void testAsignadorComunAsignaCorrectamenteLosPuntos(){
        german.guardarPuntajeDePregunta(2);
        alan.guardarPuntajeDePregunta(3);
        asignadorComun.asignarPuntos(jugadores);
        Assertions.assertEquals(2, german.obtenerPuntajeTotal());
        Assertions.assertEquals(3, alan.obtenerPuntajeTotal());
    }

    @Test
    public void testAplicarExclusividadEnAsignadorComunFuncionaCorrectamente(){
        german.guardarPuntajeDePregunta(2);
        alan.guardarPuntajeDePregunta(4);
        asignadorComun = asignadorComun.aplicarExclusividad();
        asignadorComun.asignarPuntos(jugadores);
        Assertions.assertEquals(0, german.obtenerPuntajeTotal());
        Assertions.assertEquals(8, alan.obtenerPuntajeTotal());
    }
}
