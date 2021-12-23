package advent2021.day3b;

import org.eclipse.collections.api.list.ImmutableList;

public class Calculator {

  private ImmutableList<Line> mLines;

  public Calculator(ImmutableList<Line> pLines) {
    super();
    mLines = pLines;
  }
  
  public Totals calculate() {
    int index = 0;
    Line oxygen = getForMostCommonBits(index, mLines).getOnly();
    Line co2 = getForLeastCommonBits(index, mLines).getOnly();
    return new Totals(oxygen, co2);
  }

  private ImmutableList<Line> getForMostCommonBits(final int pIndex, ImmutableList<Line> pLines) {
    if (pLines.size() == 1) {
      return pLines;
    }
    int zeroCount = getZeroCount(pLines, pIndex);
    int oneCount = getOneCount(pLines, pIndex);
    if (zeroCount > oneCount) {
      ImmutableList<Line> remaining = pLines.select(line -> line.isZero(pIndex));
      return getForMostCommonBits(pIndex+1, remaining);
    }
    ImmutableList<Line> remaining = pLines.select(line -> line.isOne(pIndex));
    return getForMostCommonBits(pIndex+1, remaining);
  }
  
  private ImmutableList<Line> getForLeastCommonBits(final int pIndex, ImmutableList<Line> pLines) {
    if (pLines.size() == 1) {
      return pLines;
    }
    int zeroCount = getZeroCount(pLines, pIndex);
    int oneCount = getOneCount(pLines, pIndex);
    if (oneCount < zeroCount) {
      ImmutableList<Line> remaining = pLines.select(line -> line.isOne(pIndex));
      return getForLeastCommonBits(pIndex+1, remaining);
    }
    ImmutableList<Line> remaining = pLines.select(line -> line.isZero(pIndex));
    return getForLeastCommonBits(pIndex+1, remaining);
  }
  
  private int getZeroCount(ImmutableList<Line> pLines, int pIndex) {
    return pLines.select(line -> line.isZero(pIndex)).size();
  }
  
  private int getOneCount(ImmutableList<Line> pLines, int pIndex) {
    return pLines.select(line -> line.isOne (pIndex)).size();
  }

  public static class Totals {

    private Line mOxygen;
    private Line mCO2;

    public Totals(Line pOxygen, Line pCO2) {
      mOxygen = pOxygen;
      mCO2 = pCO2;
    }

    public String getCO2RatingAsText() {
      return mCO2.toString();
    }
    
    public String getOxygenRatingAsText() {
      return mOxygen.toString();
    }

    public int getLifeSupportRating() {
      return getCO2Rating() * getOxygenRating();
    }

    public int getCO2Rating() {
      return Integer.parseInt(mCO2.toString(), 2);
    }

    public int getOxygenRating() {
      return Integer.parseInt(mOxygen.toString(), 2);
    }
  }
}
