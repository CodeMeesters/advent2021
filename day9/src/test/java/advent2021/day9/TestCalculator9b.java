package advent2021.day9;

import static org.junit.Assert.assertEquals;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.junit.Test;

public class TestCalculator9b {

  private ImmutableList<IntList> mLines;

  private BasinCalculator mCalculator;

  @Test
  public void basinCalculator() {
    givenADataSet();
    givenACalculator();
    whenCalculating();
    thenTheOutcomeShouldBe(1134);
  }
  
  private void thenTheOutcomeShouldBe(int pExpected) {
    assertEquals(pExpected, mCalculator.getBasinProduct());
  }

  private void whenCalculating() {
    mCalculator.calculate();
  }

  private void givenACalculator() {
    mCalculator = new BasinCalculator(mLines);
  }

  private void givenADataSet() {
    MutableList<IntList> lines = Lists.mutable.empty();
    lines.add(IntLists.immutable.with(2,1,9,9,9,4,3,2,1,0));
    lines.add(IntLists.immutable.with(3,9,8,7,8,9,4,9,2,1));
    lines.add(IntLists.immutable.with(9,8,5,6,7,8,9,8,9,2));
    lines.add(IntLists.immutable.with(8,7,6,7,8,9,6,7,8,9));
    lines.add(IntLists.immutable.with(9,8,9,9,9,6,5,6,7,8));
    mLines = lines.toImmutable();
  }
}
