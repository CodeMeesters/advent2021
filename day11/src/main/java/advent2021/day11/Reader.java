package advent2021.day11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.impl.factory.primitive.IntLists;

public class Reader {

  private MutableList<IntList> mLines = Lists.mutable.empty();
   
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
  
  public ImmutableList<IntList> getLines() {
    return mLines.toImmutable();
  }

  private IntList parseLine(String pLine) {
    MutableIntList result = IntLists.mutable.empty();
    for (int i = 0; i < pLine.length(); i++) {
      result.add (pLine.charAt(i)-48);
    }
    return result;
  }

}