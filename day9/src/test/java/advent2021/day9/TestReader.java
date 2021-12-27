package advent2021.day9;

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
    whenReading("src/test/java/advent2021/day9/testdata.txt");
    thenTheReaderShouldHave5Lines();
    thenLine3ShouldContainInts(9,8,5,6,7,8,9,8,9,2);
  }
  
  private void thenLine3ShouldContainInts(int...pValues) {
    mReader.getLines().get(2);
  }

  private void thenTheReaderShouldHave5Lines() {
    assertEquals("Invalid number of lines", 5, mReader.getLines().size());
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

