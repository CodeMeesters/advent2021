package advent2021.day8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class TestReader {

  private Reader mReader;

  @Test
  public void test() throws FileNotFoundException {
    givenAReader();
    whenReading("src/test/java/advent2021/day8/testdata.txt");
    thenTheReaderShouldHave10Lines();
    thenLine8ShouldContainDigits("ed", "bcgafe", "cdgba", "cbgef");
    thenLine8ShouldContainCodes("bdfegc", "cbegaf", "gecbf", "adcbefg", "gebcd");
  }
  
  private void thenLine8ShouldContainCodes(String...pValues) {
    Line line = mReader.getLines().get(7);
    for (String value : pValues) {
      assertTrue("Invalid codes", line.hasCode(value));
    }
  }
  
  private void thenLine8ShouldContainDigits(String...pValues) {
    Line line = mReader.getLines().get(7);
    for (String value : pValues) {
      assertTrue("Invalid digits", line.hasDigit(value));
    }
  }

  private void thenTheReaderShouldHave10Lines() {
    assertEquals("Invalid number of lines", 10, mReader.getLines().size());
  }

  private void whenReading(String pFile) throws FileNotFoundException {
    File file = new File(pFile);
    String absolutePath = file.getAbsolutePath();
    mReader.read(absolutePath);
  }

  private void givenAReader() {
    mReader = new Reader();
  }

}

