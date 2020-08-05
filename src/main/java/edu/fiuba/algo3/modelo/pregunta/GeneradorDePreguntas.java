package edu.fiuba.algo3.modelo.pregunta;



import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    public LotePreguntas leerPreguntasJSON() {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("src/main/java/edu/fiuba/algo3/modelo/pregunta/preguntas.json");

        LotePreguntas preguntas = null;
        try {
            preguntas = objectMapper.readValue(file, LotePreguntas.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return preguntas;
        /*preguntas.getPreguntasMultipleChoiceClasico().forEach(pregunta ->
                pregunta.opcionesCorrectas.forEach(opcionC ->
                                System.out.println(pregunta.pregunta +" " + opcionC.opcion)
                )
        );

        preguntas.getPreguntasMultipleChoiceClasico().forEach(pregunta ->
                pregunta.opcionesIncorrectas.forEach(opcionI ->
                        System.out.println(pregunta.pregunta +" " + opcionI.opcion)
                )
        );

        preguntas.getPreguntasVoF().forEach(pregunta ->
                pregunta.opcionesCorrectas.forEach(opcionC ->
                        System.out.println(pregunta.pregunta +" " + opcionC.opcion)
                )
        );

        preguntas.getPreguntasVoF().forEach(pregunta ->
                pregunta.opcionesIncorrectas.forEach(opcionI ->
                        System.out.println(pregunta.pregunta +" " + opcionI.opcion)
                )
        );*/



    }

    private Pregunta leerPregunta(Scanner lector) {
        String linea = lector.nextLine();
        //todo: parsear
        return new PreguntaVerdaderoOFalso(null, null, null);
    }
}