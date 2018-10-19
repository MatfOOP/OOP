package rs.ac.bg.matf.oop_p.p1703.krug;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

public class Krug extends Application {
	@Override
	public void start(Stage stage) {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("example.fxml"),
					ResourceBundle.getBundle("r.fxml_example"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stage.setScene(new Scene(root));
		stage.show();

	}

	public static void main(String a[]) {
		Application.launch(a);
	}
}
