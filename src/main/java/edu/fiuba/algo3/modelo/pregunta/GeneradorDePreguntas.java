package edu.fiuba.algo3.modelo.pregunta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GeneradorDePreguntas {

    public List<Pregunta> obtenerPreguntas() {
        List<Pregunta> preguntas = new LinkedList<>();

        try {
            File archivo = new File("src/main/java/edu/fiuba/algo3/modelo/pregunta/preguntas.txt");
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
        return new PreguntaVerdaderoOFalso(null, null, null);
    }
}