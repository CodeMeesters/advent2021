package advent2021.day4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.Test;

public class TestReader {

  private Reader mReader;

  @Test
  public void test() throws FileNotFoundException {
    givenAReader();
    whenReading("src/test/java/advent2021/day4/testdata.txt");
    thenTheReaderShouldHave27Draws();
    thenTheFirstDrawShouldBe(7);
    thenTheLastDrawShouldBe(1);
    thenTheReaderShouldHaveThreeBoards();
    thenBoard2ShouldHave(new int[][] { 
      { 3, 15, 0, 2, 22 }, 
      { 9, 18, 13, 17, 5 }, 
      { 19, 8, 7, 25, 23 }, 
      { 20, 11, 10, 24, 4 },
      { 14, 21, 16, 12, 6 } });
  }

  private void thenBoard2ShouldHave(int[][] pBoard) {
    Board board = mReader.getBoards().get(1);
    for (int row = 0; row < 5; row++) {
      assertTrue("Invalid row", Arrays.equals(pBoard[row], board.getRow(row)));
    }
  }

  private void thenTheReaderShouldHaveThreeBoards() {
    assertEquals("Invalid number of boards", 3, mReader.getBoards().size());
  }

  private void thenTheLastDrawShouldBe(int pExpected) {
    assertEquals("Invalid draw", pExpected, mReader.getDraws().getLast().intValue());
  }

  private void thenTheFirstDrawShouldBe(int pExpected) {
    assertEquals("Invalid draw", pExpected, mReader.getDraws().getFirst().intValue());
  }

  private void thenTheReaderShouldHave27Draws() {
    assertEquals("Invalid number of items", 27, mReader.getDraws().size());
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
