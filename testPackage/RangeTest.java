package testPackage;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;


public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        exampleRange = new Range(-1.0, 1.0);
    }


    //Tests for contains method 
    
    //Try a value not in the range 
    @Test
    public void containsValueNotInRange() {
        exampleRange = new Range(-1.0, 1.0);
        assertFalse(exampleRange.contains(10.0));
    }
    
    //Try a value in the range 
    @Test
    public void containsValueInRange() {
        exampleRange = new Range(-1.0, 1.0);
        assertTrue(exampleRange.contains(0.5));
    }
    
    //Try a value equal to the upper bound of the range 
    @Test
    public void containsValueUpperBound() {
        exampleRange = new Range(-1.0, 1.0);
        assertTrue(exampleRange.contains(1.0));
    }
    
    //Try a value equal to the lower bound of the range 
    @Test
    public void containsValueLowerBound() {
        exampleRange = new Range(-1.0, 1.0);
        assertTrue(exampleRange.contains(-1.0));
    }
    
    
    //Tests for shift method 
    
    //Try a shifting by 0 
    @Test
    public void shiftZero() {
        exampleRange = new Range(-1.0, 1.0);
         Range shiftZero = Range.shift(exampleRange, 0);
         assertEquals(-1.0, shiftZero.getLowerBound(), .000000001d);
         assertEquals(1.0, shiftZero.getUpperBound(), .000000001d);
    }
    
    //Try a small amount 
    @Test
    public void shiftSmall() {
        exampleRange = new Range(-1.0, 1.0);
        Range shiftSmall = Range.shift(exampleRange, 0.5);
        assertEquals(-0.5, shiftSmall.getLowerBound(), .000000001d);
        assertEquals(1.5, shiftSmall.getUpperBound(), .000000001d);
    }
    
    //Try a larger amount 
    @Test
    public void shiftLarger() {
        exampleRange = new Range(-1.0, 1.0);
        Range shiftLarger = Range.shift(exampleRange, 100.0);
        assertEquals(101.0, shiftLarger.getUpperBound(), .000000001d);
        assertEquals(99.0, shiftLarger.getLowerBound(), .000000001d);
    }
    
    //Try a negative amount 
    @Test
    public void shiftNegative() {
        exampleRange = new Range(-1.0, 1.0);
        Range shiftNegative = Range.shift(exampleRange, -10.0);
        assertEquals(-11.0, shiftNegative.getLowerBound(), .000000001d);
        assertEquals(-1.0, shiftNegative.getUpperBound(), .000000001d);
    }
    
    
    //Tests for equals 
    
    //Try two objects that are the same 
    @Test
    public void equalsSame() {
        exampleRange = new Range(-1.0, 1.0);
        assertTrue(exampleRange.equals(exampleRange));
    }
    
    //Try two objects that are different 
    @Test
    public void equalsDifferent() {
        exampleRange = new Range(-1.0, 1.0);
        Range equalsTest = new Range(-2, 0);
        assertFalse(exampleRange.equals(equalsTest));
    }
    
    //Try null 
    @Test
    public void equalsNull() {
        assertFalse(exampleRange.equals(null));
    }
    
    //Try two different objects with the same values 
    @Test
    public void equalsSameValues() {
        exampleRange = new Range(-1.0, 1.0);
        Range equalsTest = new Range(-1, 1);
        assertTrue(exampleRange.equals(equalsTest));
    }
    
   @Test
    public void testClosestLargerValue() {
    	assertEquals( 1, exampleRange.constrain(50), .000000001d);
    }
    
    @Test
    public void testClosestSmallValue() {
    	assertEquals( -1, exampleRange.constrain(-50), .000000001d);
    }
    
    @Test
    public void testClosestValueInRange() {
    	assertEquals( -0.3, exampleRange.constrain(-0.3), .000000001d);
    }
    
    @Test
    public void testRangeIntersectsUnder() {
    	assertTrue(exampleRange.intersects(-2, 0));
    }
    
    @Test
    public void testRangeDoesNotIntersectUnder() {
    	assertFalse(exampleRange.intersects(-20, -10));
    }
    
    @Test
    public void testRangeIntersectsOver() {
    	assertTrue(exampleRange.intersects(0, 2));
    }
    
    @Test
    public void testRangeDoesNotIntersectOver() {
    	assertFalse(exampleRange.intersects(10, 20));
    }
    
    @Test
    public void testRangeIntersectOnePoint() {
    	assertTrue(exampleRange.intersects(0, 0));
    }
    
    @Test
    public void testRangeIntersectInside() {
    	assertTrue(exampleRange.intersects(0, 0.5));
    }
    
    @Test
    public void testRangeIntersectEngluf() {
    	assertTrue(exampleRange.intersects(-2, 2));
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}