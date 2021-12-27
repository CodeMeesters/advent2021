package advent2021.day8;

import static org.junit.Assert.assertEquals;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Test;

import advent2021.day8.Calculator.DigitCalculator;
import advent2021.day8.Calculator.ILineCalculator;
import advent2021.day8.Calculator.OneFourSevenCalculator;

public class TestCalculator {

  private ImmutableList<Line> mLines;

  private long mAmount;

  private ILineCalculator mLineCalculator;

  @Test
  public void occurenceCalculator() {
    givenAnOccurenceCalculator();
    whenCalculatingFor("gbdfcae bgc cg cgb");
    thenTheSumShouldBe(4);
  }

  @Test
  public void lineDigitCalculatorA() {
    givenADigitCalculator();
    whenCalculatingFor("edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec", "fcgedb cgb dgebacf gc");
    thenTheSumShouldBe(9781);
    whenCalculatingFor("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab", "cdfeb fcadb cdfeb cdbaf");
    thenTheSumShouldBe(5353);
  }

  @Test
  public void digitCalculator() {
    givenADataSet();
    whenCalculatingDigits();
    thenTheSumShouldBe(61229);
  }

  @Test
  public void calculate147() {
    givenADataSet();
    whenCalculating();
    theAmountOf147ShouldBe(26);
  }

  private void thenTheSumShouldBe(int pExpected) {
    assertEquals(pExpected, mAmount);
  }

  private void whenCalculatingFor(String pCodes, String pDigits) {
    mAmount = mLineCalculator.getSum(createLine(pCodes, pDigits));
  }

  private Line createLine(String pCodes, String pDigits) {
    return new Line(Lists.immutable.with(pCodes.split(" ")), Lists.immutable.with(pDigits.split(" ")));
  }

  private void whenCalculatingFor(String pString) {
    mAmount = mLineCalculator.getSum(createLine("", pString));
  }

  private void givenAnOccurenceCalculator() {
    mLineCalculator = new OneFourSevenCalculator();
  }

  private void givenADigitCalculator() {
    mLineCalculator = new DigitCalculator();
  }

  private void theAmountOf147ShouldBe(long pExpected) {
    assertEquals("Invalid amout", pExpected, mAmount);
  }

  private void whenCalculating() {
    Calculator calculator = new Calculator(mLines);
    mAmount = calculator.countNumberOf147();
  }

  private void whenCalculatingDigits() {
    Calculator calculator = new Calculator(mLines);
    mAmount = calculator.countDigitTotal();
  }

  private void givenADataSet() {
    MutableList<Line> lines = Lists.mutable.empty();

    lines.add(createLine("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb", "fdgacbe cefdb cefbgd gcbe"));
    lines.add(createLine("edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec", "fcgedb cgb dgebacf gc"));
    lines.add(createLine("fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef", "cg cg fdcagb cbg"));
    lines.add(createLine("fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega", "efabcd cedba gadfec cb"));
    lines.add(createLine("aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga", "gecf egdcabf bgf bfgea"));
    lines.add(createLine("fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf", "gebdcfa ecba ca fadegcb"));
    lines.add(createLine("dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf", "cefg dcbef fcge gbcadfe"));
    lines.add(createLine("bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd", "ed bcgafe cdgba cbgef"));
    lines.add(createLine("egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg", "gbdfcae bgc cg cgb"));
    lines.add(createLine("gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc", "fgae cfgab fg bagce"));

    mLines = lines.toImmutable();
  }
}
