package testPackage;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class TestRowTotal extends DataUtilities {

	@Test
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
	
	@Test
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

}
