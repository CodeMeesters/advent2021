package advent2021.day6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCohort {

  private Cohort mCohort;
  private Cohort mNewCohort;

  @Test
  public void addCohorts()  {
    givenACohortOfSize(3);
    givenANewCohortOfSize(10);
    afterAdding();
    thenTheCohortShouldHaveSize(13);
  }
  
  private void afterAdding() {
    mCohort.add(mNewCohort);
  }

  private void thenTheCohortShouldHaveSize(int pExpected) {
    assertEquals("Invalid size", pExpected, mCohort.getCount());
  }

  private void givenANewCohortOfSize(int pSize) {
    mNewCohort = createCohort(0, pSize);
  }

  private void givenACohortOfSize(int pSize) {
    mCohort = createCohort(0, pSize);
  }

  private Cohort createCohort(int pInitialTimer, int pSize) {
    Cohort result = new Cohort(pInitialTimer);
    for (int i = 0; i < pSize; i++) {
      result.add();
    }  
    return result;
  }
  
  
}
