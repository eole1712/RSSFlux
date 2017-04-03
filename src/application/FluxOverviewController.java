package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import application.model.FluxElement;
import javafx.application.Application;

public class FluxOverviewController {

    @FXML
    private ListView<FluxElement> fluxList;

    @FXML
    private void initialize() {
        // Add observable list data to the table
        fluxList.setItems(MainApp.getInstance().getFluxList());
        fluxList.setCellFactory(fluxListView -> new FluxElementViewController());
    }
}
