package advent2021.day4;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.MutableList;

public class BingoMaster {

  private ListIterable<Board> mBoards;
  private ListIterable<Integer> mDraws;

  public BingoMaster(ListIterable<Board> pBoards, ListIterable<Integer> pDraws) {
    mBoards = pBoards;
    mDraws = pDraws;
  }
  
  public void draw() {
    for (int draw : mDraws) {
      MutableList<Board> finished = Lists.mutable.empty();
      for (Board board : mBoards) {
        board.setDrawn(draw);
        if (board.isFinished()) {
          finished.add(board);
        }
      }
      if (!finished.isEmpty()) {
        for (Board board : finished) {
          System.out.println(board.getScore());
        }
        break;
      }
    }
  }

}
