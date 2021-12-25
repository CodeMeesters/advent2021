package advent2021.day6;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.Maps;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.junit.Test;

public class TestSea {
  
  private Sea mSea;

  @Test
  public void testSea() {
    givenASeaWith(cohort(3, 2), cohort(4, 1), cohort(1, 1), cohort(2, 1));
    thenTheSeaHasNFish(5);
    thenTheSeaShouldBe(3, 4, 3, 1, 2);
    afterADay();
    thenTheSeaShouldBe(2, 3, 2, 0, 1);
    afterMovingToDay(2);
    thenTheSeaShouldBe(1, 2, 1, 6, 0, 8);
    afterMovingToDay(6);
    thenTheDayShouldBe(6);
    thenTheSeaShouldBe(4, 5, 4, 2, 3, 4, 5, 6, 6, 7);
    afterMovingToDay(18);
    thenTheDayShouldBe(18);
    thenTheSeaShouldBe(6, 0, 6, 4, 5, 6, 0, 1, 1, 2, 6, 0, 1, 1, 1, 2, 2, 3, 3, 4, 6, 7, 8, 8, 8, 8);
  }
  
  @Test
  public void test80Days() {
    givenASeaWith(cohort(3, 2), cohort(4, 1), cohort(1, 1), cohort(2, 1));
    afterMovingToDay(80);
    thenTheDayShouldBe(80);
    thenTheSeaHasNFish(5934);
  }
  
  @Test
  public void test256Days() {
    givenASeaWith(cohort(3, 2), cohort(4, 1), cohort(1, 1), cohort(2, 1));
    afterMovingToDay(256);
    thenTheSeaHasNFish(26984457539L);
  }
  
  private Cohort cohort(int pTimer, int pCount) {
    return new Cohort(pTimer, pCount);
  }
  
  private void thenTheDayShouldBe(int pExpected) {
    assertEquals("Invalid day", pExpected, mSea.getDay());
  }

  private void afterMovingToDay(int pDay) {
    mSea.gotoDay(pDay);
  }

  private void afterADay() {
    mSea.nextDay();
  }

  private void thenTheSeaShouldBe(int... pExpected) {    
    thenTheSeaHasNFish(pExpected.length);
    List<Integer> ints = Arrays.stream(pExpected).boxed().collect(Collectors.toList());
    MutableList<Integer> values = Lists.mutable.withAll(ints);
    MutableListMultimap<Integer, Integer> grouped = values.groupBy(v -> v);
    for (int timer = 0; timer < mSea.cohortSize(); timer++) {
      Cohort cohort = mSea.getCohort(timer);
      if (grouped.containsKey(timer)) {
        assertEquals("Invalid size", grouped.get(timer).size(), cohort.getCount());
      }
      else {
        assertEquals("Cohort should be empty", 0, cohort.getCount());
      }
    }
  }

  private void thenTheSeaHasNFish(long pExpected) {
    assertEquals("Invalid number of fish", pExpected, mSea.getNumberOfFish());
  }

  private void givenASeaWith(Cohort...pFish) {
    MutableMap<Integer, Cohort> map = Maps.mutable.empty();
    for (Cohort fishes : pFish) {
      map.put(fishes.getInitialTimer(), fishes);
    }
    // add rest
    for (int i = 0; i < 10; i++) {
      map.putIfAbsent(i, new Cohort(i));
    }
    mSea = new Sea(Lists.immutable.withAll(map.valuesView()));
  }

}
