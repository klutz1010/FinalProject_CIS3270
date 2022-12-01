package edu.gsu.gui; //copy and paste from professor's google drive need to work on this.

public class ExceptionHandler {
	
public static boolean process(Customer co) {
		
		try {
			
			BizLogicProcess.process(co);
			
		} catch (Exception ex) {
			
			  Alert alert = new Alert(AlertType.ERROR);
			  //alert.setTitle("Login Dialog");
			  //alert.setHeaderText("Look, an Information Dialog");
			  alert.setContentText(ex.getMessage());
	      
			  
			  alert.getDialogPane().setStyle("-fx-font-family: 'serif'");
             

			  alert.showAndWait();
			  return false;
		}
		
		return true;
		
		
		
	}

}
