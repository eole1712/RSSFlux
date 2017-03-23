package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import application.model.FluxElement;

public class FluxElementViewController extends ListCell<FluxElement> {

    @FXML
    private Label nameLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private AnchorPane fluxElementViewPane;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(FluxElement element, boolean empty) {
        super.updateItem(element, empty);

        if(empty || element == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("view/FluxElementView.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            Image img = element.getImage();

            nameLabel.setText(element.getName());
            descriptionLabel.setText(element.getDescription());
        	imageView.setImage(img);

            setText(null);
            setGraphic(fluxElementViewPane);
        }

    }
}