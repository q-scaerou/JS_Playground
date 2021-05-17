package snake;

import org.json.simple.JSONObject;

import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class Game extends JFrame implements KeyListener {

    int nRows;
    int nCols;
    Grid g;
    Snake s;

    public Game(String name, int nRows, int nCols) {
        super(name);
        addKeyListener(this);
        this.nRows = nRows;
        this.nCols = nCols;

        this.g = new Grid(nRows, nCols);
        int[] pos = { 4, 4 };
        int[] speed = { 1, 0 };
        this.s = new Snake(pos, speed, "red");

        pack();
        setResizable(false);
        setVisible(true);

        Timer timer = new Timer(1000, null);
        GridActionListener listener = new GridActionListener(this, g, s, timer);
        timer.addActionListener(listener);
        timer.start();
    }

    // This method is where the GUI is built although here it's
    // a very minimalistic one with just a window and nothing inside.
    private static void createAndShowGUI(int nRows, int nCols) {
        // Create and set up the window.
        Game frame = new Game("SnakeThis", nRows, nCols);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(nCols * 30, nRows * 30);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setSize(frame.nCols * 30, frame.nRows * 30);
        

    }

    // Satisfy KeyListener interface constraint
    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("RIGHT");
            s.turnRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("LEFT");
            s.turnLeft();
        }
    }

    public static void main(String[] args) {
        // Recover command line arguments for the size of
        // the grid to generate
        int nRows = (int) (Math.random() * 20);
        int nCols = (int) (Math.random() * 20);
        if (nRows < 5) {
            nRows = 5;
        }
        if (nCols < 5) {
            nCols = 5;
        }
        final int columns = nCols;
        final int rows = nRows;
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                createAndShowGUI(rows, columns);
            }
        });

        // Schedule app boot in the EDT
    }
}

class GridActionListener implements ActionListener {

    Game m;
    Grid g;
    Snake s;
    Timer t;

    public GridActionListener(Game m, Grid g, Snake s, Timer t) {
        this.m = m;
        this.g = g;
        this.s = s;
        this.t = t;
    }

    public void actionPerformed(ActionEvent e) {
        s.moveOn(g);
        g.updateGrids(s);
        System.out.println(g);

        if (!s.isAlive()) {
            m.dispatchEvent(new WindowEvent(m, WindowEvent.WINDOW_CLOSING));
        }

        JSONObject score = new JSONObject();
        score.put("score", s.getSize());
        score.put("name", "bob");
        try {
            FileWriter file = new FileWriter("score.json");
            file.write(score.toJSONString());
            file.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}