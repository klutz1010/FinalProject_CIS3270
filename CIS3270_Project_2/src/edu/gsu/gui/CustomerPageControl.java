package edu.gsu.gui;

import java.net.URL;
import java.util.ResourceBundle;

import edu.gsu.common.Customer;
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
    private Button button_logout11;
	
	@FXML
    private Button button_logout1;
	
	Customer data = Customer.getStoredUserName();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		button_logout.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "Main.fxml", "Bye Bye", null );
				
			}
			
		});
		
	
	// Use Search Flight button to go to next scene (error)
		button_logout11.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
	
				Action.changeScene(event, "SearchFlight.fxml", "Search Flight", null);
				
			}
		
		});
					
		button_logout1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
					
					Action.changeScene(event, "CustomerEditFlight.fxml", "Your Flight", null);
					
				}
			
		});
		
		label_hello.setText("Welcome" + data.getUserName() + " !");
		
	}

}
