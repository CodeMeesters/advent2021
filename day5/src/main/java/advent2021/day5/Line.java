package advent2021.day5;

import java.awt.Point;

public class Line {
  
  private Point mStart;
  private Point mEnd;

  public Line(Point pStart, Point pEnd) {
    mStart = pStart;
    mEnd = pEnd;
  }
  
  public Line(int pX1, int pY1, int pX2, int pY2) {
    this(new Point(pX1, pY1), new Point(pX2, pY2));
  }

  @Override
  public String toString() {
    return mStart + " -> " + mEnd;
  }

  public boolean isVertical() {
    return (mStart.x == mEnd.x);
  }
  
  public boolean isHorizontal() {
    return (mStart.y == mEnd.y);
  }
  
  public int getX1() {
    return mStart.x;
  }

  public int getY1() {
    return mStart.y;
  }
  
  public int getX2() {
    return mEnd.x;
  }

  public int getY2() {
    return mEnd.y;
  }

}
