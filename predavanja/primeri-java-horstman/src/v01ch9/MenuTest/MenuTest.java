package v01ch9.MenuTest;
/**
   @version 1.22 2004-05-05
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MenuTest
{
   public static void main(String[] args)
   {  
      MenuFrame frame = new MenuFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame with a sample menu bar.
*/
class MenuFrame extends JFrame
{  
   public MenuFrame()
   {  
      setTitle("MenuTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      JMenu fileMenu = new JMenu("File");
      JMenuItem newItem = fileMenu.add(new TestAction("New"));

      // demonstrate accelerators

      JMenuItem openItem = fileMenu.add(new TestAction("Open"));
      openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));

      fileMenu.addSeparator();
      
      saveAction = new TestAction("Save");
      JMenuItem saveItem = fileMenu.add(saveAction);
      saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

      saveAsAction = new TestAction("Save As");
      JMenuItem saveAsItem = fileMenu.add(saveAsAction);
      fileMenu.addSeparator();

      fileMenu.add(new 
         AbstractAction("Exit")
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });

      // demonstrate check box and radio button menus

      readonlyItem = new JCheckBoxMenuItem("Read-only");
      readonlyItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               boolean saveOk = !readonlyItem.isSelected();
               saveAction.setEnabled(saveOk);
               saveAsAction.setEnabled(saveOk);               
            }
         });

      ButtonGroup group = new ButtonGroup();

      JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
      insertItem.setSelected(true);
      JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Overtype");

      group.add(insertItem);
      group.add(overtypeItem);

      // demonstrate icons

      Action cutAction = new TestAction("Cut"); 
      cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
      Action copyAction = new TestAction("Copy");
      copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
      Action pasteAction = new TestAction("Paste");
      pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));

      JMenu editMenu = new JMenu("Edit");
      editMenu.add(cutAction);
      editMenu.add(copyAction);
      editMenu.add(pasteAction);

      // demonstrate nested menus

      JMenu optionMenu = new JMenu("Options");

      optionMenu.add(readonlyItem);
      optionMenu.addSeparator();
      optionMenu.add(insertItem);
      optionMenu.add(overtypeItem);

      editMenu.addSeparator();
      editMenu.add(optionMenu);

      // demonstrate mnemonics

      JMenu helpMenu = new JMenu("Help");
      helpMenu.setMnemonic('H');

      JMenuItem indexItem = new JMenuItem("Index");
      indexItem.setMnemonic('I');
      helpMenu.add(indexItem);

      // you can also add the mnemonic key to an action
      Action aboutAction = new TestAction("About");
      aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
      helpMenu.add(aboutAction);

      // add all top-level menus to menu bar

      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);

      menuBar.add(fileMenu);
      menuBar.add(editMenu);
      menuBar.add(helpMenu);

      // demonstrate pop-ups

      popup = new JPopupMenu();
      popup.add(cutAction);
      popup.add(copyAction);
      popup.add(pasteAction);
      
      JPanel panel = new JPanel();
      panel.setComponentPopupMenu(popup);
      add(panel);

      // the following line is a workaround for bug 4966109
      panel.addMouseListener(new MouseAdapter() {}); 
   }

   public static final int DEFAULT_WIDTH = 300;
   public static final int DEFAULT_HEIGHT = 200;  

   private Action saveAction;
   private Action saveAsAction;
   private JCheckBoxMenuItem readonlyItem;
   private JPopupMenu popup;
}

/**
   A sample action that prints the action name to System.out
*/
class TestAction extends AbstractAction
{  
   public TestAction(String name) { super(name); }
   
   public void actionPerformed(ActionEvent event)
   {
      System.out.println(getValue(Action.NAME) + " selected.");
   }
}








