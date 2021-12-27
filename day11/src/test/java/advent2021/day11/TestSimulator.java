package advent2021.day11;

import static org.junit.Assert.assertEquals;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.junit.Test;

public class TestSimulator {
  
  private ImmutableList<IntList> mLines;
  private Simulator mSimulator;

  @Test
  public void simulate() {
    givenADataSet();
    givenASimulator();
    thenTheCurrentSituationForRowShouldBe(2, IntLists.immutable.with(2,7,4,5,8,5,4,7,1,1));
    thenTheCurrentSituationForRowShouldBe(10, IntLists.immutable.with(5,2,8,3,7,5,1,5,2,6));
    whenStepping(1);
    thenTheCurrentSituationForRowShouldBe(1, IntLists.immutable.with(6,5,9,4,2,5,4,3,3,4));
    thenTheCurrentSituationForRowShouldBe(2, IntLists.immutable.with(3,8,5,6,9,6,5,8,2,2));
    thenTheCurrentSituationForRowShouldBe(10, IntLists.immutable.with(6,3,9,4,8,6,2,6,3,7));
    whenStepping(1);
    thenTheCurrentSituationForRowShouldBe(1, IntLists.immutable.with(8,8,0,7,4,7,6,5,5,5));
    thenTheCurrentSituationForRowShouldBe(2, IntLists.immutable.with(5,0,8,9,0,8,7,0,5,4));
    thenTheCurrentSituationForRowShouldBe(10, IntLists.immutable.with(8,7,0,0,0,0,6,8,4,8));
    whenSteppingTo(5);
    thenTheCurrentSituationForRowShouldBe(1, IntLists.immutable.with(4,4,8,4,1,4,4,0,0,0));
    thenTheCurrentSituationForRowShouldBe(2, IntLists.immutable.with(2,0,4,4,1,4,4,0,0,0));
    thenTheCurrentSituationForRowShouldBe(10, IntLists.immutable.with(2,2,4,3,3,4,1,3,2,2));
    whenSteppingTo(100);
    thenTheCurrentSituationForRowShouldBe(1, IntLists.immutable.with(0,3,9,7,6,6,6,8,6,6));
    thenTheCurrentSituationForRowShouldBe(2, IntLists.immutable.with(0,7,4,9,7,6,6,9,1,8));
    thenTheCurrentSituationForRowShouldBe(10, IntLists.immutable.with(6,7,8,9,9,9,8,7,6,6));
    
    thenTheTotalNumberOfFlashesShouldBe(1656);
  }

  private void thenTheTotalNumberOfFlashesShouldBe(long pExpected) {
    assertEquals(pExpected, mSimulator.getNumberOfFlashes());
  }

  private void whenSteppingTo(int pStep) {
    while (mSimulator.getSteps() < pStep) {
      mSimulator.step();
    }
  }

  private void whenStepping(int pCount) {
    for (int i = 0; i < pCount; i++) {
      mSimulator.step();
    }
  }

  private void thenTheCurrentSituationForRowShouldBe(int pRow, ImmutableIntList pExpected) {
    ImmutableIntList actual = mSimulator.getLevelsForRow(pRow-1);
    assertEquals(pExpected.size(), actual.size());
    assertEquals(pExpected, actual);
  }

  private void givenASimulator() {
    mSimulator = new Simulator(mLines);
  }

  private void givenADataSet() {
    MutableList<IntList> lines = Lists.mutable.empty();
    lines.add(IntLists.immutable.with(5,4,8,3,1,4,3,2,2,3));
    lines.add(IntLists.immutable.with(2,7,4,5,8,5,4,7,1,1));
    lines.add(IntLists.immutable.with(5,2,6,4,5,5,6,1,7,3));
    lines.add(IntLists.immutable.with(6,1,4,1,3,3,6,1,4,6));
    lines.add(IntLists.immutable.with(6,3,5,7,3,8,5,4,7,8));
    lines.add(IntLists.immutable.with(4,1,6,7,5,2,4,6,4,5));
    lines.add(IntLists.immutable.with(2,1,7,6,8,4,1,7,2,1));
    lines.add(IntLists.immutable.with(6,8,8,2,8,8,1,1,3,4));
    lines.add(IntLists.immutable.with(4,8,4,6,8,4,8,5,5,4));
    lines.add(IntLists.immutable.with(5,2,8,3,7,5,1,5,2,6));
    mLines = lines.toImmutable();
  }

}
