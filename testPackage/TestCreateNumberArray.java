package testPackage;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class TestCreateNumberArray {
	
	 @Before
	 public void setUp() throws Exception { 
	    }

	//tests a standard 2d array
	@Test
	public void doubleTest() {
		double[][] testCase = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Number[][] result = DataUtilities.createNumberArray2D(testCase);
		// verify
		boolean check = false;

		for (int i = 0; i < result.length; i++)
			for (int j = 0; j < result[i].length; j++)
				if (result[i][j].doubleValue() != testCase[i][j]) {
					check = true;
					break;
				}
		assertEquals(false, check);
	}
	//tests a 2d array with different sizes of arrays
	@Test
	public void testDifSizes() {
		double[][] testCase = { { 1 }, { 2, 3, 4, 5, 6 }, { 7, 8, 9,10,11,12,13,14,15,16 } };
		Number[][] result = DataUtilities.createNumberArray2D(testCase);
		// verify
		boolean check = false;

		for (int i = 0; i < result.length; i++)
			for (int j = 0; j < result[i].length; j++)
				if (result[i][j].doubleValue() != testCase[i][j]) {
					check = true;
					break;
				}
		assertEquals(false, check);
	}
	
	@Test
	public void testDecimals() {
		double[][] testCase = { { 1, 1.11 }, { 2, 2.63, 3, 4, 5.322, 5, 6 }, { 7, 8, 9,10,11,12,13,14,15,16 } };
		Number[][] result = DataUtilities.createNumberArray2D(testCase);
		// verify
		boolean check = false;

		for (int i = 0; i < result.length; i++)
			for (int j = 0; j < result[i].length; j++)
				if (result[i][j].doubleValue() != testCase[i][j]) {
					check = true;
					break;
				}
		assertEquals(false, check);
	}
	
	@Test
	public void testIntvalues() {
		double[][] testCase = { { 1 }, { 2.77777777777, 3, 4, 5, 6 }, { 7, 8, 9,10,11,12,13,14,15,16 } };
		Number[][] result = DataUtilities.createNumberArray2D(testCase);
		// verify
		boolean check = false;

		for (int i = 0; i < result.length; i++)
			for (int j = 0; j < result[i].length; j++)
				if (result[i][j].intValue() != (int)testCase[i][j]) {
					check = true;
					break;
				}
		assertEquals(false, check);
	}
	
	
	@After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
	
}
