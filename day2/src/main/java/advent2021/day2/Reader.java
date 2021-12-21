package advent2021.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.Maps;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ImmutableMap;

import advent2021.day2.Movement.Direction;

public class Reader {

  private MutableList<Movement> mItems = Lists.mutable.empty();
  private ImmutableMap<String, Direction> mMap = Maps.immutable.with("forward", Direction.FORWARD, "up", Direction.UP, "down", Direction.DOWN);
  
  public Reader() {
    super();
  }

  public ImmutableList<Movement> getItems (){
    return mItems.toImmutable();
  }

  public void read(String pFile) throws FileNotFoundException {
    Scanner s = new Scanner(new BufferedReader(new FileReader(pFile)));
    while (s.hasNextLine()) {
      Direction direction = mMap.get(s.next());
      int units = s.nextInt(); 
      mItems.add(new Movement(direction, units));
    }
    s.close();
  }

}
