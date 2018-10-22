package v02ch10.Retire;
/**
   @version 1.21 2001-08-27
   @author Cay Horstmann
*/

import java.util.*;
import java.awt.*;

/**
   These are the German non-string resources for the retirement
   calculator.
*/
public class RetireResources_de
   extends java.util.ListResourceBundle
{  
   public Object[][] getContents() { return contents; }
   static final Object[][] contents =
   {  
      // BEGIN LOCALIZE
      { "colorPre", Color.yellow },
      { "colorGain", Color.black },
      { "colorLoss", Color.red }
      // END LOCALIZE
   };
}
