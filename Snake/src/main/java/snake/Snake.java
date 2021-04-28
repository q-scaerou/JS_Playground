package snake;

/**
 * Snake
 */
public class Snake {

    private int[] pos = new int[2];
    int[] speed = new int[2];
    String color;
    Boolean alive = true;
    private int size = 1;

    /**
    * This is the constructor of the Snake Object.
    * The Snake is initialized with a position, an
    * initial speed and a color.
    */
    public Snake(int[] pos, int[] speed, String color) {
        this.pos = pos;
        this.speed = speed;
        this.color = color;
    }

    /**
    * This method checks if the snake is still alive.
    * @return True or False, depending on
    * wether snake has collided with a wall or itself.
    */
    public boolean isAlive() {
        return this.alive;
    }

    public void killSnake() {
        this.alive = false;
    }
    
    public int[] getNextPosition() {
        int[] nextPos = new int[2];
        nextPos[0] = pos[0] + speed[0];
        nextPos[1] = pos[1] + speed[1];
        return nextPos;
    }

    public void turnRight() {
        if (speed[0] == 0 && speed[1] == 1) {
            speed[0] = 1;
            speed[1] = 0;
        } else if (speed[0] == 0 && speed[1] == -1) {
            speed[0] = -1;
            speed[1] = 0;
        } else if (speed[0] == 1 && speed[1] == 0) {
            speed[0] = 0;
            speed[1] = -1;
        } else if (speed[0] == -1 && speed[1] == 0) {
            speed[0] = 0;
            speed[1] = 1;
        }
    }

    public void turnLeft() {
        if (speed[0] == 0 && speed[1] == 1) {
            speed[0] = -1;
            speed[1] = 0;
        } else if (speed[0] == 0 && speed[1] == -1) {
            speed[0] = 1;
            speed[1] = 0;
        } else if (speed[0] == 1 && speed[1] == 0) {
            speed[0] = 0;
            speed[1] = 1;
        } else if (speed[0] == -1 && speed[1] == 0) {
            speed[0] = 0;
            speed[1] = -1;
        }
    }

    public void moveOn(Grid grid) {
        int[] next = getNextPosition();
        if (next[0] == grid.getNRows()) {
            pos[0] = 0;
        } else if (next[0] < 0) {
            pos[0] = grid.getNRows() - 1;
        } else if (next[1] == grid.getNCols()) {
            pos[1] = 0;
        } else if (next[1] < 0) {
            pos[1] = grid.getNCols() - 1;
        } else {
            pos = next;
        }
        if (grid.getCell(pos[0], pos[1]).equals("#") ||
            grid.getCell(pos[0], pos[1]).equals("*")) {
            killSnake();
        } else if (grid.getCell(pos[0], pos[1]).equals("o")) {
            size++;
        }
    }

    /**
    * Usual getter to access private data
    * of the Snake object. 
    * @return Position of the snake as a int array
    * with 2 elements {y, x}.
    */
    public int[] getPos() {
        return pos;
    }

    /**
    * Usual getter to access private data
    * of the Snake object. 
    * @return Size of the snake as an int.
    */
    public int getSize() {
        return size;
    }
    public void increaseSize() {
        size++;
    }
}