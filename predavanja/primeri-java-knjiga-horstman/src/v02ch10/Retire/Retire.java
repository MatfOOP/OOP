package v02ch10.Retire;
/**
   @version 1.21 2004-09-15
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.applet.*;
import java.util.*;
import java.text.*;
import java.io.*;
import javax.swing.*;

/**
   This applet shows a retirement calculator. The UI is displayed
   in English, German, and Chinese.
*/
public class Retire extends JApplet
{
   public void init()
   {
      setLayout(new GridBagLayout());
      add(languageLabel, new G0BC(0, 0).setAnchor(G0BC.EAST));
      add(savingsLabel, new G0BC(0, 1).setAnchor(G0BC.EAST));
      add(contribLabel, new G0BC(2, 1).setAnchor(G0BC.EAST));
      add(incomeLabel, new G0BC(4, 1).setAnchor(G0BC.EAST));
      add(currentAgeLabel, new G0BC(0, 2).setAnchor(G0BC.EAST));
      add(retireAgeLabel, new G0BC(2, 2).setAnchor(G0BC.EAST));
      add(deathAgeLabel, new G0BC(4, 2).setAnchor(G0BC.EAST));
      add(inflationPercentLabel, new G0BC(0, 3).setAnchor(G0BC.EAST));
      add(investPercentLabel, new G0BC(2, 3).setAnchor(G0BC.EAST));
      add(localeCombo, new G0BC(1, 0));
      add(savingsField, new G0BC(1, 1).setWeight(100, 0).setFill(G0BC.HORIZONTAL));
      add(contribField, new G0BC(3, 1).setWeight(100, 0).setFill(G0BC.HORIZONTAL));
      add(incomeField, new G0BC(5, 1).setWeight(100, 0).setFill(G0BC.HORIZONTAL));
      add(currentAgeField, new G0BC(1, 2).setWeight(100, 0).setFill(G0BC.HORIZONTAL));
      add(retireAgeField, new G0BC(3, 2).setWeight(100, 0).setFill(G0BC.HORIZONTAL));
      add(deathAgeField, new G0BC(5, 2).setWeight(100, 0).setFill(G0BC.HORIZONTAL));
      add(inflationPercentField, new G0BC(1, 3).setWeight(100, 0).setFill(G0BC.HORIZONTAL));
      add(investPercentField, new G0BC(3, 3).setWeight(100, 0).setFill(G0BC.HORIZONTAL));
      add(retireCanvas, new G0BC(0, 4, 4, 1).setWeight(0, 100).setFill(G0BC.BOTH));
      add(new JScrollPane(retireText), new G0BC(4, 4, 2, 1).setWeight(0, 100).setFill(G0BC.BOTH));

      computeButton.setName("computeButton");
      computeButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               getInfo();
               updateData();
               updateGraph();
            }
         });
      add(computeButton, new G0BC(5, 3));

      retireText.setEditable(false);
      retireText.setFont(new Font("Monospaced", Font.PLAIN, 10));

      info.setSavings(0);
      info.setContrib(9000);
      info.setIncome(60000);
      info.setCurrentAge(35);
      info.setRetireAge(65);
      info.setDeathAge(85);
      info.setInvestPercent(0.1);
      info.setInflationPercent(0.05);

      int localeIndex = 0; // US locale is default selection
      for (int i = 0; i < locales.length; i++) // if current locale one of the choices, select it
         if (getLocale().equals(locales[i])) localeIndex = i;
      setCurrentLocale(locales[localeIndex]);

      localeCombo.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               setCurrentLocale((Locale) localeCombo.getSelectedItem());
            }
         });
   }

   /**
      Sets the current locale.
      @param locale the desired locale
   */
   public void setCurrentLocale(Locale locale)
   {
      currentLocale = locale;
      localeCombo.setSelectedItem(currentLocale);
      localeCombo.setLocale(currentLocale);

      res = ResourceBundle.getBundle("RetireResources", currentLocale);
      resStrings = ResourceBundle.getBundle("RetireStrings", currentLocale);
      currencyFmt = NumberFormat.getCurrencyInstance(currentLocale);
      numberFmt = NumberFormat.getNumberInstance(currentLocale);
      percentFmt = NumberFormat.getPercentInstance(currentLocale);

      updateDisplay();
      updateInfo();
      updateData();
      updateGraph();
   }

   /**
      Updates all labels in the display.
   */
   public void updateDisplay()
   {
      languageLabel.setText(resStrings.getString("language"));
      savingsLabel.setText(resStrings.getString("savings"));
      contribLabel.setText(resStrings.getString("contrib"));
      incomeLabel.setText(resStrings.getString("income"));
      currentAgeLabel.setText(resStrings.getString("currentAge"));
      retireAgeLabel.setText(resStrings.getString("retireAge"));
      deathAgeLabel.setText(resStrings.getString("deathAge"));
      inflationPercentLabel.setText(resStrings.getString("inflationPercent"));
      investPercentLabel.setText(resStrings.getString("investPercent"));
      computeButton.setText(resStrings.getString("computeButton"));
      validate();
   }

   /**
      Updates the information in the text fields.
   */
   public void updateInfo()
   {
      savingsField.setText(currencyFmt.format(info.getSavings()));
      contribField.setText(currencyFmt.format(info.getContrib()));
      incomeField.setText(currencyFmt.format(info.getIncome()));
      currentAgeField.setText(numberFmt.format(info.getCurrentAge()));
      retireAgeField.setText(numberFmt.format(info.getRetireAge()));
      deathAgeField.setText(numberFmt.format(info.getDeathAge()));
      investPercentField.setText(percentFmt.format(info.getInvestPercent()));
      inflationPercentField.setText(percentFmt.format(info.getInflationPercent()));
   }

   /**
      Updates the data displayed in the text area.
   */
   public void updateData()
   {
      retireText.setText("");
      MessageFormat retireMsg = new MessageFormat("");
      retireMsg.setLocale(currentLocale);
      retireMsg.applyPattern(resStrings.getString("retire"));

      for (int i = info.getCurrentAge(); i <= info.getDeathAge(); i++)
      {
         Object[] args = { i, info.getBalance(i) }; 
         retireText.append(retireMsg.format(args) + "\n");
      }
   }

   /**
      Updates the graph.
   */
   public void updateGraph()
   {
      retireCanvas.setColorPre((Color) res.getObject("colorPre"));
      retireCanvas.setColorGain((Color) res.getObject("colorGain"));
      retireCanvas.setColorLoss((Color) res.getObject("colorLoss"));
      retireCanvas.setInfo(info);
      repaint();
   }

   /**
      Reads the user input from the text fields.
   */
   public void getInfo()
   {
      try
      {
         info.setSavings(currencyFmt.parse(savingsField.getText()).doubleValue());
         info.setContrib(currencyFmt.parse(contribField.getText()).doubleValue());
         info.setIncome(currencyFmt.parse(incomeField.getText()).doubleValue());
         info.setCurrentAge(numberFmt.parse(currentAgeField.getText()).intValue());
         info.setRetireAge(numberFmt.parse(retireAgeField.getText()).intValue());
         info.setDeathAge(numberFmt.parse(deathAgeField.getText()).intValue());
         info.setInvestPercent(percentFmt.parse(investPercentField.getText()).doubleValue());
         info.setInflationPercent(percentFmt.parse(inflationPercentField.getText()).doubleValue());
      }
      catch (ParseException e) 
      {         
      }
   }

   private JTextField savingsField = new JTextField(10);
   private JTextField contribField = new JTextField(10);
   private JTextField incomeField = new JTextField(10);
   private JTextField currentAgeField = new JTextField(4);
   private JTextField retireAgeField = new JTextField(4);
   private JTextField deathAgeField = new JTextField(4);
   private JTextField inflationPercentField = new JTextField(6);
   private JTextField investPercentField = new JTextField(6);
   private JTextArea retireText = new JTextArea(10, 25);
   private RetireCanvas retireCanvas = new RetireCanvas();
   private JButton computeButton = new JButton();
   private JLabel languageLabel = new JLabel();
   private JLabel savingsLabel = new JLabel();
   private JLabel contribLabel = new JLabel();
   private JLabel incomeLabel = new JLabel();
   private JLabel currentAgeLabel = new JLabel();
   private JLabel retireAgeLabel = new JLabel();
   private JLabel deathAgeLabel = new JLabel();
   private JLabel inflationPercentLabel = new JLabel();
   private JLabel investPercentLabel = new JLabel();

   private RetireInfo info = new RetireInfo();

   private Locale[] locales = { Locale.US, Locale.CHINA, Locale.GERMANY };
   private Locale currentLocale;
   private JComboBox localeCombo = new LocaleCombo(locales);
   private ResourceBundle res;
   private ResourceBundle resStrings;
   private NumberFormat currencyFmt;
   private NumberFormat numberFmt;
   private NumberFormat percentFmt;
}

/**
   The information required to compute retirement income data.
*/
class RetireInfo
{
   /**
      Gets the available balance for a given year.
      @param year the year for which to compute the balance
      @return the amount of money available (or required) in
      that year
   */
   public double getBalance(int year)
   {
      if (year < currentAge) return 0;
      else if (year == currentAge)
      {
         age = year;
         balance = savings;
         return balance;
      }
      else if (year == age) return balance;
      if (year != age + 1) getBalance(year - 1);
      age = year;
      if (age < retireAge) balance += contrib;
      else balance -= income;
      balance = balance * (1 + (investPercent - inflationPercent));
      return balance;
   }

   /**
      Gets the amount of prior savings.
      @return the savings amount
   */
   public double getSavings() { return savings; }

   /**
      Sets the amount of prior savings.
      @param newValue the savings amount
   */
   public void setSavings(double newValue) { savings = newValue; }

   /**
      Gets the annual contribution to the retirement account.
      @return the contribution amount
   */
   public double getContrib() { return contrib; }

   /**
      Sets the annual contribution to the retirement account.
      @param newValue the contribution amount
   */
   public void setContrib(double newValue) { contrib = newValue; }

   /**
      Gets the annual income.
      @return the income amount
   */
   public double getIncome() { return income; }

   /**
      Sets the annual income.
      @param newValue the income amount
   */
   public void setIncome(double newValue) { income = newValue; }

   /**
      Gets the current age.
      @return the age
   */
   public int getCurrentAge() { return currentAge; }

   /**
      Sets the current age.
      @param newValue the age
   */
   public void setCurrentAge(int newValue) { currentAge = newValue; }

   /**
      Gets the desired retirement age.
      @return the age
   */
   public int getRetireAge() { return retireAge; }

   /**
      Sets the desired retirement age.
      @param newValue the age
   */
   public void setRetireAge(int newValue) { retireAge = newValue; }

   /**
      Gets the expected age of death.
      @return the age
   */
   public int getDeathAge() { return deathAge; }

   /**
      Sets the expected age of death.
      @param newValue the age
   */
   public void setDeathAge(int newValue) { deathAge = newValue; }

   /**
      Gets the estimated percentage of inflation.
      @return the percentage
   */
   public double getInflationPercent() { return inflationPercent; }

   /**
      Sets the estimated percentage of inflation.
      @param newValue the percentage
   */
   public void setInflationPercent(double newValue) { inflationPercent = newValue; }

   /**
      Gets the estimated yield of the investment.
      @return the percentage
   */
   public double getInvestPercent() { return investPercent; }

   /**
      Sets the estimated yield of the investment.
      @param newValue the percentage
   */
   public void setInvestPercent(double newValue) { investPercent = newValue; }

   private double savings;
   private double contrib;
   private double income;
   private int currentAge;
   private int retireAge;
   private int deathAge;
   private double inflationPercent;
   private double investPercent;

   private int age;
   private double balance;
}

/**
   This panel draws a graph of the investment result.
*/
class RetireCanvas extends JPanel
{
   public RetireCanvas()
   {
      setSize(PANEL_WIDTH, PANEL_HEIGHT);
   }

   /**
      Sets the retirement information to be plotted.
      @param newInfo the new retirement info.
   */
   public void setInfo(RetireInfo newInfo)
   {
      info = newInfo;
      repaint();
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      if (info == null) return;

      double minValue = 0;
      double maxValue = 0;
      int i;
      for (i = info.getCurrentAge(); i <= info.getDeathAge(); i++)
      {
         double v = info.getBalance(i);
         if (minValue > v) minValue = v;
         if (maxValue < v) maxValue = v;
      }
      if (maxValue == minValue) return;

      int barWidth = getWidth() / (info.getDeathAge() - info.getCurrentAge() + 1);
      double scale = getHeight() / (maxValue - minValue);

      for (i = info.getCurrentAge(); i <= info.getDeathAge(); i++)
      {
         int x1 = (i - info.getCurrentAge()) * barWidth + 1;
         int y1;
         double v = info.getBalance(i);
         int height;
         int yOrigin = (int) (maxValue * scale);

         if (v >= 0)
         {
            y1 = (int) ((maxValue - v) * scale);
            height = yOrigin - y1;
         }
         else
         {
            y1 = yOrigin;
            height = (int) (-v * scale);
         }

         if (i < info.getRetireAge()) g2.setPaint(colorPre);
         else if (v >= 0) g2.setPaint(colorGain);
         else g2.setPaint(colorLoss);
         Rectangle2D bar = new Rectangle2D.Double(x1, y1, barWidth - 2, height);
         g2.fill(bar);
         g2.setPaint(Color.black);
         g2.draw(bar);
      }
   }

   /**
      Sets the color to be used before retirement.
      @param color the desired color
   */
   public void setColorPre(Color color)
   {
      colorPre = color;
      repaint();
   }

   /**
      Sets the color to be used after retirement while
      the account balance is positive.
      @param color the desired color
   */
   public void setColorGain(Color color)
   {
      colorGain = color;
      repaint();
   }

   /**
      Sets the color to be used after retirement when
      the account balance is negative.
      @param color the desired color
   */
   public void setColorLoss(Color color)
   {
      colorLoss = color;
      repaint();
   }

   private RetireInfo info = null;
   private Color colorPre;
   private Color colorGain;
   private Color colorLoss;
   private static final int PANEL_WIDTH = 400;
   private static final int PANEL_HEIGHT = 200;
}
