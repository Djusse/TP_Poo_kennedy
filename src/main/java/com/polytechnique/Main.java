package com.polytechnique;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class Main extends Application {
    static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login_view"));
        stage.setTitle("Travaux Pratique 2");
        stage.setScene(scene);
        // pour camoufler le stage
        stage.initStyle(StageStyle.TRANSPARENT);
        // pour afficher le stage (1920x1080)
        stage.show();
    }

// deux fonctions statique pour pouvoir switcher entre les différentes vues
    public static void setRout(String fxml) throws IOException {
        Main.scene.setRoot(loadFXML(fxml));
    }
    public static Parent loadFXML(String fxml) throws  IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Vues" + "/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch();
    }
}