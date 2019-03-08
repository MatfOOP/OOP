// Sketching application
package v17.v0202SketcherLowLevelEventListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class Sketcher implements WindowListener {
  public static void main(String[] args) {
    theApp = new Sketcher();              // Create the application object
    theApp.init();                        // ...and initialize it
  }

  public void init() {
    window = new SketchFrame("Sketcher");        // Create the app window
    Toolkit theKit = window.getToolkit();        // Get the window toolkit
    Dimension wndSize = theKit.getScreenSize();  // Get screen size

    // Set the position to screen center & size to half screen size
    window.setBounds(wndSize.width/4, wndSize.height/4,        // Position
                     wndSize.width/2, wndSize.height/2);       // Size

    window.addWindowListener(this);              // theApp as window listener
    window.setVisible(true);
  }
  
  // Handler for window closing event
  public void windowClosing(WindowEvent e) {
    window.dispose();                           // Release the window resources
    System.exit(0);                             // End the application
  }

  // Listener interface functions we must implement - but don't need
  public void windowOpened(WindowEvent e) {}
  public void windowClosed(WindowEvent e) {}
  public void windowIconified(WindowEvent e) {}
  public void windowDeiconified(WindowEvent e) {}
  public void windowActivated(WindowEvent e) {}
  public void windowDeactivated(WindowEvent e) {}

  private static SketchFrame window;              // The application window
  private static Sketcher theApp;                 // The application object
}
