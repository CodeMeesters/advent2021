package advent2021.day1;

import org.eclipse.collections.api.RichIterable;

public class IncreaseCounter {

  private RichIterable<Integer> mItems;

  public IncreaseCounter(RichIterable<Integer> pItems) {
    mItems = pItems;
  }

  public int count() {
    int result = 0;
    int previousValue = Integer.MAX_VALUE;
    for (int value : mItems) {
      if (value > previousValue) {
        result++;
      }
      previousValue = value;
    }
    return result;
  }
}
