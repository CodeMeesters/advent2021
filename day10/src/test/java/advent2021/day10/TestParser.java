package advent2021.day10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Test;

import advent2021.day10.Parser.IncompleteError;
import advent2021.day10.Parser.InvalidError;

public class TestParser {

  private MutableList<String> mLines;
  private Parser mParser;

  @Test
  public void parseLine() {
    givenAParser();
    afterParsingLine("[({(<(())[]>[[{[]{<()<>>");
    noInvalidErrorsShouldBePresent();
  }

  @Test
  public void illegalLine() {
    givenAParser();
    afterParsingLine("{([(<{}[<>[]}>{[]{[(<()>");
    closingBracketShouldBeMissing("}");
    
    afterParsingLine("[[<[([]))<([[{}[[()]]]");
    closingBracketShouldBeMissing(")");
    
    afterParsingLine("[<(<(<(<{}))><([]([]()");
    closingBracketShouldBeMissing(")");
    
    afterParsingLine("<{([([[(<>()){}]>(<<{{");
    closingBracketShouldBeMissing(">");    
    
    afterParsingLine("[{[{({}]{}}([{[{{{}}([]");
    closingBracketShouldBeMissing("]");
  }
  
  @Test
  public void incompleteLine() {
    givenAParser();
    
    afterParsingLine("[<>");
    noInvalidErrorsShouldBePresent();
    anIncompleteErrorShouldBePresentFor("]");
    
    afterParsingLine("[({(<(())[]>[[{[]{<()<>>");
    anIncompleteErrorShouldBePresentFor("}}]])})]");
    
    afterParsingLine("[(()[<>])]({[<{<<[]>>(");
    anIncompleteErrorShouldBePresentFor(")}>]})");

    afterParsingLine("(((({<>}<{<{<>}{[]{[]{}");
    anIncompleteErrorShouldBePresentFor("}}>}>))))");
    
    afterParsingLine("{<[[]]>}<{[{[{[]{()[[[]");
    anIncompleteErrorShouldBePresentFor("]]}}]}]}>");
    
    afterParsingLine("<{([{{}}[<[[[<>{}]]]>[]]");
    anIncompleteErrorShouldBePresentFor("])}>");
  }
  
  @Test
  public void calculateScore() {
    givenADataSet();
    givenAParser();
    afterParsingTheDataSet();
    thenTheIllegalTotalShouldBe(26397);
    thenTheIncompleteTotalShouldBe(288957);
  }
  
  private void thenTheIllegalTotalShouldBe(int pExpected) {
    assertEquals(pExpected, mParser.getTotalForIllegal());
  }
  
  private void  thenTheIncompleteTotalShouldBe(int pExpected) {
    assertEquals(pExpected, mParser.getTotalForIncomplete());
  }

  private void afterParsingTheDataSet() {
    for (String line : mLines) {
      mParser.parse(line);
    }
  }

  private void closingBracketShouldBeMissing(String pExpected) {
    assertNotNull(mParser.getError());
    InvalidError error = (InvalidError) mParser.getError();
    assertEquals(pExpected, error.getActual());
  }

  private void noInvalidErrorsShouldBePresent() {
    if (mParser.getError() != null) {
      assertFalse(mParser.getError() instanceof InvalidError);
    }
  }
  
  private void anIncompleteErrorShouldBePresentFor(String pExpected) {
    assertNotNull(mParser.getError());
    assertTrue(mParser.getError() instanceof IncompleteError);
    IncompleteError error = (IncompleteError) mParser.getError();
    assertEquals(pExpected, error.getExpected());
  }

  private void afterParsingLine(String pString) {
    mParser.parse(pString);
  }

  private void givenAParser() {
    mParser = new Parser();
  }

  private void givenADataSet() {
    mLines = Lists.mutable.empty();
    mLines.add("[({(<(())[]>[[{[]{<()<>>");
    mLines.add("[(()[<>])]({[<{<<[]>>(");
    mLines.add("{([(<{}[<>[]}>{[]{[(<()>");
    mLines.add("(((({<>}<{<{<>}{[]{[]{}");
    mLines.add("[[<[([]))<([[{}[[()]]]");
    mLines.add("[{[{({}]{}}([{[{{{}}([]");
    mLines.add("{<[[]]>}<{[{[{[]{()[[[]");
    mLines.add("[<(<(<(<{}))><([]([]()");
    mLines.add("<{([([[(<>()){}]>(<<{{");
    mLines.add("<{([{{}}[<[[[<>{}]]]>[]]");
  }

}
