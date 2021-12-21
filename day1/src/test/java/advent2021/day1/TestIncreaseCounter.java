package advent2021.day1;

import static org.junit.Assert.assertEquals;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.junit.Test;

public class TestIncreaseCounter {

	private IncreaseCounter mCounter;

	@Test
	public void noIncrease() {
		whenChecking(100, 90, 70, 23, 12, 12, 1, 0);
		thenTheCountShouldBe(0);
	}
	
	@Test
	public void equalValues() {
		whenChecking(10, 10, 10, 10);
		thenTheCountShouldBe(0);
	}
	
	@Test
	public void example() {
		whenChecking(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);
		thenTheCountShouldBe(7);
	}

	private void thenTheCountShouldBe(int pExpected) {
		assertEquals("Invalid increase", pExpected, mCounter.count());
	}

	private void whenChecking(int... pValues) {
		MutableList<Integer> values = Lists.mutable.empty();
		for (int value : pValues) {
			values.add(value);
		}
		mCounter = new IncreaseCounter(values);
	}
}
