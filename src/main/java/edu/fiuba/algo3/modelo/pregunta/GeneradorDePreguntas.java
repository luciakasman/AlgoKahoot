package edu.fiuba.algo3.modelo.pregunta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GeneradorDePreguntas {

    public Queue<Pregunta> obtenerPreguntas() {
        Queue<Pregunta> preguntas = new LinkedList<>();

        try {
            File archivo = new File("/home/luciak/Documentos/Algoritmos y Programación 3/TP2-Algo3/src/main/java/edu/fiuba/algo3/modelo/pregunta/preguntas.txt");
            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                preguntas.add(leerPregunta(lector));
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return preguntas;
    }

    private Pregunta leerPregunta(Scanner lector) {
        String linea = lector.nextLine();
        //todo: parsear
        return new Pregunta(null, null, null);
    }
}
