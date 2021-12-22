package advent2021.day1b;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

public class IncreaseCounter {

  private ImmutableList<Integer> mItems;
  private MutableList<Integer> mSums = Lists.mutable.empty();

  public IncreaseCounter(ImmutableList<Integer> pItems) {
    mItems = pItems;
  }
  
  public ImmutableList<Integer> getSums() {
    return mSums.toImmutable();
  }

  public int count() {
    int result = 0;
    int previousValue = Integer.MAX_VALUE;
    for (int index = 0; index < mItems.size()-2; index++) {
      int value = mItems.subList(index, index+3).reduce(Integer::sum).orElseThrow();
      mSums.add(value);
      if (value > previousValue) {
        result++;
      }
      previousValue = value;
    }
    return result;
  }
}
