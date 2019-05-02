package rs.ac.bg.matf.oop_p.p2008.mreza;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcBuilder;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Working with the Scene Graph
 * 
 * @author cdea
 */
/**
 * Manipulating Layout Via Grids
 * 
 * @author cdea
 */
public class ManipulatingLayoutViaGrids extends Application
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
		primaryStage.setTitle("Chapter 2-4 Manipulating Layout via Grids ");
		Group root = new Group();
		Scene scene = new Scene(root, 640, 480, Color.WHITE);
		// Left and right split pane
		SplitPane splitPane = new SplitPane();
		splitPane.prefWidthProperty().bind(scene.widthProperty());
		splitPane.prefHeightProperty().bind(scene.heightProperty());
		// Form on the right
		GridPane rightGridPane = new MyForm();
		GridPane leftGridPane = new GridPaneControlPanel(rightGridPane);
		VBox leftArea = new VBox(10);
		leftArea.getChildren().add(leftGridPane);
		HBox hbox = new HBox();
		hbox.getChildren().add(splitPane);
		root.getChildren().add(hbox);
		splitPane.getItems().addAll(leftArea, rightGridPane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}