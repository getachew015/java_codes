package extendedLinkedList;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class ExtendedListTest {

	ExtendedList<Double> list ;
	Double[] input1={2.5,1.5,3.5,0.5,4.5,2.4,1.7,0.1,1.6,4.4,1.6,1.4,0.1,1.8,3.2,0.9};

	
	@Test
	public void testCase1() {//test inserting in ascending order
		
		//test sortAscending with duplicates allowed
		list = new ExtendedList<Double>(6, true);
		for (Double nums : input1) {
			list.add(nums);
		}
		Arrays.sort(input1);
		assertArrayEquals(input1, list.toArray());
				
		//test sortAscending with duplicates discarded
		list = new ExtendedList<Double>(6, false);
		Double[] output={0.1,0.5,0.9,1.4,1.5,1.6,1.7,1.8,2.4,2.5,3.2,3.5,4.4,4.5};

		for (Double nums : input1) {
			list.add(nums);
		}
		assertArrayEquals(output, list.toArray());
		
	}
	
	@Test
	public void testCase2(){	//test insert in Descending order
		
			//test sortDscending with duplicates allowed
			list = new ExtendedList<Double>(-3, true);
			for (Double nums : input1) {
				list.add(nums);
			}
			Arrays.sort(input1, Collections.reverseOrder());
			assertArrayEquals(input1, list.toArray());
	
			
			//test sortDscending with duplicates Discarded
			list = new ExtendedList<Double>(-3, false);
			Double[] output= {4.5,4.4,3.5,3.2,2.5,2.4,1.8,1.7,1.6,1.5,1.4,0.9,0.5,0.1};
			for (Double nums : input1) {
				list.add(nums);
			}
			Arrays.sort(input1);
			assertArrayEquals(output, list.toArray());
	
	}
	
	@Test
	public void testCase3(){//test inserts as is with no sort effect
		
	//test insert as is with duplicates allowed
	list = new ExtendedList<Double>(0, true);
	for (Double nums : input1) {
		list.add(nums);
	}
	assertArrayEquals(input1, list.toArray());
	
	
	
	//test insert as is with duplicates discarded
	list = new ExtendedList<Double>(0, false);
	for (Double nums : input1) {
		list.add(nums);
	}
	Double[] output={2.5,1.5,3.5,0.5,4.5,2.4,1.7,0.1,1.6,4.4,1.4,1.8,3.2,0.9};
	assertArrayEquals(output, list.toArray());
	

}
	
	@Test
	public void testCase4(){//test with String input
		
		//test insert sortedAcending with duplicates allowed
		ExtendedList<String> list2 = new ExtendedList<String>(1, true);
		String[] input = {"KK","EE","CC","GG","EE","AA","GG","HH","BB","DD","KK","CC" };
		for (String string : input) {
			list2.add(string);
		}
		Arrays.sort(input);
		assertArrayEquals(input, list2.toArray());
	
		
		
		//test insert sortedAcending with duplicates discarded	
		list2 = new ExtendedList<String>(1, false);
		String[] output = {"AA","BB","CC","DD","EE","GG","HH","KK" };
		for (String string : input) {
			list2.add(string);
		}
		assertArrayEquals(output, list2.toArray());
	

	}
}
