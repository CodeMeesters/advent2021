package advent2021.day2b;

import static org.junit.Assert.assertEquals;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.Test;

import advent2021.day2b.Movement.Direction;
import advent2021.day2b.MovementCalculator.TotalMovement;

public class TestMovementCalculator {

  private MovementCalculator mCalculator;

  @Test
  public void example()  {
    givenACalculatorFor(forward(5), down(5), forward(8), up(3), down(8), forward(2));
    thenTheTotalMovementShouldBe(15, 60, 900);
  }

  private void thenTheTotalMovementShouldBe(int pHorizontal, int pDepth, int pProduct) {
    TotalMovement totalMovement = mCalculator.calculate();
    assertEquals("Invalid horizontal", pHorizontal, totalMovement.horizontal);
    assertEquals("Invalid depth", pDepth, totalMovement.depth);
    assertEquals("Invalid product", pProduct, totalMovement.product);
  }

  private void givenACalculatorFor(Movement... pMovements) {
    ImmutableList<Movement> movements = Lists.immutable.with(pMovements);
    mCalculator = new MovementCalculator(movements);
  }

  private Movement up(int pUnits) {
    return new Movement(Direction.UP, pUnits);
  }
  
  private Movement down(int pUnits) {
    return new Movement(Direction.DOWN, pUnits);
  }
  
  private Movement forward(int pUnits) {
    return new Movement(Direction.FORWARD, pUnits);
  }
}
