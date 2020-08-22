package edu.fiuba.algo3.modelo.preguntas;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class GeneradorDePreguntas {
    public Queue<Pregunta> obtenerPreguntas() {
        return leerPreguntasJSON();
    }

    private Queue<Pregunta> leerPreguntasJSON() {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("src/main/java/edu/fiuba/algo3/modelo/preguntas/preguntas.json");

        LotePreguntas preguntas = new LotePreguntas(new LinkedList<>());
        try {
            preguntas = objectMapper.readValue(file, LotePreguntas.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return preguntas.obtenerPreguntas();
    }
}