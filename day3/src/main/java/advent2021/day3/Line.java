package advent2021.day3;

public class Line {

  private String mBits;

  public Line(String pBits) {
    mBits = pBits;
  }

  @Override
  public String toString() {
    return mBits;
  }

  public int size() {
    return mBits.length();
  }

  public boolean isOne(int pIndex) {
    return mBits.charAt(pIndex) == '1';
  }
  
  public boolean isZero(int pIndex) {
    return mBits.charAt(pIndex) == '0';
  }
}
