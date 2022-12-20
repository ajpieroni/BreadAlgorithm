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
        // base frame
        JFrame frame = new JFrame("Bread Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLayout(new FlowLayout());

        JFrame frame1 = new JFrame("Option 1");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(1000, 1000);
        frame1.setLayout(new FlowLayout());

        JFrame frame2 = new JFrame("Option 2");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(1000, 1000);
        frame2.setLayout(new FlowLayout());

        JFrame frame3 = new JFrame("Option 3");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(1000, 1000);
        frame3.setLayout(new FlowLayout());

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

                frame.dispose();
                

                // call focacciaRecipeForwards method
                String out = BreadAlgorithm.focacciaRecipeForwards(formattedTime);
                JLabel label1 = new JLabel(out);
                
                frame1.add(label1);




                frame1.setVisible(true);
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

                frame.dispose();
                frame2.setVisible(true);

                // call focacciaRecipeForwards method
                BreadAlgorithm.focacciaRecipeForwards(formattedTime);
            }
        });
        button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // get time from text field
                    String input = timeField.getText();
                    LocalTime time = LocalTime.parse(input);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
                    String formattedTime = time.format(formatter);
    
                    frame.dispose();
                    frame3.setVisible(true);
    
                    // call focacciaRecipeForwards method
                    BreadAlgorithm.focacciaRecipeForwards(formattedTime);
                }
        });

        frame.setVisible(true);
    }
}
