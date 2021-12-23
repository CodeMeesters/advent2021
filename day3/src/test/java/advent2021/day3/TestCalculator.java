package advent2021.day3;

import static org.junit.Assert.assertEquals;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Test;

import advent2021.day3.Calculator.Totals;

public class TestCalculator {

  private Calculator mCalculator;
  private Totals mTotals;

  @Test
  public void threeLines()  {
    givenACalculatorFor("00000", "10000", "10000");
    afterCalculating();
    thenTheTotalsForZeroShouldBe(1, 3, 3, 3, 3);
    thenTheTotalsForOneShouldBe(2, 0, 0, 0, 0);
  }

  @Test
  public void example()  {
    givenACalculatorFor("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010");
    afterCalculating();
    thenTheTotalsForZeroShouldBe(5, 7, 4, 5, 7);
    thenTheTotalsForOneShouldBe(7, 5, 8, 7, 5);
    thenTheGammaBitsAre("10110");
    thenTheEpsilonBitsAre("01001");
    thenTheGammaRateIs(22);
    thenTheEpsilonRateIs(9);
    thenThePowerConsumptionIs(198);
  }

  private void thenThePowerConsumptionIs(int pExpected) {
    assertEquals("Invalid power consumption", pExpected, mTotals.getPowerConsumption());
  }

  private void thenTheEpsilonRateIs(int pExpected) {
    assertEquals("Invalid gamma rate", pExpected, mTotals.getEpsilonRate());
  }

  private void thenTheGammaRateIs(int pExpected) {
    assertEquals("Invalid gamma rate", pExpected, mTotals.getGammaRate());
  }

  private void afterCalculating() {
    mTotals = mCalculator.calculate();
  }
  
  private void thenTheGammaBitsAre(String pExpected) {
    assertEquals("Invalid gamma bits", pExpected, mTotals.getGammaAsText());
  }

  private void thenTheEpsilonBitsAre(String pExpected) {
    assertEquals("Invalid epsilon bits", pExpected, mTotals.getEpsilonAsText());
  }
  
  private void thenTheTotalsForZeroShouldBe(int...pExpected) {
    assertEquals("Invalid size", pExpected.length, mTotals.size());
    for (int i = 0; i < pExpected.length; i++) {
      assertEquals("Invalid count", pExpected[i], mTotals.getZeros(i));
    }
  }
  
  private void thenTheTotalsForOneShouldBe(int...pExpected) {
    Totals totals = mCalculator.calculate();
    assertEquals("Invalid size", pExpected.length, totals.size());
    for (int i = 0; i < pExpected.length; i++) {
      assertEquals("Invalid count", pExpected[i], totals.getOnes(i));
    }
  }

  private void givenACalculatorFor(String... pLines) {
    MutableList<Line> lines = Lists.mutable.empty();
    for (String line : pLines) {
      lines.add(new Line(line));
    }
    mCalculator = new Calculator(lines.toImmutable());
  }
}
