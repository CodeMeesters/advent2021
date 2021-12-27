package advent2021.day9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.junit.Test;

public class TestCalculator {

  private ImmutableList<IntList> mLines;

  private Calculator mCalculator;

  @Test
  public void occurenceCalculator() {
    givenADataSet();
    givenACalculator();
    whenCalculating();
    thenLowPointsAre(1, 0, 5, 5);
    thenTheSumShouldBe(15);
  }
  private void thenLowPointsAre(int... pExpected) {
    List<Integer> asList = Arrays.stream(pExpected).boxed().collect(Collectors.toList());
    ImmutableSet<Integer> expected = Sets.immutable.withAll(asList);
    assertTrue(expected.allSatisfy(e -> mCalculator.getLowPoints().contains(e)));
  }
  
  private void thenTheSumShouldBe(int pExpected) {
    assertEquals(pExpected, mCalculator.getSum());
  }

  private void whenCalculating() {
    mCalculator.calculate();
  }

  private void givenACalculator() {
    mCalculator = new Calculator(mLines);
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
