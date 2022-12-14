package edu.gsu.gui;

import java.net.URL;
import java.util.ResourceBundle;

import edu.gsu.common.Admin;
import edu.gsu.common.Customer;
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
	private Button button_adminlogin;
	@FXML
	private Button button_signup;
	@FXML
	private Button button_resetpassword;
	
	//recalling the stored user name.
	Customer data = Customer.getStoredUserName();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		button_login.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				data.setUserName(tf_username.getText());
				Action.loginUser(event, tf_username.getText(), tf_password.getText());
					
				}

		});
		
		button_adminlogin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				Admin.adminLogin(event, tf_username.getText(), tf_password.getText());
					
				}

		});
				
		button_signup.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Action.changeScene(event, "Register.fxml", "Registration", null);
				
			}
			
		});
				
		button_resetpassword.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Action.changeScene(event, "ForgotPassword.fxml", "Reset Your Password", null);
				
			}
			
		});
		
		
	}

}
