package advent2021.day1b;

import static org.junit.Assert.assertEquals;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Test;

public class TestIncreaseCounter {

  private IncreaseCounter mCounter;

  @Test
  public void example() {
    whenChecking(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);
    thenTheCountShouldBe(5);
    thenTheThreeValuesShouldBe(607, 618, 618, 617, 647, 716, 769, 792);
  }

  private void thenTheThreeValuesShouldBe(int...pValues) {
    assertEquals("Invalid number of items", pValues.length, mCounter.getSums().size());
    for (int i = 0; i < pValues.length; i++) {
      int expected = pValues[i];
      assertEquals("Invalid sum", expected, mCounter.getSums().get(i).intValue());
    }
  }

  private void thenTheCountShouldBe(int pExpected) {
    assertEquals("Invalid increase", pExpected, mCounter.count());
  }

  private void whenChecking(int... pValues) {
    MutableList<Integer> values = Lists.mutable.empty();
    for (int value : pValues) {
      values.add(value);
    }
    mCounter = new IncreaseCounter(values.toImmutable());
  }
}
