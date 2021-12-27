package advent2021.day11;

import java.awt.Point;
import java.util.function.Consumer;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;

public class Octopus {

  private int mLevel;
  private MutableList<Consumer<Octopus>> mOnFlash = Lists.mutable.empty();
  private int mNumberOfFlashes = 0;
  private Point mLocation;

  public Octopus(Point pLocation, int pLevel) {
    mLevel = pLevel;
    mLocation = pLocation;
  }

  public void step() {
    mLevel++;
  }
  
  private void flash() {
    mOnFlash.forEach(a -> a.accept(this));
    mNumberOfFlashes++;
  }
  
  public Point getLocation() {
    return mLocation;
  }
  
  public void neighbourFlashed(Octopus pNeighbour) {    
    if (mLevel != 0) { // only once per step
      mLevel++;
    }
  }
  
  public boolean checkLevel() {
    if (mLevel > 9) {
      flash();
      mLevel = 0;
      return true;
    }
    return false;
  }

  public int getLevel() {
    return mLevel;
  }

  public void addOnFlash(Consumer<Octopus> pOnFlash) {
    mOnFlash.add(pOnFlash);
  }

  public int getNumberOfFlashes() {
    return mNumberOfFlashes ;
  }
  
  @Override
  public String toString() {
    return mLocation.x + ", " + mLocation.y + " : " + mLevel;
  }

}
