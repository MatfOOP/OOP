package v02ch6.SimpleTree;
/**
   @version 1.01 2001-07-17
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

/**
   This program shows a simple tree.
*/
public class SimpleTree
{  
   public static void main(String[] args)
   {  
      JFrame frame = new SimpleTreeFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   This frame contains a simple tree that displays a 
   manually constructed tree model.
*/
class SimpleTreeFrame extends JFrame
{  
   public SimpleTreeFrame()
   {  
      setTitle("SimpleTree");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // set up tree model data

      DefaultMutableTreeNode root
         = new DefaultMutableTreeNode("World");
      DefaultMutableTreeNode country
         = new DefaultMutableTreeNode("USA");
      root.add(country);
      DefaultMutableTreeNode state
         = new DefaultMutableTreeNode("California");
      country.add(state);
      DefaultMutableTreeNode city
         = new DefaultMutableTreeNode("San Jose");
      state.add(city);
      city = new DefaultMutableTreeNode("Cupertino");
      state.add(city);
      state = new DefaultMutableTreeNode("Michigan");
      country.add(state);
      city = new DefaultMutableTreeNode("Ann Arbor");
      state.add(city);
      country = new DefaultMutableTreeNode("Germany");
      root.add(country);
      state = new DefaultMutableTreeNode("Schleswig-Holstein");
      country.add(state);
      city = new DefaultMutableTreeNode("Kiel");
      state.add(city);

      // construct tree and put it in a scroll pane

      JTree tree = new JTree(root);
      Container contentPane = getContentPane();
      contentPane.add(new JScrollPane(tree));
   }

   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;
}
