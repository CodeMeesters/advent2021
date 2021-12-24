package advent2021.day5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;

public class TestLine {

  private Line mLine;

  @Test
  public void horizontal() throws FileNotFoundException {
    givenALine(12, 2, 3, 2);
    thenTheLineIsHorizontal();
  }
  
  @Test
  public void vertical() throws FileNotFoundException {
    givenALine(3, 2, 3, 10);
    thenTheLineIsVertical();
  }
  
  @Test
  public void other() throws FileNotFoundException {
    givenALine(3, 2, 41, 10);
    thenTheLineIsNotHorizontal();
    thenTheLineIsNotVertical();
  }

  private void thenTheLineIsNotVertical() {
    assertFalse("Invalid vert", mLine.isVertical());
  }

  private void thenTheLineIsNotHorizontal() {
    assertFalse("Invalid horiz", mLine.isHorizontal());
  }

  private void thenTheLineIsVertical() {
    assertTrue("Invalid vert", mLine.isVertical());
  }

  private void thenTheLineIsHorizontal() {
    assertTrue("Invalid horiz", mLine.isHorizontal());
  }

  private void givenALine(int pX1, int pY1, int pX2, int pY2) {
    mLine = new Line(pX1, pY1, pX2, pY2);
  }
}
