package advent2021.day4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;

public class TestBoard {

  private Board mBoard;

  @Test
  public void firstColumn() {
    givenABoardOf(new int[][] { 
      { 3, 15, 0, 2, 22 }, 
      { 9, 18, 13, 17, 5 }, 
      { 19, 8, 7, 25, 23 }, 
      { 20, 11, 10, 24, 4 },
      { 14, 21, 16, 12, 6 } });
    whenDrawing(3, 9, 8, 24, 6);
    thenTheBoardIsNotFinished();
    whenDrawing(19, 20, 14);
    thenTheBoardIsFinished();
  }
  
  @Test
  public void lastColumn() {
    givenABoardOf(new int[][] { 
      { 3, 15, 0, 2, 22 }, 
      { 9, 18, 13, 17, 5 }, 
      { 19, 8, 7, 25, 23 }, 
      { 20, 11, 10, 24, 4 },
      { 14, 21, 16, 12, 6 } });
    whenDrawing(3, 9, 8, 24, 6);
    thenTheBoardIsNotFinished();
    whenDrawing(22, 5, 23, 4);
    thenTheBoardIsFinished();
  }

  @Test
  public void firstRow() {
    givenABoardOf(new int[][] { 
      { 3, 15, 0, 2, 22 }, 
      { 9, 18, 13, 17, 5 }, 
      { 19, 8, 7, 25, 23 }, 
      { 20, 11, 10, 24, 4 },
      { 14, 21, 16, 12, 6 } });
    whenDrawing(3, 9, 8, 24, 6);
    thenTheBoardIsNotFinished();
    whenDrawing(15, 0, 2, 22);
    thenTheBoardIsFinished();
  }
  
  @Test
  public void lastRow() {
    givenABoardOf(new int[][] { 
      { 3, 15, 0, 2, 22 }, 
      { 9, 18, 13, 17, 5 }, 
      { 19, 8, 7, 25, 23 }, 
      { 20, 11, 10, 24, 4 },
      { 14, 21, 16, 12, 6 } });
    whenDrawing(3, 9, 8, 24, 6);
    thenTheBoardIsNotFinished();
    whenDrawing(12, 16, 14, 21);
    thenTheBoardIsFinished();
  }

  @Test
  public void calculateScore() {
    givenABoardOf(new int[][] { 
      { 14, 21, 17, 24, 4 }, 
      { 10, 16, 15, 9, 19 }, 
      { 18, 8, 23, 26, 20 }, 
      { 22, 11, 13, 6, 5 },
      { 2, 0, 12, 3, 7 } });
    whenDrawing(7, 4, 9, 5, 11);
    thenTheBoardIsNotFinished();
    whenDrawing(17, 23, 2, 0, 14, 21);
    thenTheBoardIsNotFinished();
    whenDrawing(24);
    thenTheBoardIsFinished();
    thenTheScoreIs(4512);
  }
  
  private void thenTheScoreIs(int pExpected) {
    assertEquals("Invalid score", pExpected, mBoard.getScore());
  }

  private void thenTheBoardIsFinished() {
    assertTrue("Board should be finished", mBoard.isFinished());
  }
  
  private void thenTheBoardIsNotFinished() {
    assertFalse("Board should not be finished", mBoard.isFinished());
  }

  private void whenDrawing(int...pDraws) {
    for (int draw : pDraws) {
      mBoard.setDrawn(draw);
    }
  }

  private void givenABoardOf(int[][] pBoard) {
    mBoard = new Board();
    for (int r = 0; r < pBoard.length; r++) {
      int[] row = pBoard[r];
      for (int c = 0; c < row.length; c++) {
        mBoard.add(row[c]);
      }
    }
  }
}
