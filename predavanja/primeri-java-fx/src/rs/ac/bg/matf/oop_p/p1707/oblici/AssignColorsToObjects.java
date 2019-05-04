package rs.ac.bg.matf.oop_p.p1707.oblici;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class AssignColorsToObjects extends Application
{
	/**
	 * @param args
	 *          the command line arguments
	 */
	public static void main( String[] args )
	{
		Application.launch( args );
	}
	
	@Override
	public void start( Stage primarnaScena )
	{
		primarnaScena.setTitle( "Bojenje objekata" );
		Group koren = new Group();
		Scene scena = new Scene( koren, 350, 300, Color.WHITE );
		Ellipse elipsa = new Ellipse( 100, 50 + 70 / 2, 50, 70 / 2 );
		RadialGradient gradijent1 = RadialGradientBuilder.create()
				.focusAngle( 0 )
				.focusDistance( .1 )
				.centerX( 80 )
				.centerY( 45 )
				.radius( 120 )
				.proportional( false )
				.cycleMethod( CycleMethod.NO_CYCLE )
				.stops( new Stop( 0, Color.RED ), new Stop( 1, Color.BLACK ) )
				.build();
		elipsa.setFill( gradijent1 );
		koren.getChildren().add( elipsa );
		Line crnaLinija = LineBuilder.create()
				.startX( 170 )
				.startY( 30 )
				.endX( 20 )
				.endY( 140 )
				.fill( Color.BLACK )
				.strokeWidth( 10.0f )
				.translateY( elipsa.prefHeight( -1 ) + elipsa.getLayoutY() + 10 )
				.build();
		koren.getChildren().add( crnaLinija );
		Rectangle pravougaonik = RectangleBuilder.create()
				.x( 50 )
				.y( 50 )
				.width( 100 )
				.height( 70 )
				.translateY( elipsa.prefHeight( -1 ) + elipsa.getLayoutY() + 10 )
				.build();
		LinearGradient linearniGradijent = LinearGradientBuilder.create()
				.startX( 50 )
				.startY( 50 )
				.endX( 50 )
				.endY( 50 + pravougaonik.prefHeight( -1 ) + 25 )
				.proportional( false )
				.cycleMethod( CycleMethod.NO_CYCLE )
				.stops( new Stop( 0.1f, Color.rgb( 255, 200, 0, .784 ) ),
						new Stop( 1.0f, Color.rgb( 0, 0, 0, .784 ) ) )
				.build();
		pravougaonik.setFill( linearniGradijent );
		koren.getChildren().add( pravougaonik );
		Rectangle zaobljeniPravougaonik = RectangleBuilder
				.create()
				.x( 50 )
				.y( 50 )
				.width( 100 )
				.height( 70 )
				.arcWidth( 20 )
				.arcHeight( 20 )
				.translateY( elipsa.prefHeight( -1 ) + elipsa.getLayoutY() + 10
						+ pravougaonik.prefHeight( -1 ) + pravougaonik.getLayoutY() + 10 )
				.build();
		LinearGradient ciklicniGradijent = LinearGradientBuilder
				.create()
				.startX( 50 )
				.startY( 50 )
				.endX( 70 )
				.endY( 70 )
				.proportional( false )
				.cycleMethod( CycleMethod.REFLECT )
				.stops( new Stop( 0f, Color.rgb( 0, 255, 0, .784 ) ),
						new Stop( 1.0f, Color.rgb( 0, 0, 0, .784 ) ) ).build();
		zaobljeniPravougaonik.setFill( ciklicniGradijent );
		koren.getChildren().add( zaobljeniPravougaonik );
		primarnaScena.setScene( scena );
		primarnaScena.show();
	}
}
