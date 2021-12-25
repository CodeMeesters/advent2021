package advent2021.day6;

import org.eclipse.collections.api.factory.Maps;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.MutableMap;

public class Sea {

  private MutableMap<Integer, Cohort> mCohorts = Maps.mutable.empty();
  private int mDay = 0;

  public Sea(ImmutableList<Cohort> pFish) {
    mCohorts = pFish.toMap(Cohort::getInitialTimer, c -> c);
  }

  public Cohort getCohort(int pTimer) {
    return mCohorts.get(pTimer);
  }
  
  public int cohortSize() {
    return mCohorts.size();
  }
  
  public long getNumberOfFish() {
    return mCohorts.sumOfLong(Cohort::getCount);
  }
  
  public void nextDay() {
    mDay++;
    Cohort reproducing = mCohorts.get(0);
    Cohort newFish = reproduce(reproducing);
    shiftAllCohorts();
    mCohorts.put(8, newFish);
    mCohorts.get(6).add(reproducing);
  }

  private void shiftAllCohorts() {
    for (int timer = 1; timer < 10; timer++) {
      mCohorts.put(timer-1, mCohorts.get(timer));
    }
  }
  
  private Cohort reproduce(Cohort pCohort) {
    return new Cohort(9, pCohort.getCount());
  }

  public void gotoDay(int pDay) {
    while (mDay < pDay) {
      nextDay();
    }
  }
  
  public int getDay() {
    return mDay;
  }
}
