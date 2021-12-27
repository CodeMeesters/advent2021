package advent2021.day8;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.Sets;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Predicates;

public class Calculator {

  private ImmutableList<Line> mLines;

  public Calculator(ImmutableList<Line> pLines) {
    mLines = pLines;
  }

  public long countNumberOf147() {
    ILineCalculator calculator = new OneFourSevenCalculator();
    return mLines.sumOfInt(l -> calculator.getSum(l));
  }
  
  public long countDigitTotal() {
    ILineCalculator calculator = new DigitCalculator();
    return mLines.sumOfInt(l -> calculator.getSum(l));
  }
  
  public interface ILineCalculator {
    int getSum(Line pLine);
  }
  
  public static class OneFourSevenCalculator implements ILineCalculator {

    @Override
    public int getSum(Line pLine) {
      int result = 0;
      result = result + pLine.getDigits().select(d -> d.length() == 7).size();
      result = result + pLine.getDigits().select(d -> d.length() == 3).size();
      result = result + pLine.getDigits().select(d -> d.length() == 4).size();
      result = result + pLine.getDigits().select(d -> d.length() == 2).size();
      return result;
    }
  }
  
  
  public static class DigitCalculator implements ILineCalculator {

    private MutableSet<String> mA = Sets.mutable.empty();
    private MutableSet<String> mB = Sets.mutable.empty();
    private MutableSet<String> mC = Sets.mutable.empty();
    private MutableSet<String> mD = Sets.mutable.empty();
    private MutableSet<String> mE = Sets.mutable.empty();
    private MutableSet<String> mF = Sets.mutable.empty();
    private MutableSet<String> mG = Sets.mutable.empty();
    
    private MutableSet<String> mZero;
    private MutableSet<String> mOne;
    private MutableSet<String> mTwo;
    private MutableSet<String> mThree;
    private MutableSet<String> mFour;
    private MutableSet<String> mFive;
    private MutableSet<String> mSix;
    private MutableSet<String> mSeven;
    private MutableSet<String> mEight;
    private MutableSet<String> mNine;
    
    @Override
    public int getSum(Line pLine) {
      clearAll();
      
      try {
        assignDigits(pLine);
      }
      catch (Exception e) {
        System.out.println("Error parsing " + pLine);
      }
      
      String digit1 = pLine.getDigits().get(0);
      String digit2 = pLine.getDigits().get(1);
      String digit3 = pLine.getDigits().get(2);
      String digit4 = pLine.getDigits().get(3);
      return convertDigit(digit1) * 1000
          + convertDigit(digit2) * 100
          + convertDigit(digit3) * 10
          + convertDigit(digit4);
    }

    private void clearAll() {
      mA = Sets.mutable.empty();
      mB = Sets.mutable.empty();
      mC = Sets.mutable.empty();
      mD = Sets.mutable.empty();
      mE = Sets.mutable.empty();
      mF = Sets.mutable.empty();
      mG = Sets.mutable.empty();
    }

    private int convertDigit(String pDigit) {
      MutableSet<String> digit = toSet(pDigit);
      if (digit.equals(mZero)) {
        return 0;
      }
      if (digit.equals(mOne)) {
        return 1;
      }
      if (digit.equals(mTwo)) {
        return 2;
      }
      if (digit.equals(mThree)) {
        return 3;
      }
      if (digit.equals(mFour)) {
        return 4;
      }
      if (digit.equals(mFive)) {
        return 5;
      }
      if (digit.equals(mSix)) {
        return 6;
      }
      if (digit.equals(mSeven)) {
        return 7;
      }
      if (digit.equals(mEight)) {
        return 8;
      }
      if (digit.equals(mNine)) {
        return 9;
      }
      return -1;
    }

    private void assignDigits(Line pLine) {
      String cf = pLine.getCodeForLength(2).getOnly();
      mC.addAll(toChars(cf));
      mF.addAll(toChars(cf));
      String bcdf = pLine.getCodeForLength(4).getOnly();
      mB.addAll(toSet(bcdf).reject(Predicates.in(mC)));
      mD.addAll(toSet(bcdf).reject(Predicates.in(mC)));
      String acf = pLine.getCodeForLength(3).getOnly();
      mA.addAll(toSet(acf).reject(Predicates.in(mC)));
      MutableList<MutableSet<String>> for235 = pLine.getCodeForLength(5).collect(this::toSet).toList();
      MutableSet<String> common = findCommon(for235);
      mD = mD.reject(Predicates.notIn(common));
      mB = mB.reject(Predicates.in(mD));
      mG = common.reject(Predicates.in(mA)).reject(Predicates.in(mD));
//      MutableSet<String> for3 = for235.select(set -> mC.allSatisfy(c -> set.contains(c))).getOnly();
//      mG.add(for3.reject(Predicates.in(mC)).reject(Predicates.in(mA)).reject(Predicates.in(mD)).getOnly());
      
      MutableSet<String> for5 = for235.select(set -> set.contains(mB.getOnly())).getOnly();
      
      MutableSet<String> f = for5.reject(Predicates.in(mA)).reject(Predicates.in(mD)).reject(Predicates.in(mG))
          .reject(Predicates.in(mB));
      mF = mF.select(Predicates.in(f));
      mC = mC.reject(Predicates.in(f));
      
      mE = Sets.mutable.with("a", "b", "c", "d", "e", "f", "g").reject(Predicates.in(mA))
          .reject(Predicates.in(mB)).reject(Predicates.in(mC)).reject(Predicates.in(mD)).reject(Predicates.in(mF))
          .reject(Predicates.in(mG));
      
      mZero = createFor(mA, mB, mC, mE, mF, mG);       
      mOne = createFor(mC, mF);
      mTwo = createFor(mA, mC, mD, mE, mG);
      mThree = createFor(mA, mC, mD, mF, mG);
      mFour = createFor(mB, mC, mD, mF);
      mFive = createFor(mA, mB, mD, mF, mG);
      mSix = createFor(mA, mB, mD, mE, mF, mG);
      mSeven = createFor(mA, mC, mF);
      mEight = createFor(mA, mB, mC, mD, mE, mE, mF, mG);
      mNine = createFor(mA, mB, mC, mD, mF, mG);
    }

    private MutableSet<String> createFor(MutableSet<String>...pSegments) {
      return Lists.immutable.with(pSegments).collect(MutableSet::getOnly).toSet();
    }

    private MutableSet<String> findCommon(ListIterable<MutableSet<String>> pSets) {
      return pSets.get(0).reject(Predicates.notIn(pSets.get(1))).reject(Predicates.notIn(pSets.get(2)));
    }

    private MutableSet<String> toSet(String pChars) {
      return Sets.mutable.withAll(toChars(pChars));
    }
    
    private MutableList<String> toChars(String pChars) {
      MutableList<String> result = Lists.mutable.empty();
      for (int i = 0; i < pChars.length(); i++) {
        result.add(pChars.substring(i, i+1));
      }
      return result;
    }
  }
  
}
