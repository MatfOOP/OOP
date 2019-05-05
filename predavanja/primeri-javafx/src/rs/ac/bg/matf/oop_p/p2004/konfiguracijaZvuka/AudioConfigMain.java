package rs.ac.bg.matf.oop_p.p2004.konfiguracijaZvuka;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxBuilder;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceBoxBuilder;
import javafx.scene.control.Slider;
import javafx.scene.control.SliderBuilder;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradientBuilder;
import javafx.scene.paint.Stop;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

public class AudioConfigMain extends Application {
	// A reference to the model
	AudioConfigModel acModel = new AudioConfigModel();
	Text textDb;
	Slider slider;
	CheckBox mutingCheckBox;
	ChoiceBox genreChoiceBox;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = SceneBuilder
				.create()
				.width(320)
				.height(343)
				.root(GroupBuilder
						.create()
						.children(
								RectangleBuilder
										.create()
										.width(320)
										.height(45)
										.fill(LinearGradientBuilder
												.create()
												.endX(0.0)
												.endY(1.0)
												.stops(new Stop(0, Color
														.web("0xAEBBCC")),
														new Stop(
																1,
																Color.web("0x6D84A3")))
												.build()).build(),
								TextBuilder
										.create()
										.layoutX(65)
										.layoutY(12)
										.textOrigin(VPos.TOP)
										.fill(Color.WHITE)
										.text("Audio Configuration")
										.font(Font.font("SansSerif",
												FontWeight.BOLD, 20)).build(),
								RectangleBuilder.create().x(0).y(43).width(320)
										.height(300)
										.fill(Color.rgb(199, 206, 213)).build(),
								RectangleBuilder.create().x(9).y(54).width(300)
										.height(130).arcWidth(20).arcHeight(20)
										.fill(Color.WHITE)
										.stroke(Color.color(0.66, 0.67, 0.69))
										.build(),
								textDb = TextBuilder
										.create()
										.layoutX(18)
										.layoutY(69)
										.textOrigin(VPos.TOP)
										.fill(Color.web("#131021"))
										.font(Font.font("SansSerif",
												FontWeight.BOLD, 18)).build(),
								slider = SliderBuilder.create().layoutX(135)
										.layoutY(69).prefWidth(162)
										.min(acModel.minDecibels)
										.max(acModel.maxDecibels).build(),
								LineBuilder.create().startX(9).startY(97)
										.endX(309).endY(97)
										.stroke(Color.color(0.66, 0.67, 0.69))
										.build(),
								TextBuilder
										.create()
										.layoutX(18)
										.layoutY(113)
										.textOrigin(VPos.TOP)
										.fill(Color.web("#131021"))
										.text("Muting")
										.font(Font.font("SanSerif",
												FontWeight.BOLD, 18)).build(),
								mutingCheckBox = CheckBoxBuilder.create()
										.layoutX(280).layoutY(113).build(),
								LineBuilder.create().startX(9).startY(141)
										.endX(309).endY(141)
										.stroke(Color.color(0.66, 0.67, 0.69))
										.build(),
								TextBuilder
										.create()
										.layoutX(18)
										.layoutY(154)
										.textOrigin(VPos.TOP)
										.fill(Color.web("#131021"))
										.text("Genre")
										.font(Font.font("SanSerif",
												FontWeight.BOLD, 18)).build(),
								genreChoiceBox = ChoiceBoxBuilder.create()
										.layoutX(204).layoutY(154)
										.prefWidth(93).items(acModel.genres)
										.build()).build()).build();
		textDb.textProperty()
				.bind(acModel.selectedDBs.asString().concat(" dB"));
		slider.valueProperty().bindBidirectional(acModel.selectedDBs);
		slider.disableProperty().bind(acModel.muting);
		mutingCheckBox.selectedProperty().bindBidirectional(acModel.muting);
		acModel.genreSelectionModel = genreChoiceBox.getSelectionModel();
		acModel.addListenerToGenreSelectionModel();
		acModel.genreSelectionModel.selectFirst();
		stage.setScene(scene);
		stage.setTitle("Audio Configuration");
		stage.show();
	}
}