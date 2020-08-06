package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.VistaGeneral;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VistaGeneral vistaGeneral = new VistaGeneral();
        VBox contenedorPrincipal = vistaGeneral.start(stage);

        Scene scene = new Scene(contenedorPrincipal, 300, 250);

        stage.setScene(scene);

        stage.show();

        /*var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args) {
        launch();
    }

}