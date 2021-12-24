package advent2021.day5b;

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
    thenTheLineIsNotVertical();
    thenTheLineIsNotDiagonalUp();
    thenTheLineIsNotDiagonalDown();
  }
  
  @Test
  public void vertical() throws FileNotFoundException {
    givenALine(3, 2, 3, 10);
    thenTheLineIsVertical();
    thenTheLineIsNotDiagonalUp();
    thenTheLineIsNotDiagonalDown();
  }
  
  @Test
  public void diagonalUp() throws FileNotFoundException {
    givenALine(9, 7, 7, 9);
    thenTheLineIsNotHorizontal();
    thenTheLineIsNotVertical();
    thenTheLineIsDiagonalUp();
    thenTheLineIsNotDiagonalDown();
    givenALine(7, 9, 9, 7);
    thenTheLineIsNotHorizontal();
    thenTheLineIsNotVertical();
    thenTheLineIsDiagonalUp();
    thenTheLineIsNotDiagonalDown();
  }
  
  @Test
  public void diagonalDown() throws FileNotFoundException {
    givenALine(1, 1, 3, 3);
    thenTheLineIsNotHorizontal();
    thenTheLineIsNotVertical();
    thenTheLineIsDiagonalDown();
    thenTheLineIsNotDiagonalUp();
    givenALine(3, 3, 1, 1);
    thenTheLineIsNotHorizontal();
    thenTheLineIsNotVertical();
    thenTheLineIsDiagonalDown();
    thenTheLineIsNotDiagonalUp();
  }

  private void thenTheLineIsNotDiagonalUp() {
    assertFalse("Invalid dup", mLine.isDiagonalUp());
  }
  
  private void thenTheLineIsNotDiagonalDown() {
    assertFalse("Invalid ddown", mLine.isDiagonalDown());
  }

  private void thenTheLineIsDiagonalDown() {
    assertTrue("Invalid ddown", mLine.isDiagonalDown());
  }

  private void thenTheLineIsDiagonalUp() {
    assertTrue("Invalid dup", mLine.isDiagonalUp());
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
