package advent2021.day4b;

import java.util.Iterator;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.MutableList;

public class BingoMaster {

  private ListIterable<Board> mBoards;
  private ListIterable<Integer> mDraws;

  public BingoMaster(ListIterable<Board> pBoards, ListIterable<Integer> pDraws) {
    mBoards = Lists.mutable.withAll(pBoards);
    mDraws = pDraws;
  }
  
  public void draw() {
    for (int draw : mDraws) {
      Iterator<Board> iterator = mBoards.iterator();
      while (iterator.hasNext()) {
        Board board = iterator.next();
        board.setDrawn(draw);
        if (board.isFinished()) {
          if (mBoards.size() == 1) {
            System.out.println(board.getScore());
            break;
          }
          iterator.remove();
        }
      }
    }
  }

}
