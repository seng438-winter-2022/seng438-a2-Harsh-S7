package testPackage;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import org.jfree.data.KeyedValues;


public class TestKeyPercent {
	 @Before
	 public void setUp() throws Exception { 
	    }
	
	@Test
	// testing and simulating the forloop
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
	
	// test a single value with no key, this one is expected to fail
//	@Test
//	public void testMissing() {
//		Mockery mockingContext = new Mockery();
//		final KeyedValues values = mockingContext.mock(KeyedValues.class);
//		mockingContext.checking(new Expectations() {
//			{
//
//				allowing(values).getValue(0);
//				will(returnValue(7.5));
//
//				allowing(values).getItemCount();
//				will(returnValue(1));
//
//			}
//		});
//
//		KeyedValues result = DataUtilities.getCumulativePercentages(values);
//
//		assertEquals((double) result.getValue(0), 1.0, .000000001d);
//	}
	
	
	//testing just 1 value with key
	@Test
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
	
	
	@After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
