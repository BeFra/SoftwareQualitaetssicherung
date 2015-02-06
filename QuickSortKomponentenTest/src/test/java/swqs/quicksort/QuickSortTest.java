package swqs.quicksort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {

	private Quicksort<Integer> intSorter; 
	
	/* 1. Phase Setup */
	@Before
	public void createIntSorter() throws Exception {
		intSorter = Quicksort.createIntSorter();
	}
	
	// 4. Phase Teardown
    @After
    public void tearDown() throws Exception {
        intSorter = null;
    }
	
	
	@Test
	public void sortIntArray() {
		// 2. Phase Exercise
		Integer[] values = new Integer[] {5, 6, 3};
		intSorter.sort(values);
		
		// 3. Phase Verify
		//assertArrayEquals(expectedArray, values);
		asserArrayIsSorted(values);
	}

	private void asserArrayIsSorted(Integer[] values) {
		for(int i = 1; i< values.length; i++) {
			assertTrue(values[i - 1] <= values[i]);
		}
	}
	
	//Fertig sortiertes Feld
	@Test
	public void sortIntArrayFast() {
		Integer[] values = new Integer[] {5, 2, 8, 1, 4};
		intSorter.setSlowIntegerSort(false);
		intSorter.sort(values);
		
		asserArrayIsSorted(values);
	}
	
	//Fertig sortiertes Feld
	@Test
	public void arrayWithDuplicates() {
		Integer[] values = new Integer[] {7, 5, 3, 5};
		intSorter.setSlowIntegerSort(false);
		intSorter.sort(values);
		
		asserArrayIsSorted(values);
	}
	
	@Test(expected = NullPointerException.class) 
	public void emptyArray() {
		intSorter.sort(null);
	}


}
