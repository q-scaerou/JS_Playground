import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class ButtonListener extends JFrame implements ActionListener {

    private JButton btn1;
	private JButton btn2;

    public ButtonListener() {
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
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
 
		JButton btn1 = new JButton("Click Here!");
        btn1.addActionListener(this);
		panel.add(btn1);
 
		JButton btn2 = new JButton("Or Here!");
        btn2.addActionListener(this);
		panel.add(btn2);
 
		return panel;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object source = e.getSource();
        if (source == btn1) {
            System.out.println("click btn1");
        } else if (source == btn2) {
            System.out.println("Click");
        }
    
        
    }
    
}
