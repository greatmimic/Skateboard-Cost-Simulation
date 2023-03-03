package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.Scene;


//Brian Kang
//CS2450
//Assignement 2
//03/02/23

//This program prompts the user to enter their selections for a skateboard builder
//and outputs the cost including sales tax(7%), subtotal, tax amount


public class TaskA extends Application{

	//variables
	int deck;
	int axle;
	int wheel;
	int misc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//title
		primaryStage.setTitle("Skateboard Designer");
		//title label
		Label titleLabel = new Label("Build Your Skateboard");
		
		//subtotal label
		Label subtotal = new Label();
		Label stLabel = new Label("Sub Total: ");
		HBox subBox = new HBox(5, stLabel, subtotal);
		
		//Tax Amount label
		Label tax = new Label();
		Label taxLabel = new Label("Tax (7%): ");
		HBox taxBox = new HBox(5, taxLabel, tax);
		
		//Total Cost label
		Label total = new Label();
		Label totLabel = new Label("Total: ");
		HBox totBox = new HBox(5, totLabel, total);
		
		
		
		
		
		//Deck Choice Array
		ObservableList<String> decks = FXCollections.observableArrayList(
				"The Master Thrasher $60",  //0
				"The Dictator $45",			//1
				"The Street King $50"		//2
		);
		//Axle Choice Array
		ObservableList<String> axles = FXCollections.observableArrayList (
				"7.75-inch axle $35",	//0
				"8-inch axle $40",		//1
				"8.5-inch axle $45"		//2
		);
		//Wheel Choice Array
		ObservableList<String> wheels = FXCollections.observableArrayList(
				"51 mm $20",	//0
				"55 mm $22",	//1
				"58 mm $24",	//2
				"61 mm $28"		//3
		);
		//Miscellaneous Products Array
		ObservableList<String> etc = FXCollections.observableArrayList(
				"Grip Tape $10",		//0
				"Bearings $30",			//1
				"Riser Pads $2",		//2
				"Nuts & Bolts Kit $3"	//3
		);
		
		
		
		
		//ListView<String>
		//Deck ListView
		ListView<String> lvDeck = new ListView<String>(decks);
		lvDeck.setMaxHeight(100);
		//on click set value of deck as index of array
		lvDeck.setOnMouseClicked(e->{
			deck = lvDeck.getSelectionModel().getSelectedIndex();
		});
		//Axle ListView
		ListView<String> lvAxle = new ListView<String>(axles);
		lvAxle.setMaxHeight(100);
		//
		lvAxle.setOnMouseClicked(e->{
			axle = lvAxle.getSelectionModel().getSelectedIndex();
		});
		//Wheel ListView
		ListView<String> lvWheel = new ListView<String>(wheels);
		lvWheel.setMaxHeight(100);
		//
		lvWheel.setOnMouseClicked(e->{
			wheel = lvWheel.getSelectionModel().getSelectedIndex();
		});
		//Miscellaneous ListView
		ListView<String> lvEtc = new ListView<String>(etc);
		lvEtc.setMaxHeight(100);
		//
		lvEtc.setOnMouseClicked(e->{
			misc = lvEtc.getSelectionModel().getSelectedIndex();
		});
		
		//HBox to contain ListView controls
		HBox lvBox = new HBox(10, lvDeck, lvAxle, lvWheel, lvEtc);
		lvBox.setAlignment(Pos.CENTER);
		
		//clear button
		Button clear = new Button("Clear");
		//clear button on action
		clear.setOnAction(eventClear -> {
			
			//clear all selection upon clear button
			lvDeck.getSelectionModel().clearSelection();
			lvAxle.getSelectionModel().clearSelection();
			lvWheel.getSelectionModel().clearSelection();
			lvEtc.getSelectionModel().clearSelection();
			
			subtotal.setText("No Charges");
			tax.setText("No Charges");
			total.setText("No Charges");
		});
		
		//Submit Button
		Button submit = new Button("Submit");
		//Submit Button On Action
		submit.setOnAction(event-> {
			
			double TAX_RATE = 0.07;
			double totalCost = 0.0;
			double subtotalCost = 0.0;
			double taxCost = 0.0;
			
			//if deck == 0, 1, 2 indices of deck array
			if(deck == 0) {
				subtotalCost += 60.0;
			}
			else if(deck == 1) {
				subtotalCost += 45.0;
			}
			else if(deck == 2) {
				subtotalCost += 50.0;
			}
			
			//if axle == 0, 1, 2 indices of axle array
			if(axle == 0) {
				subtotalCost += 35.0;
			}
			else if(axle == 1) {
				subtotalCost += 40.0;
			}
			else if(axle == 2) {
				subtotalCost += 45.0;
			}
			
			//if wheel == 0, 1, 2, 3 indices of wheel array
			if(wheel == 0) {
				subtotalCost += 20.0;
			}
			else if(wheel == 1) {
				subtotalCost += 22.0;
			}
			else if(wheel == 2) {
				subtotalCost += 24.0;
			}
			else if(wheel == 3) {
				subtotalCost += 28.0;
			}
			
			//if misc == 0, 1, 2, 3 indices of misc array
			if(misc == 0) {
				subtotalCost += 10.0;
			}
			else if(misc == 1) {
				subtotalCost += 30.0;
			}
			else if(misc == 2) {
				subtotalCost += 2.0;
			}
			else if(misc == 3) {
				subtotalCost += 3.0;
			}
			
			//show subtotal
			subtotal.setText(String.format("$%, .2f Dollars", subtotalCost));
			
			//show tax
			taxCost = subtotalCost * TAX_RATE;
			tax.setText(String.format("$%, .2f Dollars", taxCost));
			
			//show total
			totalCost = subtotalCost + taxCost;
			total.setText(String.format("$%, .2f Dollars", totalCost));
			
			});
		
		//VBox for labels output
		VBox results = new VBox(10, subBox, taxBox, totBox);
		//VBox for actual cost output labels
		VBox output = new VBox(10, subtotal, tax, total);
		HBox resultBox = new HBox(10, results, output);
		resultBox.setAlignment(Pos.CENTER);
		
		
		//main VBox
		VBox mainBox = new VBox(20, titleLabel, lvBox, resultBox, submit, clear);
		mainBox.setAlignment(Pos.CENTER);
		
		
		
		
		
		//Print Scene
		Scene scene = new Scene(mainBox,1200,700);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.show();
		
	}

}
