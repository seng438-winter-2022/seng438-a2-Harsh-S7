**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |    28    |
| -------------- | ---      |
| Student Names: |          |
| Harshit Sharma | 30092470 |
| Heidi Toews    |          |
| Muhammad Khan  |          |
| Shamis Ali     |          |

# 1 Introduction

The goal of this lab was to understand how unit-testing works. Prior to attempting this lab, we were introduced to the idea of unit-testing and different concepts relating to it. We were taught about how mocking comes into play when we are testing large pieces of code which are interlinked. DOC or dependent on component is when a method depends on another method i.e. makes a call to that method to successfully compute its output. Using mocking, we can make sure to test a particular method only and make sure that the results returned from making a call to the other methods are the ones that we expect, allowing us to fully test a method or functionality. In this lab we achieved this by using different mocking frameworks such as JMock. We split into two teams of two so that we can each test one of the Data Utilities and Range as a team allowing us to exercise pair-testing. This lab also introduced us to the idea of understanding how to create tests without knowing too much about the program itself, thus allowing us to have a better understanding of how real-world testing and quality assurance is done.

# 2 Detailed description of unit test strategy

The unit-test strategy employed for this was to understand first on what the description of the method was and what were its potential use cases. Then based on that what the arguments to the method were and what the output was i.e. its data-type. By examining the aspects mentioned above, we then thought on what could be the possible errors that can occur. This allowed us to create the best possible test cases. An example could be that for the method of createNumberArray, a possible issue could be that the array it returns can be incorrect. Now the incorrectness can be either that it is not of the same length, signifying that there can be some entries in that array which are extra and/or the entire array is containing incorrect values. Another possible issue can be that what if the length is correct but the content are not. For this we can then match the array which was given as an argument and check each and every entry to make sure all the contents are correct.

Now for mocking we employed a different strategy. We realized that since we did not know much about the program we have no idea what methods were being called inside any particular function. As this is an open source library, we checked the source code for the method we wanted to employ mocking for and then made note of all the methods being called and why. Then we designed a particular test case and made not of exactly what we needed from different methods and made sure that exactly those values were being sent. When we were sure that all of the calls to the external functions were taken care of, then we designed a test case and used JMock for the mocking.  

To sum it up, our test strategy was to first test the invalid data and check if invalid data can be provided if possible and then we utilized boundary value test where we tested the function under different inputs with different expected outputs.


# 3 Test cases developed

Data Utilities:
calculateRowTotal:
Case 1: The testing of this method involves mocking. I examined which methods are being used and then mocked them using JMock. First I checked the sum of two rows and with simple fractions.
Code:
public void testRowTwo() {
		//fail("Not yet implemented");
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    // verify
	    assertEquals(result, 7.5, .000000001d);
		
	}
Case 2: Here I checked the sum of three rows and with fractions which are not simpler.
Code:
public void testRowThree() {
		//fail("Not yet implemented");
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(6.23));
	            one(values).getValue(0, 1);
	            will(returnValue(1.58));
	            one(values).getValue(0, 2);
	            will(returnValue(4.52));
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    // verify
	    assertEquals(result, 12.33, .000000001d);
		
	}


createNumberArray:
Case 1: This test case is supposed to check if the contents of the arrays are the same. Lengths and contents both are being checked.
Code:
public void testCorrectArray() {
		//fail("Not yet implemented");
		double [] arr = {2.0,4.5,6.5,4.5,7.6};
		Number [] value = DataUtilities.createNumberArray(arr);
		boolean check = false;
		if(value.length!=arr.length) {
			check = true;
		}else {
			for(int i=0;i<value.length;i++) {
				if(value[i].doubleValue()!=arr[i]) {
					check = true;
					break;
				}
			}
		}
		assertEquals(false,check);
		
	}
Case 2: This is similar to case 1 but here to show that the arrays are being checked correctly and the copy made is not a shallow copy, a value of the double array is changed before checking.
Code:
public void testChangedArray() {
		//fail("Not yet implemented");
		double [] arr = {3.0,4.57,6.45,4.45,7.46};
		Number [] value = DataUtilities.createNumberArray(arr);
		boolean check = false;
		arr[3]=1.223;   
		if(value.length!=arr.length) {
			check = true;
		}else {
			for(int i=0;i<value.length;i++) {
				if(value[i].doubleValue()!=arr[i]) {
					check = true;
					break;
				}
			}
		}
		assertEquals(false,check);
		
	}

calculateColumnTotal:
Case 1: Testing values with simpler fractional forms
Here a simple integer “2” and a simple fraction decimal “0.5” are added into the table and then a sum is asked to be calculated by the use of this method. 
Code:
public void testSimple() {
		//fail("Not yet implemented");
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		Integer first = 0;
		Integer second = 0;
		data.addValue(0.5, first, second);
		first=1;
		data.addValue(2,first, second);
		double value = DataUtilities.calculateColumnTotal(data, second);
		//System.out.println("Value "+value);
		assertEquals(2.0,value,.000000001d);
	}
Case 2:
Here the values being tested are the ones that do not simple fractions i.e. will require a proper addition of the decimals which might cause an error if not implemented correctly.
Code:

public void testDecimal() {
		//fail("Not yet implemented");
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		Integer first = 0;
		Integer second = 0;
		data.addValue(0.63, first, second);
		first=1;
		data.addValue(2.32,first, second);
		double value = DataUtilities.calculateColumnTotal(data, second);
		//System.out.println("Value "+value);
		assertEquals(2.95,value,.000000001d);
	}

getCumulativePercentages:
	Case1: testing a single value
The program will take a single keyedValue with all information being set arbitrarily. As there is one value, the program should return just 1.
Code:
public void testValue() {
		Mockery mockinger = new Mockery();
		final KeyedValues values = mockinger.mock(KeyedValues.class);
		mockinger.checking(new Expectations() {
			{

				allowing(values).getValue(0);
				will(returnValue(7.5));

				allowing(values).getItemCount();
				will(returnValue(1));

				allowing(values).getKey(0);
				will(returnValue(0));
			}
		});

		KeyedValues result = DataUtilities.getCumulativePercentages(values);

		assertEquals((double) result.getValue(0), 1.0, .000000001d);
	}

	Case2: checking for missing inputs
In this case, we were creating a single value but we didn’t put in a value for the key. This was done to see if the method will be able to detect that the key is missing and if it will report the error. This was successful
Code:
public void testMissing() {
		Mockery mockingContext = new Mockery();
		final KeyedValues values = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{

				allowing(values).getValue(0);
				will(returnValue(7.5));

				allowing(values).getItemCount();
				will(returnValue(1));

			}
		});

		KeyedValues result = DataUtilities.getCumulativePercentages(values);

		assertEquals((double) result.getValue(0), 1.0, .000000001d);
	}

	Case3: multiple values and simulating for loop behavior 
Here we used a mock to create multiple values in a KeyedValues list to see if the method can calculate the averages of all of them. This was done by adding checking/setting the count to 3 values (-7.5, 2.5, -5) and then repeating the process to add arbitrary key values. Then the program was to use the function to find the average at index 0. This method was successful.
Code:
public void testMultiple() {
		Mockery mockinger = new Mockery();
		final KeyedValues values = mockinger.mock(KeyedValues.class);
		mockinger.checking(new Expectations() {
			{
				// first loop that sets the values
				allowing(values).getItemCount();
				will(returnValue(3));

				allowing(values).getValue(0);
				will(returnValue(-7.5));

				allowing(values).getItemCount();
				will(returnValue(3));

				allowing(values).getValue(1);
				will(returnValue(2.5));

				allowing(values).getItemCount();
				will(returnValue(3));

				allowing(values).getValue(2);
				will(returnValue(-5.0));

				allowing(values).getItemCount();
				will(returnValue(3));

				// 2nd loop that sets the keys
				allowing(values).getItemCount();
				will(returnValue(3));

				allowing(values).getKey(0);
				will(returnValue(4));

				allowing(values).getKey(1);
				will(returnValue(-3));

				allowing(values).getItemCount();
				will(returnValue(3));

				allowing(values).getKey(2);
				will(returnValue(0));

			}
		});

		KeyedValues result = DataUtilities.getCumulativePercentages(values);

		assertEquals((double) result.getValue(0), 7.5 / 10.0, .000000001d);
	}
createNumberArray2D:
	Case1: copy a 2D array
Here we created a standard double 2D array and then used the createNumberArray2D method to copy the values and create the 2D number array. Using nested for loops, all the values of the new number array were checked with the original double array. If any number was found to be different from the original array, the test will fail. This test passed.
Code:
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

	Case2:test with different array sizes
In this method the same steps were repeated as the last test but this time the horizontal arrays had different lengths. This was done to see if the method could accommodate the different sizes. This test was successful
Code:
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

	Case3: testing with decimal values
Although the arrays in the past were of type double, it was important to see if the decimal points will be translated properly into the Number object.
The same process was repeated with the addition of numbers such as 2.63. This test was successful
Code: 
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

	Case4:testing integer values
In this test, it was seen if the values received from the Number object will be converted to int properly and if there will be any form of rounding errors. No error was found and the test was successful.
code:
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







Range: 
Pre tests: makes sure that the exampleRange value is created and assigned before the other tests
    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }

contains
Case 1: Test a value not in the range
In this test the input to the contains method was not in exampleRange. This test was successful.
Code:
@Test
public void containsValueNotInRange() {
	exampleRange = new Range(-1.0, 1.0);
	assertFalse(exampleRange.contains(10.0));
}
 
Case 2: Test a value in the range
In this test the input to the contains method was in exampleRange. This test was successful.
Code:
@Test
public void containsValueInRange() {
	exampleRange = new Range(-1.0, 1.0);
	assertTrue(exampleRange.contains(0.5));
}
 
Case 3: Test a value equal to the upper bound
In this test the input to the contains method was equal to the upper bound of exampleRange. This test was successful.
Code:
@Test
public void containsValueUpperBound() {
	exampleRange = new Range(-1.0, 1.0);
	assertTrue(exampleRange.contains(1.0));
}
 
Case 4: Test a value equal to the lower bound
In this test the input to the contains method was equal to the lower bound of exampleRange. This test was successful.
Code:
@Test
public void containsValueLowerBound() {
	exampleRange = new Range(-1.0, 1.0);
	assertTrue(exampleRange.contains(-1.0));
}
 
shift
Case 1: Test shifting by 0
In this test the range was shifted by 0. This test was successful.
Code:
@Test
public void shiftZero() {
	exampleRange = new Range(-1.0, 1.0);
 	Range shiftZero = Range.shift(exampleRange, 0);
	assertEquals(-1.0, shiftZero.getLowerBound(), .000000001d);
	assertEquals(1.0, shiftZero.getUpperBound(), .000000001d);
}
 
Case 2: Test shifting by a small amount
In this test the range was shifted by 0.5. This test was successful.
Code:
@Test
public void shiftSmall() {
	exampleRange = new Range(-1.0, 1.0);
	Range shiftSmall = Range.shift(exampleRange, 0.5);
	assertEquals(-0.5, shiftSmall.getLowerBound(), .000000001d);
	assertEquals(1.5, shiftSmall.getUpperBound(), .000000001d);
}
 
Case 3: Test shifting by a large amount
In this test the range was shifted by 100.0. This test was unsuccessful - the upper bound was shifted correctly, but the lower bound moved to 0 instead of 99.0 as was expected.
Code:
@Test
public void shiftLarger() {
	exampleRange = new Range(-1.0, 1.0);
	Range shiftLarger = Range.shift(exampleRange, 100.0);
	assertEquals(101.0, shiftLarger.getUpperBound(), .000000001d);
	assertEquals(99.0, shiftLarger.getLowerBound(), .000000001d);
}
 
Case 4: Test shifting by a negative amount
In this test the range was shifted by -10.0. This test was unsuccessful - the lower bound shifted correctly but the upper bound moved to 0 instead of -1.0 as was expected.
Code:
@Test
public void shiftNegative() {
	exampleRange = new Range(-1.0, 1.0);
	Range shiftNegative = Range.shift(exampleRange, -10.0);
	assertEquals(-11.0, shiftNegative.getLowerBound(), .000000001d);
	assertEquals(-1.0, shiftNegative.getUpperBound(), .000000001d);
}
 
equals
Case 1: Test two identical objects
In this test, the parameter for equals was the same object that had called it, so it tests whether an object equals itself. This test was successful.
Code:
@Test
public void equalsSame() {
	exampleRange = new Range(-1.0, 1.0);
    assertTrue(exampleRange.equals(exampleRange));
}
 
Case 2: Test two different objects
In this test, two different objects with different ranges were used. This test was successful.
Code:
@Test
 public void equalsDifferent() {
	exampleRange = new Range(-1.0, 1.0);
	Range equalsTest = new Range(-2, 0);
    assertFalse(exampleRange.equals(equalsTest));
 }
 
Case 3: Test with null
In this test, exampleRange was compared with null. This test was successful.
Code:
@Test
public void equalsNull() {
	assertFalse(exampleRange.equals(null));
}
 
Case 4: Test objects with the same values
In this test, two different objects with the same range values were compared. This test was successful.
Code:
@Test
public void equalsSameValues() {
	exampleRange = new Range(-1.0, 1.0);
	Range equalsTest = new Range(-1, 1);
    assertTrue(exampleRange.equals(equalsTest));
}
 
Constrain - checks what the closest value to the range is
Case 1 - checks the closest value to the range, if the value inputted is larger than the range
    @Test
    public void testClosestLargerValue() {
    	assertEquals( 1, exampleRange.constrain(50), .000000001d);
    }
Case 2 - checks the closest value to the range, if the value inputted is in the range
    @Test
    public void testClosestLargerValue() {
    	assertEquals( -1, exampleRange.constrain(-50), .000000001d);
    }
Case 3 - checks the closest value to the range, if the value inputted is smaller than the range
    @Test
    public void testClosestLargerValue() {
    	assertEquals( -0.3, exampleRange.constrain(-0.3), .000000001d);
    }
Intersects
Case 1 - this case checks if the example range intersects with values that are under
    @Test
    public void testRangeIntersectsUnder() {
    	assertTrue(exampleRange.intersects(-2, 0));
    }
Case 2 - this case checks if the example range intersects with values that are under and do not intersect
    @Test
    public void testRangeDoesNotIntersectUnder() {
    	assertFalse(exampleRange.intersects(-20, -10));
    }
Case 3 - this case checks if the example range intersects with values that are over
    @Test
    public void testRangeIntersectsOver() {
    	assertTrue(exampleRange.intersects(0, 2));
    }
Case 4 - this case checks if the example range intersects with values that are over and do not interest
    @Test
    public void testRangeDoesNotIntersectOver() {
    	assertFalse(exampleRange.intersects(10, 20));
    }
Case 5 - this case checks if the example range intersects with values that is just one point
    @Test
    public void testRangeIntersectOnePoint() {
    	assertTrue(exampleRange.intersects(0, 0));
    }
Case 6 - this case checks if the example range intersects with values that inside the range
    @Test
    public void testRangeIntersectInside() {
    	assertTrue(exampleRange.intersects(0, 0.5));
    }
Case 7 - this case checks if the example range intersects with values that engulfs the entire range
    @Test
    public void testRangeIntersectEngluf() {
    	assertTrue(exampleRange.intersects(-2, 2));
    }

# 4 How the team work/effort was divided and managed

We split our group into two pairs - Heidi & Harsh, and Muhammad & Shamis. One pair wrote tests for the DataUtilities class and the other wrote tests for the Range class. Each pair decided which methods to test for their class and came up with a plan for writing the unit tests. Then the tests were split up and each person wrote about half of the tests for their class. After the testing was complete, we came together as a group to go over all the unit tests together to make sure that everyone had a good understanding of all the tests that they didn’t write personally. 

# 5 Difficulties encountered, challenges overcome, and lessons learned

One of the biggest challenges encountered for all group members was understanding how Mock Objects work and their purpose. This was a new concept to many of us and took some time to understand and implement properly. The process of setting up the mock came with several errors initially as a result. 
For instance, the mock objects in the tests for the getCumulativePercentages() method were initially confusing as they required several different data members to set up. getCumulativePercentages() returned a KeyedValues object which was a type of list. This object required the length/size of the list (the item count), a value for each position and a key for each position. This meant inorder to create a mock of a KeyedValues object; values, keys and the total size of the list was all needed. Moreover the GetKeyedValues method also had 2 for loops, 1 to initialize the values and another to initialize the keys. It was difficult to understand how to undergo the process of testing that functionality. Eventually it was decided that the best way to test something like that was to simulate the process of going through the loop by making multiple individual values and keys while repeatedly checking the item count (checking to see if the end condition is met).


# 6 Comments/feedback on the lab itself

The lab was definitely an informative experience as it allowed us to gain a fundamental understanding of unit tests and build a foundation for software testing. Although, the largest problem we did have was that the hamcrest file provided did not correctly run the software which led to us having to download the file from java website. Another issue that the team had encountered was the lack of expectation for the test plan, as although it was stated as a free written paragraph, it was unclear what was truly expected from the writing. 
