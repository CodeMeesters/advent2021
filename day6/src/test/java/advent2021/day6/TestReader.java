package advent2021.day6;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class TestReader {

  private Reader mReader;

  @Test
  public void test() throws FileNotFoundException {
    givenAReader();
    whenReading("src/test/java/advent2021/day6/testdata.txt");
    thenTheReaderShouldHave10Cohorts();
    thenCohortWithNumberShouldHaveCountOf(0, 0);
    thenCohortWithNumberShouldHaveCountOf(1, 1);
    thenCohortWithNumberShouldHaveCountOf(3, 2);
    thenCohortWithNumberShouldHaveCountOf(4, 1);
    thenCohortWithNumberShouldHaveCountOf(9, 0);
  }
  
  private void thenCohortWithNumberShouldHaveCountOf(int pTimer, int pExpected) {
    Cohort cohort = mReader.getCohorts().detect(c -> c.getInitialTimer() == pTimer);
    assertEquals("Invalid number", pExpected, cohort.getCount());
  }

  private void thenTheReaderShouldHave10Cohorts() {
    assertEquals("Invalid number of lines", 10, mReader.getCohorts().size());
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

