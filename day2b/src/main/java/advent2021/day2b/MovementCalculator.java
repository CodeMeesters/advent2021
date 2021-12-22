package advent2021.day2b;

import org.eclipse.collections.api.list.ImmutableList;

public class MovementCalculator {

  private ImmutableList<Movement> mMovements;

  public MovementCalculator(ImmutableList<Movement> pMovements) {
    super();
    mMovements = pMovements;
  }
  
  public TotalMovement calculate() {
    int horizontal = 0;
    int depth = 0;
    int aim = 0;
    for (Movement movement : mMovements) {
      switch (movement.getDirection()) {
      case DOWN:
        aim = aim + movement.getUnits();
        break;
      case UP:
        aim = aim - movement.getUnits();
        break;
      case FORWARD:
        horizontal = horizontal + movement.getUnits();
        depth = depth + movement.getUnits() * aim;
        break;
      default:
        throw new IllegalArgumentException();
      }
    }
    return new TotalMovement(horizontal, depth);
  }
  
  public static class TotalMovement {
    public final int horizontal;
    public final int depth;
    public final int product;
    
    public TotalMovement(int pHorizontal, int pDepth) {
      horizontal = pHorizontal;
      depth = pDepth;
      product = depth * horizontal;
    }
  }

}
