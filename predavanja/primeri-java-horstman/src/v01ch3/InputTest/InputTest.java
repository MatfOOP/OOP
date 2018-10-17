package v01ch3.InputTest;
/**
   @version 1.10 2004-02-10
   @author Cay Horstmann
*/

import java.util.*;

public class InputTest
{  
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);

      // get first input
      System.out.print("What is your name? ");
      String name = in.nextLine();

      // get second input
      System.out.print("How old are you? ");
      int age = in.nextInt();

      // display output on console
      System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
   }
}
