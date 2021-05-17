import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class Window extends JFrame {

    public Window() {
        super();
        build();
    }

    private void build() {
        setTitle("Calculator");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPanel()); // Building of a content for the window
    }

    private JPanel buildContentPanel(){
        JPanel panel = new JPanel(); // Creation of a JPanel
        panel.setLayout(new FlowLayout()); // Choice of a Layout
        panel.setBackground(Color.GRAY); // Selection of a BG color
        JLabel label = new JLabel("Result is yet to be calculated."); // Label = text displayed in window
        panel.add(label); // Add the label to the panel
        JLabel label2 = new JLabel("Testification of tests");
        panel.add(label2);
        JButton btn1 = new JButton("Click here!");
		panel.add(btn1);
 
		JButton btn2 = new JButton("or there!");
		panel.add(btn2);
    
        return panel;
    }
    
}
