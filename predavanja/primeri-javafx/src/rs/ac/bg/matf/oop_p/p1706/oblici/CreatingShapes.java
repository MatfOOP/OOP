package rs.ac.bg.matf.oop_p.p1706.oblici;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * Changing Text Fonts
 * 
 * @author cdea
 */
public class CreatingShapes extends Application
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
		primarnaScena.setTitle( "Chapter 1-5 Creating Shapes" );
		Group koren = new Group();
		Scene scena = new Scene( koren, 550, 250, Color.WHITE );
		// CubicCurve
		CubicCurve kubnaKriva = CubicCurveBuilder.create()
				.startX( 50 )
				.startY( 75 )
				// start pt (x1,y1)
				.controlX1( 80 ).controlY1( -25 )
				// control pt1
				.controlX2( 110 ).controlY2( 175 )
				// control pt2
				.endX( 140 ).endY( 75 )
				// end pt (x2,y2)
				.strokeType( StrokeType.CENTERED )
				.strokeWidth( 1 )
				.stroke( Color.BLACK )
				.strokeWidth( 3 )
				.fill( Color.WHITE )
				.build();
		koren.getChildren().add( kubnaKriva );
		// Ice cream
		Path putanja = new Path();
		MoveTo pomeriPrema = new MoveTo();
		pomeriPrema.setX( 50 );
		pomeriPrema.setY( 150 );
		QuadCurveTo cetvornaKrivaPrema = new QuadCurveTo();
		cetvornaKrivaPrema.setX( 150 );
		cetvornaKrivaPrema.setY( 150 );
		cetvornaKrivaPrema.setControlX( 100 );
		cetvornaKrivaPrema.setControlY( 50 );
		LineTo linijaPrema1 = new LineTo();
		linijaPrema1.setX( 50 );
		linijaPrema1.setY( 150 );
		LineTo linijaPrema2 = new LineTo();
		linijaPrema2.setX( 100 );
		linijaPrema2.setY( 275 );
		LineTo linijaPrema3 = new LineTo();
		linijaPrema3.setX( 150 );
		linijaPrema3.setY( 150 );
		putanja.getElements().add( pomeriPrema );
		putanja.getElements().add( cetvornaKrivaPrema );
		putanja.getElements().add( linijaPrema1 );
		putanja.getElements().add( linijaPrema2 );
		putanja.getElements().add( linijaPrema3 );
		putanja.setTranslateY( 30 );
		putanja.setStrokeWidth( 3 );
		putanja.setStroke( Color.BLACK );
		koren.getChildren().add( putanja );
		// QuadCurve create a smile
		QuadCurve cetvorna = QuadCurveBuilder.create()
				.startX( 50 )
				.startY( 50 )
				.endX( 150 )
				.endY( 50 )
				.controlX( 125 )
				.controlY( 150 )
				.translateY( putanja.getBoundsInParent().getMaxY() )
				.strokeWidth( 3 )
				.stroke( Color.BLACK )
				.fill( Color.WHITE )
				.build();
		koren.getChildren().add( cetvorna );
		// outer donut
		Ellipse velikiKrug = EllipseBuilder.create()
				.centerX( 100 )
				.centerY( 100 )
				.radiusX( 50 )
				.radiusY( 75 / 2 )
				.translateY( cetvorna.getBoundsInParent().getMaxY() )
				.strokeWidth( 3 )
				.stroke( Color.BLACK )
				.fill( Color.WHITE )
				.build();
		// donut hole
		Ellipse maliKrug = EllipseBuilder.create()
				.centerX( 100 )
				.centerY( 100 )
				.radiusX( 35 / 2 )
				.radiusY( 25 / 2 )
				.build();
		// make a donut
		Shape krofna = Path.subtract( velikiKrug, maliKrug );
		// orange glaze
		krofna.setFill( Color.rgb( 255, 200, 0 ) );
		// add drop shadow
		DropShadow senka = new DropShadow();
		senka.setOffsetX( 2.0f );
		senka.setOffsetY( 2.0f );
		senka.setColor( Color.rgb( 50, 50, 50, .588 ) );
		krofna.setEffect( senka );
		// move slightly down
		krofna.setTranslateY( cetvorna.getBoundsInParent().getMinY() + 30 );
		koren.getChildren().add( krofna );
		primarnaScena.setScene( scena );
		primarnaScena.show();
	}
}