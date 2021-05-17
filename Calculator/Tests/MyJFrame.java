import javax.swing.JFrame;

public class MyJFrame extends JFrame {
    public MyJFrame() {
        super();

        build();
    }

    private void build(){
		setTitle("First JFrame"); // Application Title
		setSize(320,240); // Application Size
		setLocationRelativeTo(null); // Application position on screen (here centered)
		setResizable(true); // Application can't be resizeable
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on click
	}
}
