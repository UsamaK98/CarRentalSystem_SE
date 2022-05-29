package application;

import services.DBHandler;
import model.Car;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

public class CRMS {

	public static DBHandler store;
	
	CRMS(){
		super();
		createFile("Cars");
		createFile("Customers");
		createFile("Invoices");
		createFile("Feedbacks");
	}
	
	public static boolean addNCar (String name, String make, String type, String rent) {
		String details = name + " " + make + " " + type + " " + rent;
		writeToFile("Cars", details);
		Car n_car = new Car(name, make, type, rent);
		store.AddNewCar(n_car);
		return true;
	}
	
	public static boolean addNCustomer (String name, String age, String number, String email, String address) {
		//Customer n_customer = new Customer (name, age, number, email, address);
		//store.addNewCustomer(n_customer);
		String details = name + " " + age + " " + number + " " + email + " " + address;
		writeToFile("Customers", details);
		return true;
	}
	
	public static boolean addNFeedback (String feedback) {
		writeToFile("Feedbacks", "\n" + feedback);
		return true;
	}
	
	public static void createFile (String fname) {
		try {
			File myObj = new File(fname);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public static void writeToFile (String fname, String input) {
		try {
		      FileWriter myWriter = new FileWriter(fname);
		      myWriter.write(input + "\n");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
}
