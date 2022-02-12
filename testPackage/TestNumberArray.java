package testPackage;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class TestNumberArray extends DataUtilities {

	@Test
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
	
	@Test
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

}
