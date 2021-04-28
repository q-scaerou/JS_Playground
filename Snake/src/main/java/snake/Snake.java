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

    public Snake(int[] pos, int[] speed, String color) {
        this.pos = pos;
        this.speed = speed;
        this.color = color;
    }

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
        if (next[0] == -1) {
            getPos()[0] = grid.getNRows();
            if (grid.getCell(getPos()[0], getPos()[1]).equals("#") ||
            grid.getCell(getPos()[0], getPos()[1]).equals("*")) {
            killSnake();
            } else if (grid.getCell(getPos()[0], getPos()[1]).equals("o")) {
                increaseSize();
            }
        } else if (next[0] == (grid.getNRows() + 1)) {
            getPos()[0] = 0;
            if (grid.getCell(getPos()[0], getPos()[1]).equals("#") ||
            grid.getCell(getPos()[0], getPos()[1]).equals("*")) {
            killSnake();
            } else if (grid.getCell(getPos()[0], getPos()[1]).equals("o")) {
                increaseSize();
            }
        } else if (next[1] == -1) {
            getPos()[1] = grid.getNCols();
            if (grid.getCell(getPos()[0], getPos()[1]).equals("#") ||
            grid.getCell(getPos()[0], getPos()[1]).equals("*")) {
            killSnake();
            } else if (grid.getCell(getPos()[0], getPos()[1]).equals("o")) {
                increaseSize();
            }
        } else if(next[1] == (grid.getNCols() + 1)) {
            getPos()[1] = 0;
            if (grid.getCell(getPos()[0], getPos()[1]).equals("#") ||
            grid.getCell(getPos()[0], getPos()[1]).equals("*")) {
            killSnake();
            } else if (grid.getCell(getPos()[0], getPos()[1]).equals("o")) {
                increaseSize();
            }
        } else {
            if (grid.getCell(next[0], next[1]).equals("#") ||
            grid.getCell(next[0], next[1]).equals("*")) {
            killSnake();
            } else if (grid.getCell(next[0], next[1]).equals("o")) {
                increaseSize();
            }
            getPos()[0] = next[0];
            getPos()[1] = next[1];
        }
    }

    public int[] getPos() {
        return pos;
    }

    public int getSize() {
        return size;
    }
    public void increaseSize() {
        size++;
    }
}