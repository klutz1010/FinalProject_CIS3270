package edu.gsu.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainControl implements Initializable{
	
	
	@FXML
	private TextField tf_username;
	@FXML
	private TextField tf_password;
	@FXML
	private Button button_login;
	@FXML
	private Button button_signup;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		button_login.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				DBUtils.loginUser(event, tf_username.getText(), tf_password.getText());
				
			}

		});
				
		button_signup.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				DBUtils.changeScene(event, "Register.fxml", "Registration", null);
				
			}
			
		});
				
		
		
		
	}

}