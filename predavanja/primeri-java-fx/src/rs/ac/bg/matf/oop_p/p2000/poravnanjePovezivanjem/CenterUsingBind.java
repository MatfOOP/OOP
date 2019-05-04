package rs.ac.bg.matf.oop_p.p2000.poravnanjePovezivanjem;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class CenterUsingBind extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage)
  {
    Text text = new Text("JavaFX Reversi");
    text.setTextOrigin(VPos.TOP);
    text.setFont(Font.font(null, FontWeight.BOLD, 18));
    Scene scene = new Scene(new Group(text), 400, 100);
    text.layoutXProperty().bind(
        scene.widthProperty().subtract(text.prefWidth(-1)).divide(2));
    text.layoutYProperty().bind(
        scene.heightProperty().subtract(text.prefHeight(-1)).divide(2));
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}