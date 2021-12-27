package advent2021.day11;

import java.awt.Point;
import java.util.Optional;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.impl.factory.primitive.IntLists;

public class Simulator {

  private ImmutableList<Octopus> mOctopuses;
  private int mHeight;
  private int mWidth;
  private int mSteps;
  
  public Simulator(ImmutableList<IntList> pLines) {
    mWidth = pLines.get(0).size();
    mHeight = pLines.size();
    mOctopuses = createOctopuses(pLines);
    connectOctopuses();
  }

  public ImmutableIntList getLevelsForRow(int pIndex) {
    return IntLists.immutable.withAll(mOctopuses.select(o -> o.getLocation().y == pIndex).collect(Octopus::getLevel));
  }
  
  public int getSteps() {
    return mSteps;
  }

  private Optional<Octopus> getOctopus(int pCol, int pRow) {
    Point location = new Point(pCol, pRow);
    return mOctopuses.detectOptional(o -> o.getLocation().equals(location));
  }
  
  private ImmutableList<Octopus> createOctopuses(ImmutableList<IntList> pLines) {
    MutableList<Octopus> result = Lists.mutable.empty();
    for (int y = 0; y < pLines.size(); y++) {
      IntList row = pLines.get(y);
      for (int x = 0; x < row.size(); x++) {
        result.add(new Octopus(new Point(x, y), row.get(x)));
      }
    }
    return result.toImmutable();
  }
  
  private void connectOctopuses() {
    for (int row = 0; row < mHeight; row++) {
      for (int col = 0; col < mWidth; col++) {
        Octopus target = getOctopus(col, row).orElseThrow();
        getOctopus(col-1, row-1).ifPresent(o -> target.addOnFlash(o::neighbourFlashed));
        getOctopus(col, row-1).ifPresent(o -> target.addOnFlash(o::neighbourFlashed));
        getOctopus(col+1, row-1).ifPresent(o -> target.addOnFlash(o::neighbourFlashed));
        getOctopus(col-1, row).ifPresent(o -> target.addOnFlash(o::neighbourFlashed));
        getOctopus(col+1, row).ifPresent(o -> target.addOnFlash(o::neighbourFlashed));
        getOctopus(col-1, row+1).ifPresent(o -> target.addOnFlash(o::neighbourFlashed));
        getOctopus(col, row+1).ifPresent(o -> target.addOnFlash(o::neighbourFlashed));
        getOctopus(col+1, row+1).ifPresent(o -> target.addOnFlash(o::neighbourFlashed));
      }
    }
  }

  public void step() {
    mOctopuses.forEach(Octopus::step);
    // while someone is lightning a neighbour, keep on running and checking
    boolean allFaded = false;
    while (!allFaded) {
      allFaded = true;
      for (Octopus octopus : mOctopuses) {
        if (octopus.checkLevel()) {
          allFaded = false;
        }
      }
    }
    mSteps++;
  }

  public long getNumberOfFlashes() {
    return mOctopuses.sumOfInt(Octopus::getNumberOfFlashes);
  }

  public boolean allLevel0() {
    return mOctopuses.allSatisfy(o -> o.getLevel() == 0);
  }

}
