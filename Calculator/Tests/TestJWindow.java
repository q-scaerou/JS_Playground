import javax.swing.JWindow;
import javax.swing.SwingUtilities;

/**
 * Main
 */


public class TestJWindow {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                // Creation of a new JWindow
                JWindow window = new JWindow(); 
                window.setSize(300, 200); // Setup of the JWindow size
                window.setVisible(true); // Making the JWindow visible
            }
        });

        try { 
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
 
		System.exit(0);
    }
}