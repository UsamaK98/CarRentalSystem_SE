package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import application.CRMS;

public class toAddCar_Controller {
	@FXML
	private Button AddCar;
	
	@FXML
	private TextField CarName;
	
	@FXML
	private TextField CarMake;
	
	@FXML
	private TextField CarType;
	
	@FXML
	private TextField CarRent;
	
	public void toHomepage(ActionEvent event) throws IOException {
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../view/Manager_Actions.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void addMyCar(ActionEvent event) throws IOException {
		boolean added = CRMS.addNCar(CarName.getText(), CarMake.getText(), CarType.getText(), CarRent.getText());
		System.out.println(added);
		
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../view/Manager_Actions.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
}
