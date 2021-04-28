package snake;

/**
 * Grid
 */
public class Grid {

  private String[][] grid;
  private int nRows;
  private int nCols;
  private int[][] intGrid;

  /**
   * This is the constructor of the Grid Object.
   * A grid is initialized with a certain number
   * of rows and columns. It is then filled with
   * spaces (" ") to avoid null in the toString()
   * method.
   */
  public Grid(int nRows, int nCols) {
    this.nRows = nRows;
    this.nCols = nCols;
    this.grid = new String[nRows][nCols];
    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < nCols; j++) {
        this.grid[i][j] = " ";
      }
    }
    this.intGrid = genIntGrid();
  }

  /**
  * This method allows to display the gaming grid as a string. 
  * @return The grid as a String.
  * The grid represents the gaming area where the snake will move.
  * The grid is surrounded by plus signs and cells are separated
  * by spaces.
  */
  public String toString() {
    String out = "+ ".repeat(nCols + 2) + "\n";
    for (int i = 0; i < nRows; i++) {
      out += "+ ";
      for (int j = 0; j < nCols; j++) {
        out += grid[i][j] + " ";
      }
      out += "+ " + "\n";
    }
    out += "+ ".repeat(nCols + 2) + "\n";
    return out;
  }

  /**
  * This method checks if a point is in the game
  * grid or not.
  * @return True or False, depending on
  * wether a point which coordinates are
  * passed as arguments is into the game grid.
  */
  public boolean pointInsideGrid(int y, int x) {
    return (0 <= y && y <= nRows && 0 <= x && x <= nCols);
  }

  /**
  * Place a specified caracter at a particular
  * address in the grid.
  */
  public void placeObject(int y, int x, String o) {
    grid[y][x] = o;
  }

  /**
  * Place a caracter "#" at a particular
  * address in the grid. In a snake game
  * "#" are walls. On collision, the snake dies
  * and game is over.
  */
  public void dropBlock(int y, int x) {
    grid[y][x] = "#";
  }

  /**
  * Place a caracter "o" at a particular
  * address in the grid. In a snake game
  * "o" are apples, making the snake size grow.
  */
  public void dropFood(int y, int x) {
    grid[y][x] = "o";
  }

  /**
  * Usual getter to access private data
  * of the Grid object. 
  * @return The string contained in a 
  particuliar adress in the grid.
  */
  public String getCell(int y, int x) {
    return grid[y][x];
  }

  /**
  * Usual getter to access private data
  * of the Grid object. 
  * @return the String[][] corresponding to the grid.
  */
  public String[][] getGrid() {
    return grid;
  }

  /**
  * OLD - Update the gaming grid by erasing the snake body
  * and, if it's still alive, placing it again.
  * @see #updateGrids
  * This method isn't use anymore once the first tests
  * are passed. Replaced by updateGrids().
  */
  public void updateGrid(Snake snake) {
    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < nCols; j++) {
        if (grid[i][j].equals("*")) {
          grid[i][j] = " ";
        }
      }
    }
    if (snake.isAlive()) {
      placeObject(snake.getPos()[0], snake.getPos()[1], "*");
    }
  }

  /**
  * Update the gaming grid by erasing the snake body
  * and, if it's still alive, placing it again.
  * This method is an update of the updateGrid() and
  * allows to take the snake size into account.
  */
  public void updateGrids(Snake snake) {
    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < nCols; j++) {
        if (grid[i][j].equals("*")) {
          grid[i][j] = " ";
        }
      }
    }
    if (snake.isAlive()) {
      intGrid[snake.getPos()[0]][snake.getPos()[1]] = snake.getSize();
    }
    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < nCols; j++) {
        if (intGrid[i][j] > 0) {
          grid[i][j] = "*";
        }
      }
    }
    decrIntGrid();
  }

  /**
  * This method generate a grid filled with int
  * which size is the same as the gaming grid.
  * This grid is used to manage the snake size.
  */
  public int[][] genIntGrid() {
    int[][] intGrid = new int[getNRows()][getNCols()];
    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < nCols; j++) {
        intGrid[i][j] = 0;
      }
    }
    return intGrid;
  }

  /**
  * Working together with genIntGrid(), this
  * method decreases the positive int contained 
  * in the intGrid by 1.
  */
  public void decrIntGrid() {
    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < nCols; j++) {
        if (intGrid[i][j] > 0) {
          intGrid[i][j] -= 1;
        }
      }
    }
  }

  /**
  * Usual getter to access private data
  * of the Grid object. 
  * @return the number of rows.
  */
  public int getNRows() {
    return nRows;
  }

  /**
  * Usual getter to access private data
  * of the Grid object. 
  * @return the number of columns.
  */
  public int getNCols() {
    return nCols;
  }
}
