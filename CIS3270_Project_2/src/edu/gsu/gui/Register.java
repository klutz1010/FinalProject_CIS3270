package edu.gsu.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
	
	@FXML
    private ComboBox<String> combobox_securityQuestion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		button_signup.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				String userQuestionChoice = combobox_securityQuestion.getSelectionModel().getSelectedItem();
			
				
				if (
						!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty() &&
						!tf_firstname.getText().trim().isEmpty() && !tf_lastname.getText().trim().isEmpty() &&
						!tf_address.getText().trim().isEmpty() && !tf_state.getText().trim().isEmpty() &&
						!tf_zipcode.getText().trim().isEmpty() && !tf_emailaddress.getText().trim().isEmpty() &&
						!tf_socialsecurity.getText().trim().isEmpty() && !tf_securityanswer.getText().trim().isEmpty()
						
						) {
					
					Action.signUp(event, tf_username.getText(), tf_password.getText(), tf_firstname.getText(), tf_lastname.getText(),
											tf_address.getText(), tf_state.getText(), tf_zipcode.getText(), tf_emailaddress.getText(),
											tf_socialsecurity.getText(), userQuestionChoice, tf_securityanswer.getText()
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
				Action.changeScene(event, "Main.fxml", "Welcome", null);
			}
					
		});
		
		combobox_securityQuestion.setItems(FXCollections.observableArrayList("What city  were you born in?",
				"What if your favorite hobby?", "What is your favorite color?", "What is your Mother's maiden name?",
				"What if your highschool mascot?"
				));
		
//		String userQuestionChoice = combobox_securityQuestion.getSelectionModel().getSelectedItem();
		
	}



}


