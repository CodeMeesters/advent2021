package advent2021.day10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

public class Reader {

  private MutableList<String> mLines = Lists.mutable.empty();
   
  public Reader() {
    super();
  }

  public void read(String pFile) throws FileNotFoundException {
    Scanner s = new Scanner(new BufferedReader(new FileReader(pFile)));
    try {
      while (s.hasNextLine()) {
        String line = s.nextLine();
        mLines.add(line);
      }
    }
    finally {
      s.close();
    }
  }
  
  public ImmutableList<String> getLines() {
    return mLines.toImmutable();
  }
}