package edu.fiuba.algo3.modelo.preguntas;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GeneradorDePreguntas {

    public List<Pregunta> obtenerPreguntas() {
        return leerPreguntasJSON();
    }

    private List<Pregunta> leerPreguntasJSON() {
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