package advent2021.day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

public class Reader {

  private MutableList<Cohort> mCohorts = Lists.mutable.empty();
   
  public Reader() {
    super();
    for (int i = 0; i < 10; i++) {
      mCohorts.add(new Cohort(i));
    }
  }

  public ImmutableList<Cohort> getCohorts() {
    return mCohorts.toImmutable();
  }

  public void read(String pFile) throws FileNotFoundException {
    Scanner s = new Scanner(new BufferedReader(new FileReader(pFile)));
    s.useDelimiter(",");
    try {
      while (s.hasNextInt()) {
        int timer = s.nextInt();
        mCohorts.get(timer).add();
      }
    }
    finally {
      s.close();
    }
  }
}
