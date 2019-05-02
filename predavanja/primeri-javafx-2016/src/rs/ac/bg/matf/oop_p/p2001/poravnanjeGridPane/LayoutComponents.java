package rs.ac.bg.matf.oop_p.p2001.poravnanjeGridPane;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;

public class LayoutComponents extends Application
{
	/**
	 * @param args
	 *          the command line arguments
	 */
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Chapter 1-8 Layout Components");
		Group root = new Group();
		Scene scene = new Scene(root, Color.WHITE);
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(5);
		gridpane.setVgap(5);
		Label fNameLbl = new Label("First Name");
		TextField fNameFld = new TextField();
		Label lNameLbl = new Label("First Name");
		TextField lNameFld = new TextField();
		Button saveButt = new Button("Save");
		// First name label
		GridPane.setHalignment(fNameLbl, HPos.RIGHT);
		gridpane.add(fNameLbl, 0, 0);
		// Last name label
		GridPane.setHalignment(lNameLbl, HPos.RIGHT);
		gridpane.add(lNameLbl, 0, 1);
		// First name field
		GridPane.setHalignment(fNameFld, HPos.LEFT);
		gridpane.add(fNameFld, 1, 0);
		// Last name field
		GridPane.setHalignment(lNameFld, HPos.LEFT);
		gridpane.add(lNameFld, 1, 1);
		// Save button
		GridPane.setHalignment(saveButt, HPos.RIGHT);
		gridpane.add(saveButt, 1, 2);
		root.getChildren().add(gridpane);		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
