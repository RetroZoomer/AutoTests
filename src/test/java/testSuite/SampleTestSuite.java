package testSuite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({TestInt.class, TestString.class})
public class SampleTestSuite {

}
