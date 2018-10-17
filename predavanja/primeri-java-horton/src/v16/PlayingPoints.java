package v16;
import java.awt.Point;

public class PlayingPoints
{
  public static void main(String[] args)
  {
    Point aPoint = new Point();             // Initialize to 0,0
    Point bPoint = new Point(50,25);
    Point cPoint = new Point(bPoint);
    System.out.println("aPoint is located at: " + aPoint);
    aPoint.move(100,50);                    // Change to position 100,50

    bPoint.x = 110;
    bPoint.y = 70;

    aPoint.translate(10,20);                // Move by 10 in x and 20 in y
    System.out.println("aPoint is now at: " + aPoint);

    if(aPoint.equals(bPoint))
      System.out.println("aPoint and bPoint are at the same location.");
  }
}
