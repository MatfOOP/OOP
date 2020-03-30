package rs.math.oop1.z200201.iscrtavanje.z02.krug;

import javafx.application.Application;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Krug extends Application {
   @Override
   public void start(Stage etapa) {
      Scene scena = SceneBuilder.create()
            .width(100)
            .height(100)
            .root(
                  GroupBuilder.create()
                        .children(new Circle(50.0f, 50.0f, 50.0f, Color.RED))
                        .build()
            )
            .build();
      etapa.setScene(scena);
      etapa.show();
   }

   public static void main(String a[]) {
      Application.launch(a);
   }
}
