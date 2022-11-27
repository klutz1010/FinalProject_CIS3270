package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
	
	static boolean answer;
	
	public static boolean display(String title, String message) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle(title);
		window.setMinWidth(200);
		window.setMinHeight(300);
		
		Label label1 = new Label();
		label1.setText(message);
		Button closeButton = new Button("Close the button");
		closeButton.setOnAction(e -> window.close());
		
		//button creation
		Button yesButton = new Button("YES");
		Button noButton = new Button("NO");
		
		yesButton.setOnAction(e -> {
		
				answer = true;
				window.close();
		});
		
		noButton.setOnAction(e -> {
			
			answer = false;
			
		});
		
		
		VBox layout1 = new VBox(10);
		layout1.getChildren().addAll(label1, yesButton, noButton);
		layout1.setAlignment(Pos.CENTER);
		
		Scene scene1 = new Scene(layout1);
		window.setScene(scene1);
		window.showAndWait();
		
		return answer;
		
	}


}



