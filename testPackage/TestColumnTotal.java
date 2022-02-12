package testPackage;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Test;

public class TestColumnTotal extends DataUtilities {

	@Test
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
	
	@Test
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

}
