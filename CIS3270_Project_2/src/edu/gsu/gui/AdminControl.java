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
	private Button button_editflightdata;
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
		
		
		button_editflightdata.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "AdminEditFlight.fxml", "Edit Flight", null);
				
			}
			
			
		});
	}

}
