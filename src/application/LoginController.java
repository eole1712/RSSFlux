/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Login Controller.
 * @author piwa
 */
public class LoginController implements Initializable {
    @FXML private TextField userId;
    @FXML private PasswordField password;
    @FXML private Label errorMessage;

    @FXML protected void processLogin() {
        if(!MainApp.getInstance().userLogging(userId.getText(), password.getText())){
            errorMessage.setText("La combinaison Utilisateur/Mot de passe n'est pas valide.");
        }
    }

    @Override public void initialize(URL url, ResourceBundle rb) {
        userId.setPromptText("admin");
        password.setPromptText("admin");
    }
}
