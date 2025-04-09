package com.polytechnique.Controlleurs;

import com.polytechnique.LogiqueMetier.BD.Manipulation_Table.Table_Utilisateur;
import com.polytechnique.LogiqueMetier.Utilisateur.Utilisateur;
import com.polytechnique.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login_controller implements Initializable {

    // ici nous avons la déclaration de tous les objets de la vue
    @FXML
    private ImageView cardena_1;
    @FXML
    private Button close_button;
    @FXML
    private ImageView cardena_2;
    @FXML
    private Label déja_label;
    @FXML
    private Label enregistrer_connection_label;
    @FXML
    private Label enregistrer_label;
    @FXML
    private ImageView mail_1;
    @FXML
    private ImageView mail_2;
    @FXML
    private TextField mail_connection_textfield;
    @FXML
    private TextField mail_enregistrement_textfield;
    @FXML
    private TextField nom_enregistrement_textfield;
    @FXML
    private Label nouveau_label;
    @FXML
    private Label oublié_connection_label;
    @FXML
    private PasswordField password_connection_passwordfield;
    @FXML
    private PasswordField password_enregistrement_passwordfield;
    @FXML
    private ImageView phone_1;
    @FXML
    private TextField prenom_enregistrement_textfield;
    @FXML
    private Label se_connecter_enregistrement_label;
    @FXML
    private Label se_connecter_label;
    @FXML
    private TextField telephone_enregistrement_textfield;
    @FXML
    private Button valider_connection_button;
    @FXML
    private Button valider_enregistrement_button;

    public static Utilisateur u= new Utilisateur();




    // pour activer et déactiver la visibilité des objets
    public void etat_enregistrement(boolean b){
        cardena_1.setVisible(b);
        valider_enregistrement_button.setVisible(b);
        telephone_enregistrement_textfield.setVisible(b);
        se_connecter_enregistrement_label.setVisible(b);
        prenom_enregistrement_textfield.setVisible(b);
        phone_1.setVisible(b);
        password_enregistrement_passwordfield.setVisible(b);
        nom_enregistrement_textfield.setVisible(b);
        mail_1.setVisible(b);
        mail_enregistrement_textfield.setVisible(b);
        déja_label.setVisible(b);
        enregistrer_label.setVisible(b);
    }
    public void etat_connecter(boolean b){
    se_connecter_label.setVisible(b);
    enregistrer_connection_label.setVisible(b);
    mail_connection_textfield.setVisible(b);
    valider_connection_button.setVisible(b);
    oublié_connection_label.setVisible(b);
    password_connection_passwordfield.setVisible(b);
    mail_2.setVisible(b);
    cardena_2.setVisible(b);
    nouveau_label.setVisible(b);
    }

    // pour vider les objets lorsqu'on change de vue
    public void vider_enregistrement(){
        telephone_enregistrement_textfield.clear();
        prenom_enregistrement_textfield.clear();
        password_enregistrement_passwordfield.clear();
        nom_enregistrement_textfield.clear();
        mail_enregistrement_textfield.clear();
    }
    public void vider_connecter(){
        mail_connection_textfield.clear();
        password_connection_passwordfield.clear();
    }


    //mot de passe oublié (pas encore disponible) car pas encore de connection via mail
    @FXML
    void on_clicked_forget_password(MouseEvent event){
        // disponible ultérieurement
    }

    //boutton personnalisé de fermeture de l'app
    @FXML
    void on_action_close(ActionEvent event){
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }

    //les deux fonction pour soumettre les informations de l'utilisateur en fonction de si il a
    //un compte ou non
    @FXML
    void on_action_valider_connection(ActionEvent event) throws IOException {
        if(mail_connection_textfield.getText().isEmpty() || password_connection_passwordfield.getText().isEmpty()) {
                showAlert("Champs vide", "Erreur Veuillez remplir tous les champs");
        }
        else{
            // si les champs ne sont pas vide on vérifie la validité des infos
            u=null;
            u = Table_Utilisateur.rechercher(mail_connection_textfield.getText(),password_connection_passwordfield.getText());
            if(u==null){
                // si les infos sont éronnée on affiche un message d'alerte
                showAlert("Alerte","Compte Innexistant");
            }
            else{
                // sinon on recupère son id
                u.setIdUtilisateur(Table_Utilisateur.existance_bd(u));
                // on passe a la vue suivante
                Main.setRout("Main_view");
            }
        }

    }
    @FXML
    void on_action_valider_enregistrement(ActionEvent event) throws IOException {
        if( telephone_enregistrement_textfield.getText().isEmpty()||
            prenom_enregistrement_textfield.getText().isEmpty()||
            password_enregistrement_passwordfield.getText().isEmpty()||
            nom_enregistrement_textfield.getText().isEmpty()||
            mail_enregistrement_textfield.getText().isEmpty())
        {
            // si un des champs est vide on affiche un message d'erreur
            showAlert("Champs vide", "Erreur Veuillez remplir tous les champs");
        }
        else{
            // si les champs ne sont pas vide on vérifie si l'utilisateur existe déjà
            u.setMail(mail_enregistrement_textfield.getText());
            u.setNom(nom_enregistrement_textfield.getText());
            u.setPrenom(prenom_enregistrement_textfield.getText());
            u.setTel(telephone_enregistrement_textfield.getText());
            u.setMot_de_passe(password_enregistrement_passwordfield.getText());
            System.out.println(mail_enregistrement_textfield.getText());

            // j'ai considérer dans la logique de l'application que l'ensemble addresse mail et mot de passe iden-
            // tifie de manière unique chaque utilisateur
            Utilisateur u2= new Utilisateur();
            u2 = Table_Utilisateur.rechercher(mail_connection_textfield.getText(),password_connection_passwordfield.getText());

            if(u2==null)
            {
                // si on ne trouve pas d'utilisateur portant les informations remplies plus haut,
                // on l'ajoute a la bd puis on passe a la vue suivante
                boolean b = Table_Utilisateur.ajouterUtilisateur(u);
                // si l'ajout réussi on recupère son identifiant
                u.setIdUtilisateur(Table_Utilisateur.existance_bd(u));
                // on passe a la vue suivante
                if(b)  Main.setRout("Main_view");
                System.out.println(mail_enregistrement_textfield.getText());

            }
            else{
                // s la recherche n'est pas nulle , on affiche un messave
                showAlert("Alerte","Ce compte existe déjà");
            }
        }
    }


    // deux petites fonctions pour se déplacer entre sign_up et sign_in
    @FXML
    void on_clicked_connecter_enregistrement(MouseEvent event) {
        etat_enregistrement(false);
        etat_connecter(true);
        vider_enregistrement();
    }
    @FXML
    void on_clicked_enregistrer_connection(MouseEvent event) {
        etat_enregistrement(true);
        etat_connecter(false);
        vider_connecter();
    }


    // petite fonction pour afficher les messages d'alerte a l'écran
    public static void showAlert(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //fonction d'initialisation de la vue
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        etat_connecter(true);
        etat_enregistrement(false);

    }
}
