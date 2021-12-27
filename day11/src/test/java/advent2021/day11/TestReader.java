package advent2021.day11;

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
    whenReading("src/test/java/advent2021/day11/testdata.txt");
    thenTheReaderShouldHave10Lines();
    thenLine3ShouldContainInts(5,2,6,4,5,5,6,1,7,3);
  }
  
  private void thenLine3ShouldContainInts(int...pValues) {
    mReader.getLines().get(2);
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

