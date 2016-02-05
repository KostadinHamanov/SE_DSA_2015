package miniMathematica;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RPNCalculatorTest.class, ShuntingYardParserTest.class })
public class AllTests {

}
