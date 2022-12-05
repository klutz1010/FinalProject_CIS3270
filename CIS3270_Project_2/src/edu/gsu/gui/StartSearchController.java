package edu.gsu.gui;

	import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
// Search Flight by origin city, destination and/or date of departure
	public class StartSearchController implements Initializable {


	    @FXML
	    private Text dateOfDeparture;

	    @FXML
	    private TextField dateOfDepartureInput;

	    @FXML
	    private Text destination;

	    @FXML
	    private TextField destinationInput;

	    @FXML
	    private Button mainMenu;

	    @FXML
	    private Text originCity;

	    @FXML
	    private TextField originCityInput;

	    @FXML
	    private Button searchButton;

	    @FXML
	    void handleMainMenu(ActionEvent event) {
	    	

	    }

	    @FXML
	    void handleSearch(ActionEvent event) {

	    }

	    @FXML
	    void searchDatabase(MouseEvent event) {

	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
	    

}

