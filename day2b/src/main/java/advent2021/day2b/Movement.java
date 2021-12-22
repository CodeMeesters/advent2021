package advent2021.day2b;

public class Movement {

  public enum Direction { UP, DOWN, FORWARD }

  private Direction mDirection;
  private int mUnits;

  public Movement(Direction pDirection, int pUnits) {
    mDirection = pDirection;
    mUnits = pUnits;
  }

  public Direction getDirection() {
    return mDirection;
  }
  
  public int getUnits() {
    return mUnits;
  }

}
