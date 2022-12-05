package edu.gsu.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CustomerPageControl implements Initializable {
	
	@FXML
	private Label label_hello;
	
	@FXML
	private Button button_logout;
	
	@FXML
    private Button searchFlightButton;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		button_logout.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "Main.fxml", "Login", null);
				
			}
			
		});
		
	
	// Use Search Flight button to go to next scene
		searchFlightButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
	
				Action.changeScene(event, "StartSearch.fxml", "Search Flight", null);
				
			}
		
	});
}

	public void setUserInformation(String userName) {
			
			label_hello.setText(("Welcome" + userName + " !"));
				
		}
	
	
}
