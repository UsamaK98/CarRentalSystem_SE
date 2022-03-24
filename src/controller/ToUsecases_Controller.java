package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class ToUsecases_Controller {
	@FXML
	private Button login;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	String s1,s2;
	public void toUsecases(ActionEvent event) throws IOException
	{
		s1=username.getText();
		s2=password.getText();
		if(s1.equals("saim")  &&  s2.equals("1234")) {
		
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../view/Use_cases.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();
		}
		else
		{
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Login Failed");
			errorAlert.showAndWait(); 
		}
		
		
	}
}
