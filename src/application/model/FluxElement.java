package application.model;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class FluxElement {
	private String name;
	private String description;
	private String imageURL;
	private String contentURL;
	private String date;
	private Image  image;
	private WritableImage  wrapped;

	public int width = 100;
	public int height = 100;

	public FluxElement() {
    }

	public FluxElement(String name, String description, String imageURL, String contentURL, String date) {
		this.name = name;
		this.description = description;
		this.imageURL = imageURL;
		this.contentURL = contentURL;
		this.date = date;
		this.image = new Image(this.imageURL);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public Image getImage() {
		return image;
	}

	public WritableImage getWrappedImage() {
		return wrapped;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getContentURL() {
		return contentURL;
	}

	public void setContentURL(String contentURL) {
		this.contentURL = contentURL;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
