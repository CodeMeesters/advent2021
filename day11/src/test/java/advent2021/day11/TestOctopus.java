package advent2021.day11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

public class TestOctopus {
  
  private Octopus mOctopus;
  private boolean mFlashed = false;

  @Test
  public void noNeighbours() {
    givenAnOctopus(4);
    whenStepping(3);
    theOctopusShouldNotHaveFlashed();
    whenStepping(6);
    thenTheLevelShouldBe(3);
    theOctopusShouldHaveFlashed();
  }
  
  @Test
  public void flashingNeighbours() {
    givenAnOctopus(4);
    thenTheNumberOfFlashesShouldBe(0);
    whenStepping(3);
    theOctopusShouldNotHaveFlashed();
    whenTheNeighbourFlashes(2);
    theOctopusShouldNotHaveFlashed();
    whenTheNeighbourFlashes(1);
    theOctopusShouldHaveFlashed();
    thenTheNumberOfFlashesShouldBe(1);
    thenTheLevelShouldBe(0);
    whenStepping(4);
    thenTheLevelShouldBe(4);
    whenTheNeighbourFlashes(8);
    thenTheLevelShouldBe(0);
    thenTheNumberOfFlashesShouldBe(2);
  }

  private void thenTheNumberOfFlashesShouldBe(int pExpected) {
    assertEquals(pExpected, mOctopus.getNumberOfFlashes());
  }

  private void whenTheNeighbourFlashes(int pTimes) {
    for (int i = 0; i < pTimes; i++) {
      mOctopus.neighbourFlashed(null);
      mOctopus.checkLevel();
    }
  }

  private void theOctopusShouldHaveFlashed() {
    assertTrue(mFlashed);
  }

  private void theOctopusShouldNotHaveFlashed() {
    assertFalse(mFlashed);
  }

  private void thenTheLevelShouldBe(int pExpected) {
    assertEquals(pExpected, mOctopus.getLevel());
  }

  private void whenStepping(int pCount) {
    for (int i = 0; i < pCount; i++) {
      mOctopus.step();
      mOctopus.checkLevel();
    }
  }

  private void givenAnOctopus(int pLevel) {
    mOctopus = new Octopus(new Point(0, 0), pLevel);
    mOctopus.addOnFlash(this::onFlash);
  }
  
  private void onFlash(Octopus pOctopus) {
    mFlashed  = true;
  }

}
