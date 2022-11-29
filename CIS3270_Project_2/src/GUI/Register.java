package GUI;

import javafx.application.Application;
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

public class Register {

	public static void display(String title, String message) {
		
		TextField tfName = new TextField();
		TextField tlName = new TextField();
		TextField tAddress = new TextField();
		TextField tZip = new TextField();
		TextField tState = new TextField();
		TextField tUserName = new TextField();
		TextField tEmail = new TextField();
		TextField tSSN = new TextField();
		TextField tSecutiryQ = new TextField();
		TextField tSecutiryA = new TextField();
		PasswordField tPassword = new PasswordField();
		PasswordField tConfirm = new PasswordField();
		Button button = new Button();
		Button button0 = new Button();
		Label Title = new Label();
		Stage window = new Stage();
		
		window.setTitle("Register");
		window.setResizable(false);
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(10, 10, 10, 10));

		Label firstNameLbl = new Label();
		firstNameLbl.setLayoutX(170.0);
		firstNameLbl.setLayoutY(81.0);
		firstNameLbl.setText("First Name");
		firstNameLbl.setFont(new Font(20.0));

		Label lastNameLbl = new Label();
		lastNameLbl.setLayoutX(171.0);
		lastNameLbl.setLayoutY(114.0);
		lastNameLbl.setText("Last Name");
		lastNameLbl.setFont(new Font(20.0));

		Label addressLbl = new Label();
		addressLbl.setLayoutX(194.0);
		addressLbl.setLayoutY(149.0);
		addressLbl.setText("Address");
		addressLbl.setFont(new Font(20.0));

		Label zipLbl = new Label();
		zipLbl.setLayoutX(184.0);
		zipLbl.setLayoutY(184.0);
		zipLbl.setText("Zip Code");
		zipLbl.setFont(new Font(20.0));

		Label stateLbl = new Label();
		stateLbl.setLayoutX(218.0);
		stateLbl.setLayoutY(221.0);
		stateLbl.setText("State");
		stateLbl.setFont(new Font(20.0));

		Label userLbl = new Label();
		userLbl.setLayoutX(174.0);
		userLbl.setLayoutY(256.0);
		userLbl.setText("Username");
		userLbl.setFont(new Font(20.0));

		Label passLbl = new Label();
		passLbl.setLayoutX(177.0);
		passLbl.setLayoutY(287.0);
		passLbl.setText("Password");
		passLbl.setFont(new Font(20.0));

		Label pconfirmPassLbl = new Label();
		pconfirmPassLbl.setLayoutX(103.0);
		pconfirmPassLbl.setLayoutY(329.0);
		pconfirmPassLbl.setText("Confirm Password");
		pconfirmPassLbl.setFont(new Font(20.0));

		Label emailLbl = new Label();
		emailLbl.setLayoutX(217.0);
		emailLbl.setLayoutY(362.0);
		emailLbl.setText("Email");
		emailLbl.setFont(new Font(20.0));

		Label ssnLbl = new Label();
		ssnLbl.setLayoutX(222.0);
		ssnLbl.setLayoutY(392.0);
		ssnLbl.setText("SSN");
		ssnLbl.setFont(new Font(20.0));

		Label secQLbl = new Label();
		secQLbl.setLayoutX(105.0);
		secQLbl.setLayoutY(434.0);
		secQLbl.setText("Security Question");
		secQLbl.setFont(new Font(20.0));

		Label secALbl = new Label();
		secALbl.setLayoutX(124.0);
		secALbl.setLayoutY(472.0);
		secALbl.setText("Security Answer");
		secALbl.setFont(new Font(20.0));

		tfName.setLayoutX(274.0);
		tfName.setLayoutY(83.0);
		tfName.setPromptText("First Name");

		tlName.setLayoutX(274.0);
		tlName.setLayoutY(116.0);
		tlName.setPromptText("Last Name");

		tAddress.setLayoutX(274.0);
		tAddress.setLayoutY(151.0);
		tAddress.setPromptText("Address");

		tZip.setLayoutX(274.0);
		tZip.setLayoutY(186.0);
		tZip.setPromptText("#####");

		tState.setLayoutX(274.0);
		tState.setLayoutY(223.0);
		tState.setPromptText("State");

		tUserName.setLayoutX(274.0);
		tUserName.setLayoutY(258.0);
		tUserName.setPromptText("Username");

		tEmail.setLayoutX(274.0);
		tEmail.setLayoutY(364.0);
		tEmail.setPromptText("Example@example.com");

		tSSN.setLayoutX(274.0);
		tSSN.setLayoutY(402.0);
		tSSN.setPromptText("###-##-####");

		tSecutiryQ.setLayoutX(274.0);
		tSecutiryQ.setLayoutY(436.0);
		tSecutiryQ.setPromptText("Security Question");

		tSecutiryA.setLayoutX(274.0);
		tSecutiryA.setLayoutY(474.0);
		tSecutiryA.setPromptText("Security Answer");

		tPassword.setLayoutX(274.0);
		tPassword.setLayoutY(290.0);
		tPassword.setPromptText("Password");

		tConfirm.setLayoutX(274.0);
		tConfirm.setLayoutY(329.0);
		tConfirm.setPromptText("Confirm PAssword");

		button.setLayoutX(284.0);
		button.setLayoutY(534.0);
		button.setMnemonicParsing(false);
		button.setPrefHeight(25.0);
		button.setPrefWidth(105.0);
		button.setText("Register");


		button0.setLayoutX(154.0);
		button0.setLayoutY(534.0);
		button0.setMnemonicParsing(false);
		button0.setText("Return To Log In");


		Title.setLayoutX(204.0);
		Title.setLayoutY(14.0);
		Title.setText("Register User");
		Title.setFont(new Font(24.0));

		anchor.getChildren().addAll(firstNameLbl,lastNameLbl,addressLbl,zipLbl, stateLbl,userLbl,passLbl,
				pconfirmPassLbl, emailLbl,ssnLbl,secQLbl,secALbl,tfName, tlName, tAddress, tZip, tState,tUserName,
				tEmail, tSSN, tSecutiryQ, tSecutiryA, tPassword, tConfirm, button, button0, Title);
		
		
		Scene scene = new Scene(anchor, 613, 612);
		window.setScene(scene);
		window.show();
		window.centerOnScreen();
		
	}

}


