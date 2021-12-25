package advent2021.day7b;

import static org.junit.Assert.assertEquals;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Test;

public class TestCalculator {

  private Calculator mCalculator;
  private ImmutableList<Cohort> mCohorts;
  private Cohort mCohort;
  private long mCosts;
  private int mPosition;

  @Test
  public void calculateFuelCosts() {
    givenADataSet();
    whenRequestingFuelCostsForPosition(2);
    thenTheCostsShouldBe(206);
    whenRequestingFuelCostsForPosition(5);
    thenTheCostsShouldBe(168);
    
    for (int i = 0; i <= 16; i++) {
      System.out.println(i + ": " + mCalculator.calculateFuelCosts(i));
    }
  }
  
  @Test
  public void calculateFuelCost() {
    givenACohortAtPosition(16);
    thenTheFuelCostsForFiveAre(66);
    
    givenACohortAtPosition(7);
    thenTheFuelCostsForFiveAre(3);
    
    givenACohortAtPosition(0);
    thenTheFuelCostsForFiveAre(15);
  }
  
  @Test
  public void calculateMinimum() {
    givenADataSet();
    whenCalculatingTheMinimum();
    thenThePositionIs(5);
    thenTheCostsShouldBe(168);
  }

  private void thenTheFuelCostsForFiveAre(int pExpected) {
    assertEquals("Invalid fuel cost", pExpected, mCohort.fuelCosts(5));
  }

  private void givenACohortAtPosition(int pPosition) {
    mCohort = new Cohort(pPosition, 1);
  }

  
  private void thenThePositionIs(int pExpected) {
    assertEquals("Invalid position", pExpected, mPosition);
  }

  private void whenCalculatingTheMinimum() {
    mCalculator = new Calculator(mCohorts);
    Optimizer method = new Optimizer(0, 16, mCalculator);
    mPosition = method.findMinimum();
    mCosts = mCalculator.calculateFuelCosts(mPosition);
  }

  private void thenTheCostsShouldBe(long pExpected) {
    assertEquals("Invalid costs", pExpected, mCosts);
  }

  private void whenRequestingFuelCostsForPosition(int pPosition) {
    mCalculator = new Calculator(mCohorts);
    mCosts = mCalculator.calculateFuelCosts(pPosition);
  }

  private void givenADataSet() {
    MutableList<Cohort> lines = Lists.mutable.empty();
    lines.add(new Cohort(16, 1));
    lines.add(new Cohort(1, 2));
    lines.add(new Cohort(2, 3));
    lines.add(new Cohort(0, 1));
    lines.add(new Cohort(4, 1));
    lines.add(new Cohort(7, 1));
    lines.add(new Cohort(14, 1));
    mCohorts = lines.toImmutable();
  }
  
}
