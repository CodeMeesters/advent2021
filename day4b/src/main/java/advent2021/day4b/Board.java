package advent2021.day4b;

public class Board {
  
  private static final int SIZE = 5;
  private int mIndex;
  private int[][] mValues;
  private boolean[][] mDrawn;
  private int mLatestDraw;

  public Board() {
    mValues = new int[SIZE][SIZE];
    mDrawn = new boolean[SIZE][SIZE];
    mIndex = 0;
    mLatestDraw = 0;
  }

  public void add(int pCell) {
    int row = mIndex / SIZE;
    int col = mIndex % SIZE;
    mValues[row][col] = pCell;
    mDrawn[row][col] = false;
    mIndex++;
  }

  public int[] getRow(int pRow) {
    int[] result = new int[SIZE];
    for (int col = 0; col < SIZE; col++) {
      int value = mValues[pRow][col];
      result[col] = value;
    }
    return result;
  }
  
  public int[] getCol(int pCol) {
    int[] result = new int[SIZE];
    for (int row = 0; row < SIZE; row++) {
      int value = mValues[row][pCol];
      result[row] = value;
    }
    return result;
  }

  public void setDrawn(int pDraw) {
    mLatestDraw = pDraw;
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if (mValues[row][col] == pDraw) {
          mDrawn[row][col] = true;
        }
      }
    }
  }

  public int getScore() {
    int sumNotDrawn = 0;
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if (!mDrawn[row][col]) {
          sumNotDrawn = sumNotDrawn + mValues[row][col]; 
        }
      }
    }
    return sumNotDrawn * mLatestDraw;
  }

  public boolean isFinished() {    
    for (int row = 0; row < SIZE; row++) {
      if (isRowComplete(row)) {
        return true;
      }
    }
    for (int col = 0; col < SIZE; col++) {
      if (isColComplete(col)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isColComplete(int pCol) {
    for (int row= 0; row < SIZE; row++) {
      if (!mDrawn[row][pCol]) {
        return false;
      }
    }
    return true;
  }

  private boolean isRowComplete(int pRow) {
    for (int col = 0; col < SIZE; col++) {
      if (!mDrawn[pRow][col]) {
        return false;
      }
    }
    return true;
  }

}
