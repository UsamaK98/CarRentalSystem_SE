package controller;

import java.io.IOException;
import application.CRMS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class toHomepage_Controller {
	@FXML
	private Button homepage;
	
	@FXML
	private TextArea feedback;
	
	
	public void tohomePage(ActionEvent event) throws IOException
	{
		CRMS.addNFeedback(feedback.getText());
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../view/Use_cases.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
