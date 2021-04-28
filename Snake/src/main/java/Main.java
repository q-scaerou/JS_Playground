import snake.Grid;
import snake.Snake;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Grid g = new Grid(10, 20);
        int[] initPos = {0, 0};
        int[] initSpeed = {0, 1};
        Snake s = new Snake(initPos, initSpeed, "red");
        g.dropBlock(8, 8);
        g.dropFood(5, 4);
        g.dropFood(6, 4);
        g.dropFood(7, 4);
        g.dropFood(8, 4);
        g.dropFood(8, 5);
        g.dropFood(8, 6);
        g.dropFood(8, 7);
        int countTurn = 0;
        while (s.isAlive()) {
            if (countTurn == 3 || countTurn == 20 || countTurn == 22 ||
                countTurn == 24 || countTurn == 26) {
                s.turnRight();
            }
            if (countTurn == 11 || countTurn == 14 || countTurn == 16 ||
                countTurn == 18 || countTurn == 28) {
                s.turnLeft();
            }
            s.moveOn(g);
            g.updateGrids(s);
            System.out.println(g.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                
            }
            countTurn++;
        }
        System.out.println(s.getSize());
    }
}