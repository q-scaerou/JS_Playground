import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;

public class Calculator {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Window calc = new Window();
                // calc.setVisible(true);
                ButtonListener Blist = new ButtonListener();
                Blist.setVisible(true);
            }
        });
    }
}
