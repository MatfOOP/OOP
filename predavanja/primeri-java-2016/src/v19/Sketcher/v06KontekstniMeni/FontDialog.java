// Class to define a dialog to choose a font
package v19.Sketcher.v06KontekstniMeni;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.event.*;

class FontDialog extends JDialog implements Constants, ActionListener, ChangeListener, ListSelectionListener {
  public FontDialog(SketchFrame window) {
    // Call the base constructor to create a modal dialog
    super(window, "Font Selection", true);   

    font = window.getCurrentFont();                // Get the current font
    fontStyle = font.getStyle();                   // ...style
    fontSize = font.getSize();                     

    // Create the dialog button panel 
    JPanel buttonPane = new JPanel();              // Create a panel to hold buttons

    // Create and add the buttons to the buttonPane
    buttonPane.add(ok = createButton("OK"));             // Add the OK button
    buttonPane.add(cancel = createButton("Cancel"));     // Add the Cancel button
    getContentPane().add(buttonPane, BorderLayout.SOUTH);// Add pane to content pane

    // Code to create the data input panel
    JPanel dataPane = new JPanel();                   // Create the data entry panel
    dataPane.setBorder(BorderFactory.createCompoundBorder(   // Create pane border
                       BorderFactory.createLineBorder(Color.BLACK),
                       BorderFactory.createEmptyBorder(5, 5, 5, 5)));  
    GridBagLayout gbLayout = new GridBagLayout();            // Create the layout
    dataPane.setLayout(gbLayout);                            // Set the pane layout
    GridBagConstraints constraints = new GridBagConstraints();

    // Code to create the font choice and add it to the input panel
    JLabel label = new JLabel("Choose a Font");
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridwidth = GridBagConstraints.REMAINDER; 
    gbLayout.setConstraints(label, constraints);
    dataPane.add(label);

    // Code to set up font list choice component
    GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] fontNames = e.getAvailableFontFamilyNames();  // Get the font names

    fontList = new JList(fontNames);                    // Create list of font names
    fontList.setValueIsAdjusting(true);                 // single event selection
    fontList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Choose 1 font
    fontList.setSelectedValue(font.getFamily(),true);
    fontList.addListSelectionListener(this);
    JScrollPane chooseFont = new JScrollPane(fontList); // Scrollable list
    chooseFont.setMinimumSize(new Dimension(300,100));
    chooseFont.setWheelScrollingEnabled(true);          // Enable mouse wheel scroll

    // Panel to display font sample
    JPanel display = new JPanel();
    fontDisplay = new JLabel("Sample Size: x X y Y z Z");
    fontDisplay.setPreferredSize(new Dimension(300,100));
    display.add(fontDisplay);

    //Create a split pane with font choice at the top
    // and font display at the bottom
    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                                          true,
                                          chooseFont,
                                          display);
    gbLayout.setConstraints(splitPane, constraints);   // Split pane constraints
    dataPane.add(splitPane);                           // Add to the data pane

    // Set up the size choice using a spinner
    JPanel sizePane = new JPanel();                 // Pane for size choices
    label = new JLabel("Choose point size");        // Prompt for point size
    sizePane.add(label);                            // Add the prompt
 
    chooseSize = new JSpinner(new SpinnerNumberModel(fontSize,
                                  pointSizeMin, pointSizeMax, pointSizeStep));
    chooseSize.addChangeListener(this);  sizePane.add(chooseSize);

    // Add spinner to pane
    gbLayout.setConstraints(sizePane, constraints);          // Set pane constraints
    dataPane.add(sizePane);                                  // Add the pane

    // Set up style options using radio buttons
    JRadioButton bold = new JRadioButton("Bold", (fontStyle & Font.BOLD) > 0);
    JRadioButton italic = new JRadioButton("Italic", (fontStyle & Font.ITALIC) > 0);
    bold.addItemListener(new StyleListener(Font.BOLD));      // Add button listeners
    italic.addItemListener(new StyleListener(Font.ITALIC));
    JPanel stylePane = new JPanel();                         // Create style pane
    stylePane.add(bold);                                     // Add buttons
    stylePane.add(italic);                                   // to style pane...
    gbLayout.setConstraints(stylePane, constraints);         // Set pane constraints
    dataPane.add(stylePane);                                 // Add the pane

    getContentPane().add(dataPane, BorderLayout.CENTER);
    pack();
    setVisible(false);
  }

  public void stateChanged(ChangeEvent e) {
    fontSize = ((Number)(((JSpinner)e.getSource()).getValue())).intValue();  
    font = font.deriveFont((float)fontSize);
    fontDisplay.setFont(font);
    fontDisplay.repaint();    
  }

  // List selection listener method
  public void valueChanged(ListSelectionEvent e) {
    if(!e.getValueIsAdjusting()) {
      font = new Font((String)fontList.getSelectedValue(), fontStyle, fontSize);
      fontDisplay.setFont(font);
      fontDisplay.repaint();
    }
  }

  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();                  // Get the source of the event
    if(source == ok)  {                             // Is it the OK button?
      ((SketchFrame)getOwner()).setCurrentFont(font); // Set the selected font 
       setVisible(false);                             // Hide the dialog
    }
    else if(source == cancel)                     // If it is the Cancel button
      setVisible(false);                          // just hide the dialog
  }

  JButton createButton(String label) {
    JButton button = new JButton(label);                 // Create the button
    button.setPreferredSize(new Dimension(80,20));       // Set the size
    button.addActionListener(this);                      // Listener is the dialog
    return button;                                       // Return the button
  }

  private JSpinner chooseSize;                      // Font size options
  private JLabel fontDisplay;                       // Font sample

  private JList fontList;                // Font list
  
  private JButton ok;                        // OK button
  private JButton cancel;                    // Cancel button

  private Font font;                 // Currently selected font
  private int fontStyle;             // Font style - Plain,Bold,Italic
  private int fontSize;              // Font point size

  class StyleListener implements ItemListener {
    public StyleListener(int style) {  
      this.style = style;  
    }

    public void itemStateChanged(ItemEvent e) {
      if(e.getStateChange()==ItemEvent.SELECTED)   // If style was selected
        fontStyle |= style;                        // turn it on in the font style
      else
        fontStyle &= ~style;                       // otherwise turn it off
      font = font.deriveFont(fontStyle);           // Get a new font
      fontDisplay.setFont(font);                   // Change the label font
      fontDisplay.repaint();                       // repaint
    }    
     private int style;                             // Style for this listener
  }
}
