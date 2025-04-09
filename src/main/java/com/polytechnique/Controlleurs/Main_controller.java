package com.polytechnique.Controlleurs;

import com.polytechnique.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main_controller implements Initializable {

    @FXML
    private Button signaler_button;
    @FXML
    private Button verifier_button;
    @FXML
    private Button close_button;
    @FXML
    private AnchorPane main_anchorpane;

    @FXML
    void on_action_close(ActionEvent event){
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }

    @FXML
    void signaler(ActionEvent event) throws IOException {
        Main.setRout("Signaler_view");
    }

    @FXML
    void verifier(ActionEvent event) throws IOException {
        Main.setRout("Verifier_view");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        main_anchorpane.setStyle("-fx-background-color: transparent; -fx-alignment: center;");
    }
}
