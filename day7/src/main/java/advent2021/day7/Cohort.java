package advent2021.day7;

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
    return (long)Math.abs(pPosition - mPosition) * mCount;
  }
  
  @Override
  public String toString() {
    return "#" + mCount + " @ " + mPosition;
  }
}
