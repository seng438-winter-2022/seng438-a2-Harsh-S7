package testPackage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	RangeTest.class,
	TestColumnTotal.class,
	TestCreateNumberArray.class,
	TestKeyPercent.class,
	TestRowTotal.class,
	TestNumberArray.class,
})

public class TestSuite {
	

}
