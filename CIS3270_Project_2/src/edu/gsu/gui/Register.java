package edu.gsu.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Register implements Initializable{
	
	@FXML
	private TextField tf_username;
	@FXML
	private TextField tf_password;
	@FXML
	private TextField tf_firstName;
	@FXML
	private TextField tf_lastname;
	@FXML
	private TextField tf_state;
	@FXML
	private TextField tf_zipcode;
	@FXML
	private TextField tf_emailaddress;
	@FXML
	private TextField tf_socialsecurity;
	@FXML
	private TextField tf_securityquestion;
	@FXML
	private TextField tf_securityanswer;
	@FXML
	private Button button_signup;
	@FXML
	private Button button_mainpage;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		button_signup.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
			
				
				if (!tf_username.getText().trim().isEmpty() && ! tf_password.getText().trim().isEmpty()) {
					
					DBUtils.signUp(event, tf_username.getText(), tf_password.getText());
					
				}
				
				
			}
			
			
		});
		
	}



}


