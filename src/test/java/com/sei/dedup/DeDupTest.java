package com.sei.dedup;

import org.junit.Test;
import static org.junit.Assert.*;

public class DeDupTest{

	@Test
	public void test_1_2_3() {
	    int[] orig = {1, 2, 3};
	    assertArrayEquals(orig, DeDup.removeDuplicateWithSameOrder(orig.clone()));
	}

	@Test
	public void test_empty() {
	    int[] orig = {};
	    assertArrayEquals(orig, DeDup.removeDuplicateWithSameOrder(orig.clone()));
	}

	@Test
	public void test_single() {
	    int[] orig = {3};
	    assertArrayEquals(orig, DeDup.removeDuplicateWithSameOrder(orig.clone()));
	}

	@Test
	public void test_1_1_1() {
	    int[] orig = {1, 1, 1};
	    assertArrayEquals(new int[]{1}, DeDup.removeDuplicateWithSameOrder(orig.clone()));
	}

	@Test
	public void test_1_1_1_2_2_3_3_3() {
	    int[] orig = {1, 1, 1, 2, 2, 3, 3, 3};
	    assertArrayEquals(new int[]{1, 2, 3}, DeDup.removeDuplicateWithSameOrder(orig.clone()));
	}

	@Test
	public void test_1_2_3_3_3() {
	    int[] orig = {1, 2, 3, 3, 3};
	    assertArrayEquals(new int[]{1, 2, 3}, DeDup.removeDuplicateWithSameOrder(orig.clone()));
	}
}
