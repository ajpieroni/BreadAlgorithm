import java.awt.FlowLayout;
import java.time.LocalTime;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TimePromptPanel extends JPanel {
    private JTextField timeField;

    public TimePromptPanel(){
        setLayout(new FlowLayout());
        JLabel promptLabel = new JLabel("Enter the time (hh:mm a): ");
        timeField = new JTextField(10);

        add(promptLabel);
        add(timeField);
    }
    
    public LocalTime getTime() {
        String timeString = timeField.getText();
        return LocalTime.parse(timeString);
    }
}
