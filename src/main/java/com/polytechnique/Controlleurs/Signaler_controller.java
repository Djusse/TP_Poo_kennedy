package com.polytechnique.Controlleurs;

import com.polytechnique.LogiqueMetier.Appareil.Appareil;
import com.polytechnique.LogiqueMetier.BD.Manipulation_Table.Table_Appareil;
import com.polytechnique.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Signaler_controller implements Initializable {

    @FXML
    private ChoiceBox<String> cathegorie_choice_box;
    @FXML
    private Button close_button;
    @FXML
    private TextField id_textfield;
    @FXML
    private TextField nom_textfield;
    @FXML
    private ImageView photo_image_view;
    @FXML
    private Button signaler_button;
    @FXML
    private ChoiceBox<String> type_choice_box;
    @FXML
    private Button retour;



    //boutton close pour fermer l'app
    @FXML
    void on_action_close(ActionEvent event){
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }

    //boutton SIGNALER pour signaler la perte via l'app
    @FXML
    void on_action_signaler(ActionEvent event) throws IOException {
        if(cathegorie_choice_box.getValue().isEmpty()||
                nom_textfield.getText().isEmpty()||
                type_choice_box.getValue().isEmpty()||
                id_textfield.getText().isEmpty()){
            //on affiche les messages d'alerte
            showAlert("Champs Vide","Veuillez remplir tous les champs");
        }
        else{
            //on verifie si l'appareil a deja été déclaré comme perdu
            Appareil a= new Appareil(id_textfield.getText(),nom_textfield.getText(),cathegorie_choice_box.getValue(),type_choice_box.getValue(),Login_controller.u.getIdUtilisateur());
            Appareil b= new Appareil();
            b= Table_Appareil.rechercher(id_textfield.getText());
            if(b==null){
                // l'appareil n'existe pas donc on l'ajoute dans la bd
                boolean c;
                c=Table_Appareil.ajouterAppareil(a);
                if(c){
                    // si l'appareil a bien été ajouté
                    showAlert("Appareil Enregistré","l'appareil a bien été signalé comme égaré");
                }
                else{
                    showAlert("Appareil Non Ajouté","L'appareil n'a pas été ajouté");
                }
            }
            else{
                showAlert("Appareil Existant","L'appareil a déja été enregistré comme égaré");
            }
        }
    }

    //Button retour pour revenir a la vue principale
    @FXML
    void on_action_retour(ActionEvent e)throws Exception{
        Main.setRout("Main_view");
    }

    // petite fonction pour afficher les messages d'alerte a l'écran
    public static void showAlert(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //fonction pour initialiser la vue Signaler_vue
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // ici on rempli les champs et en fonction des categories on aura certains types

        // Ajout des catégories
        cathegorie_choice_box.getItems().addAll("Téléphonie", "Informatique", "Périphérique", "Audio visuel", "Réseau", "Photographie", "Médical","Autre");

        // Map pour associer les types aux catégories
        Map<String, List<String>> typeMap = new HashMap<>();
        typeMap.put("Téléphonie", List.of("Smartphone", "Téléphone fixe", "Tablette","Autre"));
        typeMap.put("Informatique", List.of("Laptop", "NAS", "Serveur", "Desktop","Autre"));
        typeMap.put("Périphérique", List.of("Clavier", "Souris", "Imprimante", "Scanner","Autre"));
        typeMap.put("Audio visuel", List.of("Téléviseur", "Projecteur", "Casque audio", "Soundbar","Autre"));
        typeMap.put("Réseau", List.of("Routeur", "Switch", "Modem", "Carte Réseau","Autre"));
        typeMap.put("Photographie", List.of("Appareil photo", "Drone", "Stabilisateur","Autre"));
        typeMap.put("Médical", List.of("Tensiomètre", "Thermomètre", "Oxymètre", "Nébuliseur","Autre"));
        // Gestion des événements : Mise à jour de Type en fonction de la Catégorie sélectionnée
        cathegorie_choice_box.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            type_choice_box.getItems().clear();
            if (newValue != null && typeMap.containsKey(newValue)) {
                type_choice_box.getItems().addAll(typeMap.get(newValue));
            }
        });
    }
}
