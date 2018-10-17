package v20.Sketcher.v02CuvanjeSkice;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.Font;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;

import java.io.*;

import java.util.Vector;

public abstract class Element implements Serializable {
  public Element(Color color) {
    this.color = color;  
  }

  public Color getColor() {
    return color;  
  }

  // Set or reset highlight color
  public void setHighlighted(boolean highlighted) {
    this.highlighted = highlighted;
  }

  public Point getPosition() {  
    return position;  
  }

  protected void draw(Graphics2D g2D, Shape element) {
    g2D.setPaint(highlighted ? Color.MAGENTA : color);  // Set the element color
    AffineTransform old = g2D.getTransform();      // Save the current transform
    g2D.translate(position.x, position.y);         // Translate to position
    g2D.rotate(angle);                              // Rotate about position
    g2D.draw(element);                             // Draw the element
    g2D.setTransform(old);                         // Restore original transform
  }

  protected java.awt.Rectangle getBounds(java.awt.Rectangle bounds) { 
    AffineTransform at = AffineTransform.getTranslateInstance(position.x, 
                                                              position.y);
    at.rotate(angle);
    return at.createTransformedShape(bounds).getBounds();
  }

  public void move(int deltax, int deltay) {
    position.x += deltax;
    position.y += deltay;
  } 

  public void rotate(double angle) {  
    this.angle += angle;  
  }

  public abstract java.awt.Rectangle getBounds();
  public abstract void modify(Point start, Point last);
  public abstract void draw(Graphics2D g2D);
  
  protected Color color;                             // Color of a shape
  protected boolean highlighted = false;         // Highlight flag
  final static Point origin = new Point();         // Point 0,0
  protected Point position;                        // Element position
  protected double angle = 0.0;            // Rotation angle
  
  // Nested class defining a line
  public static class Line extends Element {
    public Line(Point start, Point end, Color color) {
      super(color);
      position = start;
      line = new Line2D.Double(origin, new Point(end.x - position.x, 
                                                 end.y - position.y));
    }

    public java.awt.Rectangle getBounds() {
      return getBounds(line.getBounds());    
    }

    public void modify(Point start, Point last) {
      line.x2 = last.x - position.x;
      line.y2 = last.y - position.y;
    }

    public void draw(Graphics2D g2D)  {
      draw(g2D, line);                              // Call base draw method
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
      out.writeDouble(line.x2);
      out.writeDouble(line.y2);
    }

    private void readObject(java.io.ObjectInputStream in)
                 throws IOException, ClassNotFoundException {
      double x2 = in.readDouble();
      double y2 = in.readDouble();
      line = new Line2D.Double(0,0,x2,y2);
    }

    private Line2D.Double line;
  }

  // Nested class defining a rectangle
  public static class Rectangle extends Element {
    public Rectangle(Point start, Point end, Color color) {
      super(color);
      position = new Point(Math.min(start.x, end.x),
                           Math.min(start.y, end.y));
      rectangle = new Rectangle2D.Double(origin.x,
                                         origin.y,
                                         Math.abs(start.x - end.x),     // Width
                                         Math.abs(start.y - end.y));    // & height 
    }

    public java.awt.Rectangle getBounds() { 
      return getBounds(rectangle.getBounds());  
    }

    public void modify(Point start, Point last) {
      position.x = Math.min(start.x, last.x);
      position.y = Math.min(start.y, last.y);
      rectangle.width = Math.abs(start.x - last.x);
      rectangle.height = Math.abs(start.y - last.y);
    }

    public void draw(Graphics2D g2D)  {
      draw(g2D, rectangle);                              // Call base draw method    
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
      out.writeDouble(rectangle.width);
      out.writeDouble(rectangle.height);
    }

    private void readObject(ObjectInputStream in)
                 throws IOException, ClassNotFoundException {
      double width = in.readDouble();
      double height = in.readDouble();
      rectangle = new Rectangle2D.Double(0,0,width,height);
    }

    private Rectangle2D.Double rectangle;
  }

  // Nested class defining a circle
  public static class Circle extends Element {
    public Circle(Point center, Point circum, Color color) {
      super(color);
  
      // Radius is distance from center to circumference
      double radius = center.distance(circum);
      position = new Point(center.x - (int)radius,
                           center.y - (int)radius);
      
      circle = new Ellipse2D.Double(origin.x, origin.y,     // Position - top-left
                                    2.*radius, 2.*radius ); // Width & height

    }

    public java.awt.Rectangle getBounds() { 
      return getBounds(circle.getBounds());  
    }

    public void modify(Point center, Point circum) {
      double radius = center.distance(circum);
      position.x = center.x - (int)radius;
      position.y = center.y - (int)radius;
      circle.width = circle.height = 2*radius;
    }

    public void draw(Graphics2D g2D)  {
      draw(g2D, circle);                              // Call base draw method    
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
      out.writeDouble(circle.width);
    }

    private void readObject(ObjectInputStream in)
                 throws IOException, ClassNotFoundException {
      double width = in.readDouble();
      circle = new Ellipse2D.Double(0,0,width,width);
    }

    private Ellipse2D.Double circle;
  }

  // Nested class defining a curve
  public static class Curve extends Element {
    public Curve(Point start, Point next, Color color) {
      super(color);
      curve = new GeneralPath();
      position = start;
      curve.moveTo(origin.x, origin.y);
      curve.lineTo(next.x - position.x,
                   next.y - position.y);

    }

    // Add another segment
    public void modify(Point start, Point next) {
      curve.lineTo(next.x - start.x,
                   next.y - start.y);
    }

    public java.awt.Rectangle getBounds() { 
      return getBounds(curve.getBounds());  
    }

    public void draw(Graphics2D g2D)  {
      draw(g2D, curve);                              // Call base draw method
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
      PathIterator iterator = curve.getPathIterator(new AffineTransform());
      Vector coords = new Vector();
      int maxCoordCount = 6;
      float[] temp = new float[maxCoordCount];  // Stores segment data

      int result = iterator.currentSegment(temp);  // Get first segment
      //assert(result == iterator.SEG_MOVETO);
      iterator.next();                         // Next segment
      while(!iterator.isDone()) {              // While we have segments
        result = iterator.currentSegment(temp);      // Get the segment data
       //assert(result == iterator.SEG_LINETO);

      coords.add(new Float(temp[0]));        // Add x coordinate to Vector
      coords.add(new Float(temp[1]));          // Add y coordinate
      iterator.next();                         // Go to next segment
    }

  out.writeObject(coords);                      // Save the Vector
}


    private void readObject(ObjectInputStream in)
                 throws IOException, ClassNotFoundException {
      Vector coords = (Vector)in.readObject();    // Read the coordinates Vector
      curve = new GeneralPath();                  // Create a path
      curve.moveTo(0,0);                          // Move to the origin
      float x, y;                                 // Stores coordinates

      for(int i = 0 ; i<coords.size() ; i += 2 ) { // For each pair of elements
        x = ((Float)coords.get(i)).floatValue();   // Get x value
        y = ((Float)coords.get(i+1)).floatValue(); // Get y value
        curve.lineTo(x,y);                         // Create a line segment
      }
    }

    private GeneralPath curve;
  }


  // Class defining text element
  public static class Text extends Element  {
    public Text(Font font, String text, Point position, Color color,
                                        java.awt.Rectangle bounds) {
      super(color);
      this.font = font;
      this.position = position;
      this.position.y -= (int)bounds.getHeight();
      this.text = text;
      this.bounds = new java.awt.Rectangle(origin.x, origin.y,
                                            bounds.width, bounds.height);
    }

    public java.awt.Rectangle getBounds() {
      return getBounds(bounds);
    }

    public void draw(Graphics2D g2D)  {
      g2D.setPaint(highlighted ? Color.magenta : color);       // Set the line color
      Font oldFont = g2D.getFont();                // Save the old font
      g2D.setFont(font);                          // Set the new font

      AffineTransform old = g2D.getTransform();      // Save the current transform
      g2D.translate(position.x, position.y);         // Translate to position
      g2D.rotate(angle);                              // Rotate about position
      g2D.drawString(text, origin.x, origin.y+(int)bounds.getHeight());
      g2D.setTransform(old);                         // Restore original transform

      g2D.setFont(oldFont);                        // Restore the old font
    }

    public void modify(Point start, Point last) {
      // No code is required here, but we must supply a definition
    }

    private Font font;                             // The font to be used
    private String text;                           // Text to be displayed
    java.awt.Rectangle bounds;                      // The bounding rectangle
  }
}
