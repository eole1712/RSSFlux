package application;

import java.io.IOException;

import application.model.FluxElement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<FluxElement> fluxList = FXCollections.observableArrayList();

    public MainApp() {
    	fluxList.addAll(
    		new FluxElement(
    			"A Londres, une attaque touche un symbole de la démocratie britannique",
    			"Un terroriste a frappé mercredi la capitale, causant la mort de trois personnes. Vingt-neuf personnes, dont sept dans un état critique, restaient hospitalisées jeudi matin.",
    			"http://s2.lemde.fr/image/2017/03/23/644x322/5099267_3_5bf4_des-policiers-armes-securisent-le-quartier-de-l_dabbac08c724f74baee3fca7e81d1a22.jpg",
    			"http://www.lemonde.fr/international/article/2017/03/23/a-londres-une-attaque-terroriste-touche-le-coeur-du-pouvoir_5099195_3210.html?xtor=RSS-3208",
    			"Thu, 23 Mar 2017 03:22:39 +0100"
    		),
    		new FluxElement(
    			"Présidentielle : ce que révèlent les déclarations de patrimoine des onze candidats",
    			"Les documents publiés mercredi par la Haute Autorité pour la transparence de la vie publique font apparaître des fortunes diverses des prétendants à l’Elysée.",
    			"http://s1.lemde.fr/image/2017/03/23/644x322/5099336_3_a8f8_mosaique-des-candidats-a-la-presidentielle-av_d0a3d58d01b12477447dceb542050662.jpg",
    			"http://www.lemonde.fr/les-decodeurs/article/2017/03/23/presidentielle-ce-que-revelent-les-declarations-de-patrimoine-des-onze-candidats_5099261_4355770.html?xtor=RSS-3208",
    			"Thu, 23 Mar 2017 06:46:24 +0100"
    		)
    	);
    }

    public ObservableList<FluxElement> getFluxList() {
        return fluxList;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ULTIMATE RSS");

        try {
            // Load the root layout from the fxml file
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }

        showFluxOverview();
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showFluxOverview() {
        try {
            // Load the fxml file and set into the center of the main layout
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/MainView.fxml"));
            AnchorPane overviewPage = (AnchorPane) loader.load();
            rootLayout.setCenter(overviewPage);

            // Give the controller access to the main app
            FluxOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }
    }
}