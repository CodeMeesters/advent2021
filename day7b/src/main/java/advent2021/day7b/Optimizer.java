package advent2021.day7b;

public class Optimizer {
  
  private int mMin;
  private int mMax;
  private Calculator mCalculator;

  public Optimizer(int pMin, int pMax, Calculator pCalculator) {
    mMin = pMin;
    mMax = pMax;
    mCalculator = pCalculator;
  }

  public int findMinimum() {
    int result = -1;
    long min = Long.MAX_VALUE;;
    for (int position = mMin; position <= mMax; position++) {
      long fuelCosts = mCalculator.calculateFuelCosts(position);
      if (fuelCosts < min) {
        min = fuelCosts;
        result = position;
      }
      else {
        break;
      }
    }
    return result;
  }
}
