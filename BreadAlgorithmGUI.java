import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BreadAlgorithmGUI {
    static String prompt = "<html> Get b-ready! Do you want to make bread now, you already started, or plan a time for bread to be ready later? <br> </html>";

    public static void main(String[] args) {
        
        BreadAlgorithm obj = new BreadAlgorithm();
        // base frame
        JFrame frame = new JFrame("Bread Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new FlowLayout());

        JFrame frame1 = new JFrame("Let's make bread now!");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(600, 500);
        frame1.setLayout(new FlowLayout());

        JFrame frame2 = new JFrame("Option 2");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(800, 500);
        frame2.setLayout(new FlowLayout());

        JFrame frame3 = new JFrame("Option 3");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(800, 500);
        frame3.setLayout(new FlowLayout());

        // create a label
        JLabel label = new JLabel(prompt);
        label.setHorizontalAlignment(JLabel.CENTER);

        // create a text field
        JTextField timeField = new JTextField(20);
        timeField.setText("Enter time here (hh:mm a)");

        // create buttons
        JButton button1 = new JButton("Bread Now");
        JButton button2 = new JButton("Bread Later");
        JButton button3 = new JButton("Bread WIP");

        // add components to frame
        frame.setLayout(new BorderLayout());
        

        JPanel buttonPanel = new JPanel(new FlowLayout());

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        frame.add(label, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        //frame.add(timeField);

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

                //print output
                JLabel currentTime = new JLabel("The current time is: "+ formattedTime);
                currentTime.setHorizontalAlignment(JLabel.CENTER);
                JLabel times = new JLabel(out);

                frame.setLayout(new BorderLayout());
        

                JPanel upperPanel = new JPanel(new FlowLayout());
                JPanel lowerPanel = new JPanel(new FlowLayout());

                upperPanel.add(currentTime);
                lowerPanel.add(times);

                frame1.add(upperPanel,BorderLayout.NORTH);
                frame1.add(lowerPanel, BorderLayout.SOUTH);

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
