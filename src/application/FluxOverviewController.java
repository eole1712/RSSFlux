package application;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import application.model.FluxElement;

public class FluxOverviewController {

	@FXML
	private ListView<FluxElement> fluxList;


	// Reference to the main application
	private MainApp mainApp;

	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		fluxList.setItems(this.mainApp.getFluxList());

		fluxList.setCellFactory(fluxListView -> new FluxElementViewController());
	}
}
