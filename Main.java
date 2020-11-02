import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables
  JPanel mainPanel;

  JLabel firstLabel;
  JLabel secondLabel;
  JLabel thirdLabel;

  JTextField firstInput;
  JTextField secondInput;
  JTextField result;

  JButton addButton;
  JButton subButton;
  JButton multiButton;
  JButton divButton;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    // initialize the main JPanel
    mainPanel = new JPanel();
    // turns the manual layouts on
    mainPanel.setLayout(null);

    // creates labels
    firstLabel = new JLabel("First Number");
    secondLabel = new JLabel("Second Number");
    thirdLabel = new JLabel("Result");

    // using set bound it will locate the labels
    firstLabel.setBounds(150,100,150,20);
    secondLabel.setBounds(150,140,150,20);
    thirdLabel.setBounds(150,180,150,20);

    // creates text fields
    firstInput = new JTextField();
    secondInput = new JTextField();
    result = new JTextField();

    // using set bound it will locate the input boxes
    firstInput.setBounds(350,100,150,20);
    secondInput.setBounds(350,140,150,20);
    result.setBounds(350,180,150,20);

    // Makes it so that user could not type inside the result text fleid
    result.setEnabled(false);

    // declares 4 different types of buttons
    addButton = new JButton("add");
    subButton = new JButton("sub");
    multiButton = new JButton("multi");
    divButton = new JButton("div");

    // using the set bound it will locate it
    addButton.setBounds(150,350,100,20);
    subButton.setBounds(250,350,100,20);
    multiButton.setBounds(350,350,100,20);
    divButton.setBounds(450,350,100,20);

    // add an action listener to the buttons
    addButton.addActionListener(this);
    subButton.addActionListener(this);
    multiButton.addActionListener(this);
    divButton.addActionListener(this);

    // set the action command on the buttons so that we know which button was pressed
    addButton.setActionCommand("add");
    subButton.setActionCommand("sub");
    multiButton.setActionCommand("multi");
    divButton.setActionCommand("div");

    // adds the labels to the panel
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);
    mainPanel.add(thirdLabel);

    // adds the text fields to the panel
    mainPanel.add(firstInput);
    mainPanel.add(secondInput);
    mainPanel.add(result);

    // adds the buttons to the panel
    mainPanel.add(addButton);
    mainPanel.add(subButton);
    mainPanel.add(multiButton);
    mainPanel.add(divButton);

    // adds the panel to the window
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // gets the user inputs
    String firstText = firstInput.getText();
    String secondText = secondInput.getText();

    // declares variables
    double num;
    // change the string variables into double variables
    double num1 = Double.parseDouble(firstText);
    double num2 = Double.parseDouble(secondText);

    // if clicked add button it will add
    if(command.equals("add")){
      num = num1 + num2;
      result.setText("" + num);
    // if clicked sub button it will subtract
    }else if(command.equals("sub")){
      num = num1 - num2;
      result.setText("" + num);
    // if clicked multi button it will multiply
    }else if(command.equals("multi")){
      num = num1 * num2;
      result.setText("" + num);
    // if clicked div button it will divide
    }else if(command.equals("div")){
      num = num1 / num2;
      result.setText("" + num);
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}