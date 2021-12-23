package advent2021.day3;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

public class Calculator {

  private ImmutableList<Line> mLines;

  public Calculator(ImmutableList<Line> pLines) {
    super();
    mLines = pLines;
  }
  
  public Totals calculate() {
    Line firstLine = mLines.get(0);
    int[] zeros = new int[firstLine.size()];
    for (Line line : mLines) {
      for (int i = 0; i < line.size(); i++) {
        if (line.isZero(i)) {
          zeros[i] = zeros[i] + 1; 
        }
      }
    }
    Totals result = new Totals(zeros.length);
    int count = mLines.size();
    for (int i = 0; i < zeros.length; i++) {
      result.set(i, zeros[i], count-zeros[i]);
    }
    return result;
  }
  
  public static class Totals {

    private MutableList<Integer> mZeros = Lists.mutable.empty();
    private MutableList<Integer> mOnes = Lists.mutable.empty();
    
    public Totals(int pLength) {
      for (int i = 0; i < pLength; i++) {
        mZeros.add(0);
        mOnes.add(0);
      }
    }

    public void set(int pIndex, int pZeros, int pOnes) {
      mZeros.set(pIndex, pZeros);
      mOnes.set(pIndex, pOnes);
    }

    public int size() {
      return mOnes.size();
    }

    public int getZeros(int pIndex) {
      return mZeros.get(pIndex);
    }
    
    public int getOnes(int pIndex) {
      return mOnes.get(pIndex);
    }
    
    private ImmutableList<Boolean> getGamma() {
      MutableList<Boolean> result = Lists.mutable.empty();
      for (int i = 0; i < size(); i++) {
        result.add(mZeros.get(i) < mOnes.get(i));
      }
      return result.toImmutable();
    }
    
    private ImmutableList<Boolean> getEpsilon() {
      MutableList<Boolean> result = Lists.mutable.empty();
      for (int i = 0; i < size(); i++) {
        result.add(mZeros.get(i) > mOnes.get(i));
      }
      return result.toImmutable();
    }

    public String getEpsilonAsText() {
      return BitConversion.format(getEpsilon());
    }
    
    public String getGammaAsText() {
      return BitConversion.format(getGamma());
    }

    public int getPowerConsumption() {
      return getEpsilonRate() * getGammaRate();
    }

    public int getEpsilonRate() {
      return BitConversion.asInt(getEpsilon());
    }

    public int getGammaRate() {
      return BitConversion.asInt(getGamma());
    }
  }
}
