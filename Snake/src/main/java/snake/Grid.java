package snake;

/**
 * Grid
 */
public class Grid {

  private String[][] grid;
  private int nRows;
  private int nCols;
  private int[][] intGrid;

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

  public boolean pointInsideGrid(int y, int x) {
    return (0 <= y && y <= nRows && 0 <= x && x <= nCols);
  }

  public void placeObject(int y, int x, String o) {
    grid[y][x] = o;
  }

  public void dropBlock(int y, int x) {
    grid[y][x] = "#";
  }

  public void dropFood(int y, int x) {
    grid[y][x] = "o";
  }

  public String getCell(int y, int x) {
    return grid[y][x];
  }

  public String[][] getGrid() {
    return grid;
  }

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

  public int[][] genIntGrid() {
    int[][] intGrid = new int[getNRows()][getNCols()];
    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < nCols; j++) {
        intGrid[i][j] = 0;
      }
    }
    return intGrid;
  }

  public void decrIntGrid() {
    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < nCols; j++) {
        if (intGrid[i][j] > 0) {
          intGrid[i][j] -= 1;
        }
      }
    }
  }

  public int getNRows() {
    return nRows;
  }

  public int getNCols() {
    return nCols;
  }
}
