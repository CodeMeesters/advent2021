package advent2021.day3b;

import static org.junit.Assert.assertEquals;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Test;

import advent2021.day3b.Calculator.Totals;

public class TestCalculator {

  private Calculator mCalculator;
  private Totals mTotals;

  @Test
  public void example()  {
    givenACalculatorFor("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010");
    afterCalculating();
    thenTheOxygenGeneratorRatingBitsAre("10111");
    thenTheCO2ScrubberRatingBitsAre("01010");
    thenTheOxygenGeneratorRatingIs(23);
    thenTheCO2ScubberRatingIs(10);
    thenTheLifeSupportRatingIs(230);
  }

  private void thenTheLifeSupportRatingIs(int pExpected) {
    assertEquals("Invalid life support", pExpected, mTotals.getLifeSupportRating());
  }

  private void thenTheCO2ScubberRatingIs(int pExpected) {
    assertEquals("Invalid CO2", pExpected, mTotals.getCO2Rating());
  }

  private void thenTheOxygenGeneratorRatingIs(int pExpected) {
    assertEquals("Invalid oxygen", pExpected, mTotals.getOxygenRating());
  }

  private void afterCalculating() {
    mTotals = mCalculator.calculate();
  }
  
  private void thenTheOxygenGeneratorRatingBitsAre(String pExpected) {
    assertEquals("Invalid oxygen bits", pExpected, mTotals.getOxygenRatingAsText());
  }

  private void thenTheCO2ScrubberRatingBitsAre(String pExpected) {
    assertEquals("Invalid CO2 bits", pExpected, mTotals.getCO2RatingAsText());
  }
  
  private void givenACalculatorFor(String... pLines) {
    MutableList<Line> lines = Lists.mutable.empty();
    for (String line : pLines) {
      lines.add(new Line(line));
    }
    mCalculator = new Calculator(lines.toImmutable());
  }
}
