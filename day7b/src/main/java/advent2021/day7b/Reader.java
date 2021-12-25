package advent2021.day7b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.Maps;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;

public class Reader {

  private MutableMap<Integer, Cohort> mCohorts = Maps.mutable.empty();
   
  public Reader() {
    super();
  }

  public ImmutableList<Cohort> getCohorts() {
    return Lists.immutable.withAll(mCohorts.valuesView());
  }
  
  public int getMin() {
    return mCohorts.valuesView().minBy(c -> c.getPosition()).getPosition();
  }

  public int getMax() {
    return mCohorts.valuesView().maxBy(c -> c.getPosition()).getPosition();
  }
  
  public void read(String pFile) throws FileNotFoundException {
    Scanner s = new Scanner(new BufferedReader(new FileReader(pFile)));
    s.useDelimiter(",");
    try {
      while (s.hasNextInt()) {
        int position = s.nextInt();
        Cohort cohort = mCohorts.getIfAbsentPut(position, new Cohort(position));
        cohort.add();
      }
    }
    finally {
      s.close();
    }
  }
}
