package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ForgotPassword {
	
	public static void display(String title, String message) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle(title);
		window.setMinWidth(200);
		
		Label label1 = new Label();
		label1.setText(message);
		Button closeButton = new Button("Invalid Input, try again");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout1 = new VBox(10);
		layout1.getChildren().addAll(label1, closeButton);
		layout1.setAlignment(Pos.CENTER);
		
		Scene scene1 = new Scene(layout1);
		window.setScene(scene1);
		window.showAndWait();
		
		
	}


}
