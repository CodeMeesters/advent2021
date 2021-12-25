package advent2021.day6;

public class Cohort {
  
  private int mInitialTimer;
  private long mCount;

  public Cohort(int pInitialTimer, long pCount) {
    mInitialTimer = pInitialTimer;
    mCount = pCount;
  }
  
  public Cohort(int pInitialTimer) {
    mInitialTimer = pInitialTimer;
    mCount = 0;
  }
  
  public void add(Cohort pOther) {
    mCount = mCount + pOther.getCount();
  }
  
  public void add() {
    mCount++;
  }

  public int getInitialTimer() {
    return mInitialTimer;
  }
  
  public long getCount() {
    return mCount;
  }
  
  @Override
  public String toString() {
    return "#" + mCount;
  }
  
}
