import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BreadAlgorithmGUI {
    static String prompt = "Get b-ready!\nDo you want to make bread now, you already started, or plan a time for bread to be ready later?";

    public static void main(String[] args) {
        
        BreadAlgorithm obj = new BreadAlgorithm();
        // create a new frame
        JFrame frame = new JFrame("Bread Algorithm");
        JFrame frame1 = new JFrame("Option 1");
        JFrame frame2 = new JFrame("Option 2");
        JFrame frame3 = new JFrame("Option 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLayout(new FlowLayout());

        // create a label
        JLabel label = new JLabel(prompt);

        // create a text field
        JTextField timeField = new JTextField(20);
        timeField.setText("Enter time here (hh:mm a)");

        // create buttons
        JButton button1 = new JButton("Bread Now");
        JButton button2 = new JButton("Bread Later");
        JButton button3 = new JButton("Bread WIP");

        // add components to frame
        frame.add(label);
        //frame.add(timeField);

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        // add action listeners to buttons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get current time
                LocalTime time = LocalTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
                String formattedTime = time.format(formatter);

                // call focacciaRecipeForwards method
                BreadAlgorithm.focacciaRecipeForwards(formattedTime);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get time from text field
                String input = timeField.getText();
                LocalTime time = LocalTime.parse(input);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
                String formattedTime = time.format(formatter);

                // call focacciaRecipeForwards method
                BreadAlgorithm.focacciaRecipeForwards(formattedTime);
            }
        });

        frame.setVisible(true);
    }
}
