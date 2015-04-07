package listImplementation;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;



public class TreeListTest {
	
	ListInterface<String> words;
	ListInterface<Double> grades;
	ListInterface<Double> duplicatedGrades;
	ListInterface<Puppy> basketOfPuppies;

	@Before
	public void setUp() {
		words = new TreeList<>();
		grades = new TreeList<>();
		duplicatedGrades = new TreeList<>();
		basketOfPuppies = new TreeList<>();
		
		// Adding to words
		String[] wordsToBeAdded = {"Hello", "Goodbye", "Search", "Computer", "Technology"};
		for (String word : wordsToBeAdded) {
			words.add(word);
		}
		
		// Adding to grades and duplicated grades
		double[] gradesToBeAdded = {100.0, 99.2, 34.4, 85.0, 74.4, 100.0, 69.5};
		for (double grade : gradesToBeAdded) {
			grades.add(grade);
			duplicatedGrades.add(grade);
		}
		
		// Adding to the basket of puppies
		Puppy[] puppiesToBeAdded = {new Puppy("Jasper", 100), new Puppy("Reo", 65), new Puppy("Dingo", 15), new Puppy("Byte", 30)};
		for (Puppy puppy : puppiesToBeAdded) {
			basketOfPuppies.add(puppy);
		}
	}

	@Test
	public void testIsEmpty() {
		boolean result;
		
		result = words.isEmpty();
		assertFalse(result);
		
		result = grades.isEmpty();
		assertFalse(result);
		
		result = duplicatedGrades.isEmpty();
		assertFalse(result);
//		ListInterface<Puppy> 
		basketOfPuppies = new TreeList<>();
		result = basketOfPuppies.isEmpty();
		assertTrue(result);
	}

	@Test
	public void testSize() {
		int expected, result;
		
		expected = 5;
		result = words.size();
		assertEquals(expected, result);
		
		expected = 7;
		result = grades.size();
		assertEquals(expected, result);
		
		result = duplicatedGrades.size();
		assertEquals(expected, result);
		
		expected  = 4;
		result = basketOfPuppies.size();
		assertEquals(expected, result);
	}

	@Test
	public void testClear() {
		words.clear();
		grades.clear();
		duplicatedGrades.clear();
		basketOfPuppies.clear();
		
		assertTrue(words.isEmpty());
		assertTrue(grades.isEmpty());
		assertTrue(duplicatedGrades.isEmpty());
		assertTrue(basketOfPuppies.isEmpty());
	}

	@Test
	public void testContains() {
		boolean result;
		
		result = words.contains("Hello");
		assertTrue(result);
		
		result = words.contains("Magic");
		assertFalse(result);
		
		result = grades.contains(100.0);
		assertTrue(result);
		
		result = duplicatedGrades.contains(100.0);
		assertTrue(result);
		
		result = grades.contains(50.0);
		assertFalse(result);
	}

	@Test
	public void testEqualsListInterfaceOfE() {
		boolean result;
		
		result = grades.equals(duplicatedGrades);
		assertTrue(result);
		
		result = words.equals(grades);
		assertFalse(result);
	}

	@Test
	public void testGet() {
		String resultString = words.get(0);
		assertTrue("Computer".equalsIgnoreCase(resultString));
		
		double resultDouble = grades.get(0);
		assertTrue(resultDouble == 34.4);
		
		double resultDoubleTwo = duplicatedGrades.get(2);
		double sameResultDouble = grades.get(2);
		assertTrue(resultDoubleTwo == sameResultDouble);
		
		Puppy lastPuppy = basketOfPuppies.get(3);
		System.out.println(lastPuppy.getName());
		assertTrue(lastPuppy.getName().equalsIgnoreCase("Jasper"));
	}

	@Test
	public void testIndexOf() {
		int result;
		
		result = words.indexOf("Goodbye");
		assertEquals(1, result);
		
		result = grades.indexOf(34.4);
		assertEquals(0, result);
		
	}

	@Test
	public void testRemove() {
		words.remove(0);
		grades.remove(0);
		duplicatedGrades.remove(0);
		duplicatedGrades.remove(0);
		basketOfPuppies.remove(0);
		
		/*this requires adding the elements of the tree as new elements by first clearing the tree so that they will be sorted
		 * the tree will be restructured after each removal. But disabling the addToTree method call from the remove method will 
		 * keep it normal.
		 */
		
		assertTrue("Goodbye".equalsIgnoreCase(words.get(0)));
		assertTrue(69.5 == grades.get(0));
		assertTrue(74.4 == duplicatedGrades.get(0));
		assertTrue(basketOfPuppies.get(0).getName().equalsIgnoreCase("Byte"));
		
//		assertTrue("Goodbye".equalsIgnoreCase(words.get(0)));
//		assertTrue(99.2 == grades.get(0));
//		assertTrue(100.0 == duplicatedGrades.get(0));
//		assertTrue(basketOfPuppies.get(0).getName().equalsIgnoreCase("Reo"));
	}

	@Test
	public void testSet() {
		words.set(0, "Goodbye");
		assertTrue("Goodbye".equalsIgnoreCase(words.get(0)));
		
		grades.set(0, 0.0);
		assertTrue(grades.get(0) == 0.0);
	}

	@Test
	public void testToArray() {
		Object[] result = words.toArray();
		assertTrue(result[0].equals("Computer"));
	}

}
