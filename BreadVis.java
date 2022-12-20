import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BreadVis {
  public static void main(String[] args) {
    // Create the UI
    BreadVis vis = new BreadVis();
    vis.createUI();
  }

  public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

  private void createUI() {
    JFrame frame = new JFrame("Bread Algorithm");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);

    //Panel
    JPanel panel = new JPanel();
    frame.add(panel);

    // Set the layout manager of the panel
    panel.setLayout(new FlowLayout());

    //Image
    //ImageIcon icon = new ImageIcon("bread.png");

    //if (icon != null) {
    //  JLabel background = new JLabel(icon);
    //  frame.setContentPane(background);
    //}

    //Add label
    String promptBread = BreadAlgorithm.getString(); //Get the string from the other class
    String breadPrompt = "It's bread time.";
    JLabel label = new JLabel(breadPrompt);

    //JTextField textField = new JTextField();

    // Add the text field to the panel
    //panel.add(textField);

    //Button
    JButton button = new JButton("Calculate");

    BreadAlgorithm breadRunner = new BreadAlgorithm();

    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        breadRunner.scanBread();
        
      }
    });

    // Add the button to the panel
    panel.setLayout(new BorderLayout());

    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.CENTER);



    panel.add(label, BorderLayout.CENTER);
    panel.add(button, BorderLayout.SOUTH);

    // Make the frame visible
    frame.setVisible(true);
  }
}
