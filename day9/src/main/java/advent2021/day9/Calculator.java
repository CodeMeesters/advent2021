package advent2021.day9;

import java.awt.Point;

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.impl.factory.primitive.IntLists;

public class Calculator {
  protected int[][] mData;
  protected int mWidth;
  protected int mHeight;
  protected int mSum;
  protected MutableIntList mLowestPoints;
  protected MutableList<Point> mLowestLocations = Lists.mutable.empty();

  public Calculator(ImmutableList<IntList> pLines) {
    mWidth = pLines.get(0).size();
    mHeight = pLines.size();
    mData = new int[mHeight][mWidth];
    for (int y = 0; y < mHeight; y++) {
      IntList line = pLines.get(y);
      for (int x = 0; x < mWidth; x++) {
        mData[y][x] = line.get(x);
      }
    }
  }

  public long getSum() {
    return mSum;
  }

  public void calculate() {
    mSum = 0;
    mLowestPoints = IntLists.mutable.empty();
    mLowestLocations.clear();
    for (int x = 0; x < mWidth; x++) {
      for (int y = 0; y < mHeight; y++) {
        if (isLowest(x,y)) {
          mLowestPoints.add(mData[y][x]);
          mLowestLocations.add(new Point(x,y));
          mSum = mSum + 1 + mData[y][x];
        }
      }
    }
  }

  private boolean isLowest(int pX, int pY) {
    return isLeftHigher(pX, pY) &&
        isAboveHigher(pX, pY) && isUnderHigher(pX, pY) && isRightHigher(pX, pY);
  }

  private boolean isLeftHigher(int pX, int pY) {
    if (pX == 0) {
      return true;
    }
    return mData[pY][pX-1] > mData[pY][pX];
  }

  private boolean isAboveHigher(int pX, int pY) {
    if (pY == 0) {
      return true;
    }
    return mData[pY-1][pX] > mData[pY][pX];
  }

  private boolean isUnderHigher(int pX, int pY) {
    if (pY == mHeight-1) {
      return true;
    }
    return mData[pY+1][pX] > mData[pY][pX];
  }
  
  private boolean isRightHigher(int pX, int pY) {
    if (pX == mWidth-1) {
      return true;
    }
    return mData[pY][pX+1] > mData[pY][pX];
  }
  
  public IntIterable getLowPoints() {
    return mLowestPoints;
  }
}
