package edu.gsu.gui;

import java.net.URL;
import java.util.ResourceBundle;

import edu.gsu.common.Admin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AdminControl implements Initializable {
	
	@FXML
	private Button button_addflightdata;
	@FXML
	private Button button_deleteflightdata;
	@FXML
	private Button button_logout;

	@Override
	public void initialize(URL location, ResourceBundle resource) {
		//put you back to main screen
		button_logout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "Main.fxml", "Main", null);
				
			}
		});
		
		button_addflightdata.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "AdminAddFlight.fxml", "Add Flight Data", null);
				
			}
			
			
		});
		
		button_deleteflightdata.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			}
			
			
		});
	}

}
