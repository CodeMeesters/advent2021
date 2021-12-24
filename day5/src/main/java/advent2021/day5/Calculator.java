package advent2021.day5;

import java.awt.Point;

import org.eclipse.collections.api.list.ImmutableList;

public class Calculator {

  private ImmutableList<Line> mLines;
  private int[][] mGrid;

  public Calculator(ImmutableList<Line> pLines, int pSize) {
    mLines = pLines;
    mGrid = new int[pSize][pSize];
  }
  
  public void calculateGrid() {
    for (Line line : mLines) {
      PointGenerator generator = new PointGenerator(line);
      while (generator.hasNext()) {
        Point point = generator.getNext();
        mGrid[point.x][point.y] = mGrid[point.x][point.y] + 1; 
      }
    }
  }

  public int getNumberOfOverlaps() {
    int total = 0;
    for (int y = 0; y < mGrid.length; y++) {
      int[] row = mGrid[y];
      for (int x = 0; x < row.length; x++) {
        if (row[x] >= 2) {
          total++;
        }
      }
    }
    return total;
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int y = 0; y < mGrid.length; y++) {
      int[] row = mGrid[y];
      for (int x = 0; x < row.length; x++) {
        if (row[x] == 0) {
          builder.append(".");
        }
        else {
          builder.append(Integer.toString(row[x]));
        }
      }
      builder.append("\n");
    }
    return builder.toString();
  }
  
}
