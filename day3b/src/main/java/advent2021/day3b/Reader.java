package advent2021.day3b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

public class Reader {

  private MutableList<Line> mItems = Lists.mutable.empty();
  
  public Reader() {
    super();
  }

  public ImmutableList<Line> getItems (){
    return mItems.toImmutable();
  }

  public void read(String pFile) throws FileNotFoundException {
    Scanner s = new Scanner(new BufferedReader(new FileReader(pFile)));
    try {
      while (s.hasNextLine()) {
        String bits = s.next();
        mItems.add(new Line(bits));
      }
    }
    finally {
      s.close();
    }
  }
}
