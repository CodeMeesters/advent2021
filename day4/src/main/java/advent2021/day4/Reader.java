package advent2021.day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.MutableList;

public class Reader {

  private MutableList<Board> mBoards = Lists.mutable.empty();
  private MutableList<Integer> mDraws = Lists.mutable.empty();
   
  public Reader() {
    super();
  }

  public ListIterable<Board> getBoards() {
    return mBoards.toImmutable();
  }
  
  public ListIterable<Integer> getDraws() {
    return mDraws.toImmutable();
  }

  public void read(String pFile) throws FileNotFoundException {
    Scanner s = new Scanner(new BufferedReader(new FileReader(pFile)));
    try {
      if (s.hasNextLine()) {
        mDraws = parseDraws(s.next());
      }
      while (s.hasNextInt()) {
        mBoards.add(readBoard(s));
      }
    }
    finally {
      s.close();
    }
  }

  private Board readBoard(Scanner pScanner) {
    Board board = new Board();
    for (int i = 0; i < 25; i++) {
      board.add(pScanner.nextInt());
    }
    return board;
  }

  private MutableList<Integer> parseDraws(String pLine) {
    MutableList<String> draws = Lists.mutable.with(pLine.split(","));
    return draws.collect(Integer::parseInt);
  }

}
