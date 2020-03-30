package rs.ac.bg.matf.oop_p.z200201.iscrtavanje.z03.krug;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class Krug extends Application {
   @Override
   public void start(Stage stage) {
      Parent root = null;
      try {
         root = FXMLLoader.load(getClass().getResource("example.fxml"),
               ResourceBundle.getBundle("rs.ac.bg.matf.oop_p.z200201.iscrtavanje.z03.krug.Krug"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      stage.setScene(new Scene(root));
      stage.show();

   }

   public static void main(String a[]) {
      Application.launch(a);
   }
}
