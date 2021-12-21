package advent2021.day2;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import advent2021.day2.Movement.Direction;

public class TestReader {

  private Reader mReader;

  @Test
  public void test() throws FileNotFoundException {
    givenAReader();
    whenReading("src/test/java/advent2021/day2/testdata.txt");
    thenTheReaderShouldHaveSixLines();
    thenTheNthItemShouldBe(0, Movement.Direction.FORWARD, 5);
    thenTheNthItemShouldBe(4, Movement.Direction.DOWN, 8);
    thenTheNthItemShouldBe(5, Movement.Direction.FORWARD, 2);
  }

  private void thenTheNthItemShouldBe(int pIndex, Direction pExpectedDirection, int pExpectedUnits) {
    Movement movement = mReader.getItems().get(pIndex);
    assertEquals("Invalid direction", pExpectedDirection, movement.getDirection());
    assertEquals("Invalid units", pExpectedUnits, movement.getUnits());
  }

  private void thenTheReaderShouldHaveSixLines() {
    assertEquals("Invalid number of items", 6, mReader.getItems().size());
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
