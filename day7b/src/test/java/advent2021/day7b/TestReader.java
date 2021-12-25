package advent2021.day7b;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class TestReader {

  private Reader mReader;

  @Test
  public void test() throws FileNotFoundException {
    givenAReader();
    whenReading("src/test/java/advent2021/day7b/testdata.txt");
    thenTheReaderShouldHave7Cohorts();
    thenCohortWithNumberShouldHaveCountOf(0, 1);
    thenCohortWithNumberShouldHaveCountOf(1, 2);
    thenCohortWithNumberShouldHaveCountOf(2, 3);
    thenCohortWithNumberShouldHaveCountOf(16, 1);
    thenCohortWithNumberShouldHaveCountOf(14, 1);
    thenMinMaxValuesAre(0, 16);
  }
  
  private void thenMinMaxValuesAre(int pMin, int pMax) {
    assertEquals("Invald min", pMin, mReader.getMin());
    assertEquals("Invald max", pMax, mReader.getMax());
  }

  private void thenCohortWithNumberShouldHaveCountOf(int pPosition, int pExpected) {
    Cohort cohort = mReader.getCohorts().detect(c -> c.getPosition() == pPosition);
    assertEquals("Invalid number", pExpected, cohort.getCount());
  }

  private void thenTheReaderShouldHave7Cohorts() {
    assertEquals("Invalid number of lines", 7, mReader.getCohorts().size());
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

