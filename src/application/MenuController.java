/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author piwa
 */
public class MenuController {
    @FXML
    private void handleSettings() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SettingsView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage settingsStage = new Stage();
            settingsStage.setTitle("Settings");

            Scene scene = new Scene(page);
            settingsStage.setScene(scene);

            settingsStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogout() {
        MainApp.getInstance().loggedUser = null;
        MainApp.getInstance().gotoLogin();
    }

    @FXML
    private void handleExit() {
        Platform.exit();
        System.exit(0);
    }    
}
