package edu.fiuba.algo3.modelo.pregunta;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;

public class GeneradorDePreguntas {

    public Queue<Pregunta> obtenerPreguntas() {
        Queue<Pregunta> preguntas = new LinkedList<>();

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

        leerPreguntasJSON();
        return preguntas;



    }

    private void leerPreguntasJSON() {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("src/main/java/edu/fiuba/algo3/modelo/pregunta/preguntas.json");

        Pregunta pregunta = null;
        try {
            pregunta = objectMapper.readValue(file, Pregunta.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(pregunta.pregunta);
        System.out.print(pregunta.opcionesCorrectas);
        System.out.print(pregunta.opcionesIncorrectas);
    }

    private Pregunta leerPregunta(Scanner lector) {
        String linea = lector.nextLine();
        //todo: parsear
        return new Pregunta(null, null, null);
    }
}
