package org.rh_iudigital;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader loader = loadFXML("Inicio");
        Parent root = loader.getRoot();

        scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Gestión de Funcionarios");
        stage.show();
    }

    static FXMLLoader setRoot(String fxml) throws IOException {
        FXMLLoader loader = loadFXML(fxml);
        Parent root = loader.getRoot();
        scene.setRoot(root);
        return loader;
    }

    private static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.load();
        return fxmlLoader;
    }



    public static void main(String[] args) {
        launch();
    }

}