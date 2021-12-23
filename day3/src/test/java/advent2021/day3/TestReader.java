package advent2021.day3;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class TestReader {

  private Reader mReader;

  @Test
  public void test() throws FileNotFoundException {
    givenAReader();
    whenReading("src/test/java/advent2021/day3/testdata.txt");
    thenTheReaderShouldHaveTwelveLines();
    thenTheNthItemShouldBe(0, "00100");
    thenTheNthItemShouldBe(5, "01111");
    thenTheNthItemShouldBe(11, "01010");
  }

  private void thenTheNthItemShouldBe(int pIndex, String pExpected) {
    Line line = mReader.getItems().get(pIndex);
    assertEquals("Invalid bitset", pExpected, line.toString());
  }

  private void thenTheReaderShouldHaveTwelveLines() {
    assertEquals("Invalid number of items", 12, mReader.getItems().size());
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
