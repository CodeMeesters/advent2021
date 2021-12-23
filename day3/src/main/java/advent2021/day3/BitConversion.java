package advent2021.day3;

import org.eclipse.collections.api.list.ImmutableList;

public class BitConversion {
  
  private BitConversion() {
    super();
  }

  public static String format(ImmutableList<Boolean> pBits) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < pBits.size(); i++) {
      if (pBits.get(i).booleanValue()) { 
        sb.append("1");
      }
      else {
        sb.append("0");
      }
    }
    return sb.toString();
  }
  
  public static int asInt(ImmutableList<Boolean> pBits) {
    return Integer.parseInt(format(pBits),2); 
  }

}
