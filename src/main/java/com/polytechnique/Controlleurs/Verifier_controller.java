package com.polytechnique.Controlleurs;

import com.polytechnique.LogiqueMetier.Appareil.Appareil;
import com.polytechnique.LogiqueMetier.BD.Manipulation_Table.Table_Appareil;
import com.polytechnique.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Verifier_controller implements Initializable {

    @FXML
    private TableColumn<Appareil,String> categorie_column;
    @FXML
    private Button close_button;
    @FXML
    private Label label_egare;
    @FXML
    private Label label_non_egare;
    @FXML
    private TableColumn<Appareil,String> nom_column;
    @FXML
    private TableColumn<Appareil,String> numero_serie_column;
    @FXML
    private TextField rechercher_textfield;
    @FXML
    private Button termine_button;
    @FXML
    private TableColumn<Appareil,String> type_column;
    @FXML
    private TableView<Appareil> table_view;




    @FXML
    void on_action_close(ActionEvent event ){
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }

    @FXML
    void rechercher(ActionEvent event) {
        if(rechercher_textfield.getText().isEmpty()){
            showAlert("ChampVide","Veuillez insérer l'identifiant de l'objet a rechercher");
        }
        else{
            Appareil a= new Appareil();
            a= Table_Appareil.rechercher(rechercher_textfield.getText());
            label_egare.setVisible(false);
            label_non_egare.setVisible(false);

            if(a==null){
                label_non_egare.setVisible(true);
            }
            else{
                label_egare.setVisible(true);
                table_view.setVisible(true);
                showAlert("Signalisation Propriétaire","Signalé au Propiétaire");
                // affichons les donnée
                type_column.setCellValueFactory(new PropertyValueFactory<>("type"));
                categorie_column.setCellValueFactory(new PropertyValueFactory<>("categorie"));
                nom_column.setCellValueFactory(new PropertyValueFactory<>("nom"));
                numero_serie_column.setCellValueFactory(new PropertyValueFactory<>("numeroSerie"));

                ObservableList<Appareil> data = FXCollections.observableArrayList();
                table_view.setItems(data);
                data.add(a);
            }
        }

    }

    // petite fonction pour afficher les messages d'alerte a l'écran
    public static void showAlert(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void on_action_terminer(ActionEvent event)throws IOException {
        Main.setRout("Main_view");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table_view.setVisible(false);
    }
}
