package advent2021.day8;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.list.ImmutableList;

public class Line {

  private ImmutableList<String> mDigits;
  private ImmutableList<String> mCodes;

  public Line(ImmutableList<String> pCodes, ImmutableList<String> pDigits) {
    mCodes = pCodes;
    mDigits = pDigits;
  }

  public boolean hasDigit(String pValue) {
    return mDigits.contains(pValue);
  }

  public boolean hasCode(String pValue) {
    return mCodes.contains(pValue);
  }

  public ImmutableList<String> getCodes() {
    return mCodes;
  }
  
  public ImmutableList<String> getDigits() {
    return mDigits;
  }

  public RichIterable<String> getCodeForLength(int pLength) {
    return mCodes.select(c -> c.length() == pLength);
  }

}
