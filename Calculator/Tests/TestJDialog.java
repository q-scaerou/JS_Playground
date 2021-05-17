import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.*;

/**
 * TestJDialog
 */
public class TestJDialog {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
			public void run(){
                // Creation of the new JDialog frame
                JDialog dialog = new JDialog();
                dialog.setSize(300, 200); // Setup of the JDialog size
                dialog.setTitle("First JDialog"); // Title of the JDialog
                dialog.setVisible(true); // Making it visible
                // Close the JDialog on click on the X button
                dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

    }
}