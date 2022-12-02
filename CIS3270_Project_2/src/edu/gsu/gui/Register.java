package edu.gsu.gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.DBUtils;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
	private TextField tf_firstname;
	@FXML
	private TextField tf_lastname;
	@FXML
	private TextField tf_address;
	@FXML
	private TextField tf_state;
	@FXML
	private TextField tf_zipcode;
	@FXML
	private TextField tf_emailaddress;
	@FXML
	private TextField tf_socialsecurity;
	@FXML
	private TextField tf_securityanswer;
	@FXML
	private Button button_signup;
	@FXML
	private Button button_mainpage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		button_signup.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			
				
				if (
						!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty() &&
						!tf_firstname.getText().trim().isEmpty() && !tf_lastname.getText().trim().isEmpty() &&
						!tf_address.getText().trim().isEmpty() && !tf_state.getText().trim().isEmpty() &&
						!tf_zipcode.getText().trim().isEmpty() && !tf_emailaddress.getText().trim().isEmpty() &&
						!tf_socialsecurity.getText().trim().isEmpty() && !tf_securityanswer.getText().trim().isEmpty()
						
						) {
					
					DBUtils.signUp(event, tf_username.getText(), tf_password.getText(), tf_firstname.getText(), tf_lastname.getText(),
											tf_address.getText(), tf_state.getText(), tf_zipcode.getText(), tf_emailaddress.getText(),
											tf_socialsecurity.getText(), tf_securityanswer.getText()
							);
					
				}else {
					//if the info is not all filled out. show alert.
					System.out.println("Please Fill in all info");
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Please fill in all info to sign up.");
					alert.show();
				}
				
				
			}
			
			
		});
		
		button_mainpage.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DBUtils.changeScene(event, "Main.fxml", "Welcome", null);
			}
			
			
			
		});
		
		
		
	}



}


