package advent2021.day7;

import org.eclipse.collections.api.list.ImmutableList;

public class Calculator {

  private ImmutableList<Cohort> mCohorts;

  public Calculator(ImmutableList<Cohort> pCohorts) {
    mCohorts = pCohorts;
  }
  
  public long calculateFuelCosts(int pPosition) {
   return mCohorts.sumOfLong(c -> c.fuelCosts(pPosition));
  }
  
}
