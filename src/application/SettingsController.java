package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import application.model.Feed;
import javafx.scene.control.TextField;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

/**
 * Settings Controller.
 * @author piwa
 */
public class SettingsController {

    @FXML
    private ListView<Feed> feedList;

    @FXML
    private TextField urlField;

    private Feed feed;

    public class SettingsFeedView extends ListCell<Feed> {

        @FXML
        private Label urlLabel;

        @FXML
        private AnchorPane SettingsFeedViewPane;

        private FXMLLoader mLLoader;

        @Override
        protected void updateItem(Feed element, boolean empty) {
            super.updateItem(element, empty);
            if(empty || element == null) {
                setText(null);
                setGraphic(null);
            } else {
                if (mLLoader == null) {
                    mLLoader = new FXMLLoader(getClass().getResource("view/SettingsFeedView.fxml"));
                    mLLoader.setController(this);

                    try {
                        mLLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                urlLabel.setText(element.getUrl());
                setText(null);
                setGraphic(SettingsFeedViewPane);
            }
        }
        
        @FXML
        private void handleRemove() {
            feedList.getItems().remove(getItem());
        }
    }

    @FXML
    private void initialize() {
        // Add observable list data to the table
        feedList.setItems(MainApp.getInstance().getFeedList());
        feedList.setCellFactory(feedListView -> new SettingsFeedView());
    }
    
    private boolean isInputValid() {
    	/* faire des vérifications par rapport au feed */
        if (urlField.getText().isEmpty()) {
            return false;
        }
    	return true;
    }
    
    @FXML
    private void handleAdd() {
        if (isInputValid()) {
            feed = new Feed();
            feed.setUrl(urlField.getText());
            
            MainApp.getInstance().addFeedList(feed);

            urlField.clear();
        }
    }
}
