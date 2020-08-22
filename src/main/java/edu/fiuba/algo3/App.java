package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.VistaGeneral;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VistaGeneral vistaGeneral = new VistaGeneral();
        stage.setFullScreen(true);
        vistaGeneral.start(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}