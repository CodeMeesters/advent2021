package advent2021.day8;

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
    String codePart = pLine.substring(0, pLine.indexOf("|")-1);
    String digitPart = pLine.substring(pLine.indexOf("|")+1);
    return new Line(parsePart(codePart), parsePart(digitPart));
  }

  private ImmutableList<String> parsePart(String pPart) {
    MutableList<String> digits = Lists.mutable.empty(); 
    Scanner s = new Scanner(pPart);
    while (s.hasNext()) {
      digits.add(s.next());
    }
    s.close();
    return digits.toImmutable();
  }
}