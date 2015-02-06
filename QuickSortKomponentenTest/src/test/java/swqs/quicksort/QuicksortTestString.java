package swqs.quicksort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuicksortTestString {

	String[] expected;
	private Quicksort<String> stringSorter;

	@Before
	public void setUp() throws Exception {
		stringSorter = Quicksort.createTextSorter();
		expected = new String[] { "aa", "bb", "xy" };
	}

	@After
	public void tearDown() throws Exception {
		stringSorter = null;
	}

	@Test
	public void sortStringArray() {
		String[] values = new String[] { "xy", "aa", "bb" };
		stringSorter.sort(values);

		assertArrayEquals(expected, values);
	}

	@Test
	public void sortedStringArray() {
		String[] values = new String[] { "aa", "bb", "xy" };
		stringSorter.sort(values);

		assertArrayEquals(expected, values);
	}

	@Test
	public void sortStringArrayWithDuplicateEntry() {
		String[] values = new String[] { "aa", "bb", "xy", "bb" };
		String[] expected = new String[] { "aa", "bb", "bb", "xy" };
		stringSorter.sort(values);

		assertArrayEquals(expected, values);
	}

}
