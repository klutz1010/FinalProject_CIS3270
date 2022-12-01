package edu.gsu.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginControl implements Initializable {
	
	
	@FXML
	private Label label_welcome;
	
	@FXML
	private Button button_searchflight;
	private Button button_yourflight;
	private Button button_cancelflight;
	private Button button_logout;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		button_logout.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				DBUtils.changeScene(event, "login.fxml", "Login", null);
				
				
			}
			
			
		});
		
		
		
	}
	
	public void setUserInformation(String userName) {
		
		label_welcome.setText(("Welcome" + userName + " !"));
			
		
	}


}
