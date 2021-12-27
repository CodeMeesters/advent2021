package advent2021.day9;

import java.awt.Point;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.IntList;

public class BasinCalculator extends Calculator {

  private int mBasinProduct;
  private int EDGE = 9;

  public BasinCalculator(ImmutableList<IntList> pLines) {
    super(pLines);
  }

  public void calculate() {
    super.calculate();
    MutableList<Integer> mSizes = Lists.mutable.empty();
    for (Point location : mLowestLocations) {
      mSizes.add(calculateBasinSize(location));
    }
    MutableList<Integer> sorted = mSizes.sortThis().reverseThis();
    mBasinProduct = sorted.get(0) * sorted.get(1) * sorted.get(2);
  }
  
  public int getBasinProduct() {
    return mBasinProduct;
  }

  private int calculateBasinSize(Point pLocation) {
    MutableList<Point> visited = Lists.mutable.empty();
    findEdges(pLocation, visited);
    return visited.size();
  }
  
  private void findEdges(Point pLocation, MutableList<Point> pVisited) {
    if (pVisited.contains(pLocation)) {
      return;
    }
    if (getValue(pLocation) == EDGE) {
      return;
    }
    pVisited.add(pLocation);
    Point location = new Point(pLocation.x-1, pLocation.y);
    findEdges(location, pVisited);
    location = new Point(pLocation.x, pLocation.y-1);
    findEdges(location, pVisited);
    location = new Point(pLocation.x+1, pLocation.y);
    findEdges(location, pVisited);
    location = new Point(pLocation.x, pLocation.y+1);
    findEdges(location, pVisited);
  }

  private int getValue(Point pLocation) {
    if ((pLocation.x < 0) || (pLocation.x > mWidth-1)) {
      return EDGE;
    }
    if ((pLocation.y < 0) || (pLocation.y > mHeight-1)) {
      return EDGE;
    }
    return mData[pLocation.y][pLocation.x];
  }
}
