import javax.swing.SwingUtilities;

public class TestJFrame {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				//On crée une nouvelle instance de notre JDialog
				MyJFrame fenetre = new MyJFrame();
				fenetre.setVisible(true);//On la rend visible
			}
		});
    }

}
