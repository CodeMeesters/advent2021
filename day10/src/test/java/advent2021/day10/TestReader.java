package advent2021.day10;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class TestReader {

  private Reader mReader;

  @Test
  public void test() throws FileNotFoundException {
    givenAReader();
    whenReading("src/test/java/advent2021/day10/testdata.txt");
    thenTheReaderShouldHave10Lines();
    thenLine3ShouldContain("{([(<{}[<>[]}>{[]{[(<()>");
  }
  
  private void thenLine3ShouldContain(String pExpected) {
    assertEquals(pExpected, mReader.getLines().get(2));
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

