package application;

import application.model.FluxElement;
import application.model.Feed;
import application.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    public User loggedUser;
    private static MainApp instance;

    private ObservableList<FluxElement> fluxList = FXCollections.observableArrayList();
    private ObservableList<Feed> feedList = FXCollections.observableArrayList();


    public MainApp() {
        instance = this;
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

    public ObservableList<Feed> getFeedList() {
        return feedList;
    }

    public void addFeedList(Feed feed) {
        feedList.add(feed);
    }
    
    public void removeFeedList(Feed feed) {
        feedList.remove(feed);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static MainApp getInstance() {
        return instance;
    }
        
    public User getLoggedUser() {
        return loggedUser;
    }
    
    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(MainApp.class.getResource(fxml), null, new JavaFXBuilderFactory());
        rootLayout.setCenter(page);
        
        return page;
    }
    
    public void gotoFluxOverview() {
        try {
            replaceSceneContent("view/MainView.fxml");
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoLogin() {
        try {
            replaceSceneContent("view/LoginView.fxml");
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public boolean userLogging(String userId, String password){
        if (Authenticator.validate(userId, password)) {
            loggedUser = User.of(userId);
            gotoFluxOverview();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("ULTIMATE RSS");
            // Load the root layout from the fxml file
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            gotoLogin();
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}