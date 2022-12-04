package edu.gsu.gui;

import java.net.URL;
import java.util.ResourceBundle;
import edu.gsu.common.Admin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdminAddFlightControl implements Initializable{
	
	@FXML
	private TextField tf_airlineName;
	@FXML
	private TextField tf_flightNumber;
	@FXML
	private TextField tf_originCity;
	@FXML
	private TextField tf_destinationCity;
	@FXML
	private TextField tf_departureDate;
	@FXML
	private TextField tf_departureTime;
	@FXML
	private TextField tf_arrivalDate;
	@FXML
	private TextField tf_arrivalTime;
	@FXML
	private TextField tf_flightCapacity;
	@FXML
	private TextField tf_seatsAvailable;
	@FXML
	private TextField tf_isFull;
	@FXML
	private Button button_addflightdatadb;
	@FXML
	private Button button_backtoadminpage;

	@Override
	public void initialize(URL location, ResourceBundle resource) {
		// TODO Auto-generated method stub
		button_addflightdatadb.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				Admin.addFlightData(event, tf_airlineName.getText(), tf_flightNumber.getText(), tf_originCity.getText(),
						tf_destinationCity.getText(), tf_departureDate.getText(), tf_departureTime.getText(), tf_arrivalDate.getText(),
						tf_arrivalTime.getText(), Integer.parseInt(tf_flightCapacity.getText()), Integer.parseInt(tf_seatsAvailable.getText()),
						Integer.parseInt(tf_isFull.getText()));
				
			}
		});
		
		button_backtoadminpage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "AdminPage.fxml", "Admin Page", null);
				
			}
		});
	}

}
