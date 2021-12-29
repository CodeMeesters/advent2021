package advent2021.day12;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class TestReader {

  private Reader mReader;

  @Test
  public void test1() throws FileNotFoundException {
    givenAReader();
    whenReading("src/test/java/advent2021/day12/testdata1.txt");
    thenTheReaderShouldHave7Lines();
    thenLine3ShouldContainNodes("A", "c");
  }
  
  @Test
  public void test2() throws FileNotFoundException {
    givenAReader();
    whenReading("src/test/java/advent2021/day12/testdata2.txt");
    thenTheReaderShouldHave10Lines();
    thenLine3ShouldContainNodes("start", "kj");
  }

  
  private void thenLine3ShouldContainNodes(String...pNodes) {
    mReader.getLines().get(2);
  }

  private void thenTheReaderShouldHave7Lines() {
    assertEquals("Invalid number of lines", 7, mReader.getLines().size());
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

