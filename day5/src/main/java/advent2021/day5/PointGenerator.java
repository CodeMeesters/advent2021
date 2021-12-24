package advent2021.day5;

import java.awt.Point;

public class PointGenerator {

  private IGenerator mGenerator;

  public PointGenerator(Line pLine) {
    if (pLine.isHorizontal()) {
      mGenerator = new HorizontalGenerator(pLine);
    }
    else {
      mGenerator = new VerticalGenerator(pLine);
    }
  }
  
  public boolean hasNext() {
    return mGenerator.hasNext();
  }
  
  public Point getNext() {
    return mGenerator.getNext();
  }
  
  private interface IGenerator {
    boolean hasNext();
    Point getNext();
  }
  
  private static class HorizontalGenerator implements IGenerator {
    
    private int mX0;
    private int mX1;
    private int mY;
    private int mX;

    public HorizontalGenerator(Line pLine) {
      mX0 = Math.min(pLine.getX1(), pLine.getX2());
      mX1 = Math.max(pLine.getX1(), pLine.getX2());
      mX = mX0-1;
      mY = pLine.getY1();
    }

    @Override
    public boolean hasNext() {
      return mX < mX1;
    }

    @Override
    public Point getNext() {
      mX++;
      return new Point(mX, mY);
    }
    
  }

  private static class VerticalGenerator implements IGenerator {
    private int mY0;
    private int mY1;
    private int mX;
    private int mY;

    public VerticalGenerator(Line pLine) {
      mY0 = Math.min(pLine.getY1(), pLine.getY2());
      mY1 = Math.max(pLine.getY1(), pLine.getY2());
      mY = mY0-1;
      mX = pLine.getX1();
    }

    @Override
    public boolean hasNext() {
      return mY < mY1;
    }

    @Override
    public Point getNext() {
      mY++;
      return new Point(mX, mY);
    }
  }
}
