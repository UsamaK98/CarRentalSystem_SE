package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DealComplain_Controller {
	@FXML
	private Button Done;
	@FXML
	private RadioButton button1;
	@FXML
	private RadioButton button2;
	@FXML
	private RadioButton button3;
	@FXML
	private RadioButton button4;
	
	public void toHomepage(ActionEvent event) throws IOException
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../view/Manager_Actions.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
