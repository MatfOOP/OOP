package rs.ac.bg.matf.oop_p.p1702.krug;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.*;

public class Krug extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene = SceneBuilder.create()
                .width(100)
                .height(100)
                .root(
                        GroupBuilder.create()
                                .children(new Circle(50.0f, 50.0f, 50.0f, Color.RED))
                                .build()
                )
                .build();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String a[]) {
        Application.launch(a);
    }
}
