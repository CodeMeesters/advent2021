package advent2021.day12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

public class Reader {

  private MutableList<Line> mLines = Lists.mutable.empty();
   
  public Reader() {
    super();
  }

  public void read(String pFile) throws FileNotFoundException {
    Scanner s = new Scanner(new BufferedReader(new FileReader(pFile)));
    try {
      while (s.hasNextLine()) {
        String line = s.nextLine();
        mLines.add(parseLine(line));
      }
    }
    finally {
      s.close();
    }
  }
  
  public ImmutableList<Line> getLines() {
    return mLines.toImmutable();
  }

  private Line parseLine(String pLine) {
    String[] nodes = pLine.split("-");
    return new Line(nodes[0], nodes[1]);
  }

}