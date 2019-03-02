package v02ch13.ActionListenerFor;
/**
   @version 1.00 2004-08-17
   @author Cay Horstmann
*/

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionListenerFor
{
   String source();
}
