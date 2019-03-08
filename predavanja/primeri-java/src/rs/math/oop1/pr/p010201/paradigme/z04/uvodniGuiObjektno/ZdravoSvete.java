/*
Традиционални "Здраво свете" програм у графичком JavaFX окружењу.
Након клика дугмета, у конзоли се исписује порука "Здраво свете!".
 */

package rs.math.oop1.pr.p010201.paradigme.z04.uvodniGuiObjektno;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ZdravoSvete extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //kreiranje dugmeta
        Button btn = new Button();
        //postavljanje teksta na dugmetu
        btn.setText("Pritisni me");

        //registrovanje dogadjaja koji reaguje na klik dugmeta
        btn.setOnAction(new EventHandler<ActionEvent>() {

            //akcija koja treba da se izvrsi nakon klika
            @Override
            public void handle(ActionEvent event) {
                //postavljanje novog teksta na dugmetu
                btn.setText("Zdravo svete!");
                //onemogucavanje dugmeta
                btn.setDisable(true);
                //prikaz poruke na konzolu
                System.out.println("Zdravo svete!");
            }
        });

        //dodavanje dugmeta na povrsinu koja se prikazuje
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
