package miniMathematica;

import static org.junit.Assert.*;

import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import miniMathematica.baseMathObjects.BaseMathObject;

public class RPNCalculatorTest {
	
	private RPNCalculator rpnCalculator;
	private ShuntingYardParser parser;

	@Before
	public void init() {
		rpnCalculator = new RPNCalculator();
		parser = new ShuntingYardParser();
	}
	
	@Test
	public void test1() {
		parser.convertInput("3+2");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 5.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		parser.convertInput("3*2.99");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 8.97;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		parser.convertInput("3+2-5");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 0.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		parser.convertInput("3+2.12-5-4");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = -3.88;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {
		parser.convertInput("3+2-5-4+8-7");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = -3.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test6() {
		parser.convertInput("3*2.66");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 7.98;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test7() {
		parser.convertInput("3+4*2");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 11.0;
		assertEquals(expected, actual);
	}

	@Test
	public void test8() {
		parser.convertInput("3*4-5");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 7.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test9() {
		parser.convertInput("3*4*5");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 60.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test10() {
		parser.convertInput("3/4*5");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 3.75;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test11() {
		parser.convertInput("3+4*2/1");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 11.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test12() {
		parser.convertInput("3+4*2/1*6-7");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 44.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test13() {
		parser.convertInput("7*5*9-3.01+4*2/1*6-7");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 352.99;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test14() {
		parser.convertInput("(-3.26)*2");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = -6.52;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test14_1() {
		parser.convertInput("-3.26*2");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = -6.52;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test15() {
		parser.convertInput("4*(-3)+6*(-2)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = -24.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test16() {
		parser.convertInput("(2+3)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 5.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test17() {
		parser.convertInput("((2+3.5-5))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 0.5;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test18() {
		parser.convertInput("(2+3/5)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 2.6;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test19() {
		parser.convertInput("((2+3)/5)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 1.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test20() {
		parser.convertInput("(2+(3/5))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 2.6;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test21() {
		parser.convertInput("(2+(3/5))*((6-2)*(-3))*6");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 100) / 100.0;
		Double expected = -187.20;
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test22() {
		parser.convertInput("(2+(3/5)*((6-2)*(-3))*6");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test23() {
		parser.convertInput("2+3)");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test24() {
		parser.convertInput("((2+3*2(-1))");
	}
	
	@Test
	public void test25() {
		parser.convertInput("2^3");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 8.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test25_1() {
		parser.convertInput("2^(-3)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 0.125;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test26() {
		parser.convertInput("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 100) / 100.0;
		Double expected = 3.00;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test27() {
		parser.convertInput("pow(2, 4)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 16.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test28() {
		parser.convertInput("(pow(2, 4))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 16.0;
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test29() {
		parser.convertInput("(pow(2, 4");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test30() {
		parser.convertInput("pow2, 4");
	}
	
	@Test
	public void test31() {
		parser.convertInput("pow(2, 4)+4");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 20.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test32() {
		parser.convertInput("(pow(2, 4)+4)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 20.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test33() {
		parser.convertInput("(pow(4*3, 5))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 248832.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test34() {
		parser.convertInput("(pow(4*(3-2), 5))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 1024.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test35() {
		parser.convertInput("pow(3,(6+1))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 2187.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test36() {
		parser.convertInput("pow(3, 5/(6+1))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) / 1000.0;
		Double expected = 2.192;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test37() {
		parser.convertInput("(pow(4*(3-2), 5/(6+1)))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) / 1000.0;
		Double expected = 2.692;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test38() {
		parser.convertInput("sin ( max ( 2 , 3 ) / 3 * 2 * pi )");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) / 1000.0;
		Double expected = 0.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test39() {
		parser.convertInput("cotg ( log ( 2 , 3 ) / 3 * pi )");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) / 1000.0;
		Double expected = -0.089;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test40() {
		parser.convertInput("pi*(6-4)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 100) / 100.0;
		Double expected = 6.28;
		assertEquals(expected, actual);
	}

	@Test
	public void test41() {
		parser.convertInput("sin(pi)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) / 1000.0;
		Double expected = 0.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test42() {
		parser.convertInput("cotg(pi)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = -8.165619676597685E15;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test43() {
		parser.convertInput("(4 + 2 * 5) / (1 + 3 * 2)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 2.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test44() {
		parser.convertInput("(5 + 8 * sin(pi/6)) / (2 + tg(pi/4))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 3.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test45() {
		parser.convertInput("((sin(pi/6) * 8 + 5) / (tg(pi/4) + 2))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 3.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test46() {
		parser.convertInput("((3 * log(5, e^2) + 8 * cos(pi/3)))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) / 1000.0;
		Double expected = 7.728;
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test47() {
		parser.convertInput("3 * 4^0.5");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 6.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test48() {
		parser.convertInput("3 * 4^0.5 - 1");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 5.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test49() {
		parser.convertInput("2 / (3 * 4^0.5 - 1)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 0.4;
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test50() {
		parser.convertInput("(3 * log(5, e^2) + 8 * cos(pi/3)) / (3 * 4^0.5 - 1)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) / 1000.0;
		Double expected = 1.546;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test51() {
		parser.convertInput("(log(3, e^2) * 3 + cos(pi/3) * 8)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) / 1000.0;
		Double expected = 9.461;
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test52() {
		parser.convertInput("(4^0.5 * 3 - 1)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 5.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test53() {
		parser.convertInput("(log(3, e^2) * 3 + cos(pi/3) * 8) / (4^0.5 * 3 - 1)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) / 1000.0;
		Double expected = 1.892;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test54() {
		parser.convertInput("5 + sin(pi) / pow(2, 10) - log(e, pow(e, sqrt(4)))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 3.0;
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test55() {
		parser.convertInput("5 + sin(pi) / pow(2, 10) - log(e, pow(e, sqrt(4))");
	}
	
	@Test
	public void test56() {
		parser.convertInput("5+sin(pi)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 5.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test57() {
		parser.convertInput("4*(-3)+6*(-2)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = -24.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test58() {
		parser.convertInput("5 + ((1 + 2) * 4) - 3");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 14.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test59() {
		parser.convertInput("3*(-4)+7");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = -5.0;
		assertEquals(expected, actual);
	}

	@Test
	public void test60() {
		parser.convertInput("sin(pi/6)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) / 1000.0;
		Double expected = 0.50;
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test61() {
		parser.convertInput("27 + 63. - sin(pi)");
	}
	
	@Test
	public void test62() {
		parser.convertInput("+7+3");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 10.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test63() {
		parser.convertInput("-10+60");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 50.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test63_1() {
		parser.convertInput("(-10+60)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = rpnCalculator.calculateRpnExpression(rpnExpression);
		Double expected = 50.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test64() {
		parser.convertInput("(-sin(pi/6))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 100) /100.0;
		Double expected = -0.50;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test65() {
		parser.convertInput("-sin(pi/6)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 100) /100.0;
		Double expected = -0.50;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test66() {
		parser.convertInput("-sqrt(9)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 100) /100.0;
		Double expected = -3.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test67() {
		parser.convertInput("(-sqrt(9))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 100) /100.0;
		Double expected = -3.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test68() {
		parser.convertInput("-1*5");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 100) /100.0;
		Double expected = -5.0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test69() {
		parser.convertInput("(-1)*5");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 100) /100.0;
		Double expected = -5.00;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test70() {
		parser.convertInput("max(sin(pi), sin(pi/2))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 100) /100.0;
		Double expected = 1.00;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test71() {
		parser.convertInput("min(sin(pi), sin(pi/2))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 100) /100.0;
		Double expected = 0.00;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test72() {
		parser.convertInput("2^3 - pow(2, 3)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 100) /100.0;
		Double expected = 0.00;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test73() {
		parser.convertInput("2^(-3)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) /1000.0;
		Double expected = 0.125;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test74() {
		parser.convertInput("log(e, e^(sin(pi/6) + tg(pi/3)))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) /1000.0;
		Double expected = 2.232;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test75() {
		parser.convertInput("pow(3, 0.5)");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) /1000.0;
		Double expected = 1.732;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test76() {
		parser.convertInput("max(log(e, e^(sin(pi/6) + tg(pi/3))), pow(3, 0.5))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 1000) /1000.0;
		Double expected = 2.232;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test77() {
		parser.convertInput("e^(-log(e, 2))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 10) /10.0;
		Double expected = 0.5;
		assertEquals(expected, actual);
	}
	
	@Test
	public void test78() {
		parser.convertInput("max(-1, -log(e, e^2))");
		Queue<BaseMathObject> rpnExpression = parser.getOutputRPN();
		Double actual = Math.round(rpnCalculator.calculateRpnExpression(rpnExpression) * 10) /10.0;
		Double expected = -1.0;
		assertEquals(expected, actual);
	}	
}
