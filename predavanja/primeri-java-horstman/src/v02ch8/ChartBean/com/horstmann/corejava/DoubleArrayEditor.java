/**
   @version 1.20 2001-08-21
   @author Cay Horstmann
*/

package v02ch8.ChartBean.com.horstmann.corejava;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.beans.*;

/**
   A custom editor for an array of floating point numbers.
*/
public class DoubleArrayEditor extends PropertyEditorSupport
{  
   public Component getCustomEditor() { return new DoubleArrayEditorPanel(this); }
   public boolean supportsCustomEditor() { return true; }
   public boolean isPaintable() { return true; }
   public String getAsText() { return null; }

   public void paintValue(Graphics g, Rectangle box)
   {  
      Graphics2D g2 = (Graphics2D) g;
      double[] values = (double[]) getValue();
      StringBuilder s = new StringBuilder();
      for (int i = 0; i < 3; i++)
      {  
         if (values.length > i) s.append(values[i]);
         if (values.length > i + 1) s.append(", ");
      }
      if (values.length > 3) s.append("...");

      g2.setPaint(Color.white);
      g2.fill(box);
      g2.setPaint(Color.black);
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D stringBounds = g2.getFont().getStringBounds(s.toString(), context);
      double w = stringBounds.getWidth();
      double x = box.x;
      if (w < box.width) x += (box.width - w) / 2;
      double ascent = -stringBounds.getY();
      double y = box.y + (box.height - stringBounds.getHeight()) / 2 + ascent;
      g2.drawString(s.toString(), (float) x, (float) y);
   }

   public String getJavaInitializationString() 
   {
      double[] values = (double[]) getValue();
      StringBuilder s = new StringBuilder();
      s.append("new double[] {");
      for (int i = 0; i < values.length; i++) 
      {
         if (i > 0) s.append(", ");
         s.append(values[i]);
      }
      s.append("}");
      return s.toString();
   }
}
