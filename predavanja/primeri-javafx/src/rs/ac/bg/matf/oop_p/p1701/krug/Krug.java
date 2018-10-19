package rs.ac.bg.matf.oop_p.p1701.krug;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.*;

public class Krug extends Application {
	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 100, 100);

		Circle c1 = new Circle(50.0f, 50.0f, 50.0f, Color.RED);

		root.getChildren().add(c1);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String a[]) {
		Application.launch(a);
	}
}
