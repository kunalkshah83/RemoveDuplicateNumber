package com.sei.dedup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeDup {

	public static int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16,
			19, 1, 18, 4, 9, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3,
			6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public static void main(String[] args) {

		/* First Approach */
		/*
		 * you have to check for each element in second array whether previous
		 * element is already present or not.
		 */
		int[] numberArray = removeDuplicateWithSameOrder(randomIntegers);
		System.out.println("Remove Duplicate Element Approach 1: " + java.util.Arrays.toString(numberArray));

		/* Second Approach */
		numberArray = removeDuplicate(randomIntegers);
		System.out.println("Remove Duplicate Element Approach 2: " + java.util.Arrays.toString(numberArray));

		/* Third Approach */
		Integer[] numbers = Arrays.stream(randomIntegers).boxed().toArray(Integer[]::new);
		Integer[] integerArray = deleteDuplicate(numbers);
		System.out.println("Remove Duplicate Element Approach 3: " + java.util.Arrays.toString(integerArray));

	}

	public static int[] removeDuplicateWithSameOrder(int[] elementsArray) {

		if (elementsArray.length == 0) {
			return null;
		}
		if (elementsArray.length == 1) {
			return elementsArray;
		}

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < elementsArray.length; i++) {
			if (!numbers.contains(elementsArray[i])) {
				numbers.add(elementsArray[i]);
			}
		}
		Iterator<Integer> valueIterator = numbers.iterator();
		int[] resultArray = new int[numbers.size()];
		int i = 0;
		while (valueIterator.hasNext()) {
			resultArray[i] = valueIterator.next();
			i++;
		}

		return resultArray;
	}

	public static int[] removeDuplicate(int[] elementsArray) {

		Set<Integer> uniqueNumberSet = new HashSet<Integer>();
		for (int i = 0; i < elementsArray.length; i++) {
			uniqueNumberSet.add(elementsArray[i]);
		}

		// copy the elements from the set into an array
		int[] result = new int[uniqueNumberSet.size()];
		int i = 0;
		for (Integer u : uniqueNumberSet) {
			result[i++] = u;
		}
		return result;

	}

	public static Integer[] deleteDuplicate(Integer[] elementsArray) {
		return new LinkedHashSet<Integer>(Arrays.asList(elementsArray)).toArray(new Integer[0]);
	}

}
