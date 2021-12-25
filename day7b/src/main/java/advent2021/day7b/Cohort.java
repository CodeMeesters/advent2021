package advent2021.day7b;

public class Cohort {
  
  private int mCount;
  private int mPosition;

  public Cohort(int pPosition) {
    mCount = 0;
    mPosition = pPosition;
  }
  
  public Cohort(int pPosition, int pCount) {
    mCount = pCount;
    mPosition = pPosition;
  }
  
  public void add() {
    mCount++;
  }
  
  public int getPosition() {
    return mPosition;
  }

  public long getCount() {
    return mCount;
  }
  
  public long fuelCosts(int pPosition) {
    int delta = Math.abs(pPosition - mPosition);
    int costs = 0;
    int stepCosts = 1;
    for (int step = 0; step < delta; step++) {
      costs = costs + stepCosts;
      stepCosts++;
    }
    return (long)costs * mCount;
  }
  
  @Override
  public String toString() {
    return "#" + mCount + " @ " + mPosition;
  }
}
