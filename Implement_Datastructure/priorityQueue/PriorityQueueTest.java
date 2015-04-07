package priorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest {

	@Test
	public void test() {
		
		String[] dequeued={"ZZ","PP","OO","CC","LL","KK","BB","DD","WW","FF","RR","CC","JJ","TT","XX"};
		
		PriorityQueue<String> pq= new PriorityQueue<String>();
		
		String[] element={"XX","ZZ","KK","CC","JJ","FF","PP","BB","TT","RR","OO","DD","CC","WW","LL"};
			int[] priority={0,  20,  12,  5,   3,   10,  20,  12,   3,  10,  20,  12,  20,  12,  17};
		
		for (int i = 0; i < priority.length; i++) {
			pq.addWithPriority(element[i], priority[i]);
		}
		
		for (int i = 0; i < priority.length; i++) {
			assertEquals(dequeued[i], pq.remove());
			
		}

		
		
	}

}
