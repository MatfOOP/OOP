package v02ch10.Retire;
/**
   @version 1.21 2001-08-27
   @author Cay Horstmann
*/

import java.util.*;
import java.awt.*;

/**
   These are the Chinese non-string resources for the retirement
   calculator.
*/
public class RetireResources_zh
   extends java.util.ListResourceBundle
{  
   public Object[][] getContents() { return contents; }
   static final Object[][] contents =
   {  
      // BEGIN LOCALIZE
      { "colorPre", Color.red },
      { "colorGain", Color.blue },
      { "colorLoss", Color.yellow }
      // END LOCALIZE
   };
}
