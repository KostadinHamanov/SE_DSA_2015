package miniMathematica;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ShuntingYardParserTest {

	public ShuntingYardParser syp;

	@Before
	public void init() {
		syp = new ShuntingYardParser();
	}

	@Test
	public void test1() {
		syp.convertInput("3+2");
		assertEquals("[3.0, 2.0, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test2() {
		syp.convertInput("3*2.99");
		assertEquals("[3.0, 2.99, *]", syp.getOutputRPN().toString());
	}

	@Test
	public void test3() {
		syp.convertInput("3+2-5");
		assertEquals("[3.0, 2.0, +, 5.0, -]", syp.getOutputRPN().toString());
	}

	@Test
	public void test4() {
		syp.convertInput("3+2.12-5-4");
		assertEquals("[3.0, 2.12, +, 5.0, -, 4.0, -]", syp.getOutputRPN().toString());
	}

	@Test
	public void test5() {
		syp.convertInput("3+2-5-4+8-7");
		assertEquals("[3.0, 2.0, +, 5.0, -, 4.0, -, 8.0, +, 7.0, -]", syp.getOutputRPN().toString());
	}

	@Test
	public void test6() {
		syp.convertInput("3*2.66");
		assertEquals("[3.0, 2.66, *]", syp.getOutputRPN().toString());
	}

	@Test
	public void test7() {
		syp.convertInput("3+4*2");
		assertEquals("[3.0, 4.0, 2.0, *, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test8() {
		syp.convertInput("3*4-5");
		assertEquals("[3.0, 4.0, *, 5.0, -]", syp.getOutputRPN().toString());
	}

	@Test
	public void test9() {
		syp.convertInput("3*4*5");
		assertEquals("[3.0, 4.0, *, 5.0, *]", syp.getOutputRPN().toString());
	}

	@Test
	public void test10() {
		syp.convertInput("3/4*5");
		assertEquals("[3.0, 4.0, /, 5.0, *]", syp.getOutputRPN().toString());
	}

	@Test
	public void test11() {
		syp.convertInput("3+4*2/1");
		assertEquals("[3.0, 4.0, 2.0, *, 1.0, /, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test12() {
		syp.convertInput("3+4*2/1*6-7");
		assertEquals("[3.0, 4.0, 2.0, *, 1.0, /, 6.0, *, +, 7.0, -]", syp.getOutputRPN().toString());
	}

	@Test
	public void test13() {
		syp.convertInput("7*5*9-3.01+4*2/1*6-7");
		assertEquals("[7.0, 5.0, *, 9.0, *, 3.01, -, 4.0, 2.0, *, 1.0, /, 6.0, *, +, 7.0, -]",
		syp.getOutputRPN().toString());
	}

	@Test
	public void test14() {
		syp.convertInput("(-3.26)*2");
		assertEquals("[3.26, -, 2.0, *]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test14_1() {
		syp.convertInput("-3.26*2");
		assertEquals("[3.26, -, 2.0, *]", syp.getOutputRPN().toString());
	}

	@Test
	public void test15() {
		syp.convertInput("4*(-3)+6*(-2)");
		assertEquals("[4.0, 3.0, -, *, 6.0, 2.0, -, *, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test16() {
		syp.convertInput("(2+3)");
		assertEquals("[2.0, 3.0, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test17() {
		syp.convertInput("((2+3.5-5))");
		assertEquals("[2.0, 3.5, +, 5.0, -]", syp.getOutputRPN().toString());
	}

	@Test
	public void test18() {
		syp.convertInput("(2+3/5)");
		assertEquals("[2.0, 3.0, 5.0, /, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test19() {
		syp.convertInput("((2+3)/5)");
		assertEquals("[2.0, 3.0, +, 5.0, /]", syp.getOutputRPN().toString());
	}

	@Test
	public void test20() {
		syp.convertInput("(2+(3/5))");
		assertEquals("[2.0, 3.0, 5.0, /, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test21() {
		syp.convertInput("(2+(3/5))*((6-2)*(-3))*6");
		assertEquals("[2.0, 3.0, 5.0, /, +, 6.0, 2.0, -, 3.0, -, *, *, 6.0, *]", syp.getOutputRPN().toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test22() {
		syp.convertInput("(2+(3/5)*((6-2)*(-3))*6");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test23() {
		syp.convertInput("2+3)");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test24() {
		syp.convertInput("((2+3*2(-1))");
	}

	@Test
	public void test25() {
		syp.convertInput("2^3");
		assertEquals("[2.0, 3.0, ^]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test25_1() {
		syp.convertInput("2^(-3)");
		assertEquals("[2.0, 3.0, -, ^]", syp.getOutputRPN().toString());
	}

	@Test
	public void test26() {
		syp.convertInput("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3");
		assertEquals("[3.0, 4.0, 2.0, *, 1.0, 5.0, -, 2.0, 3.0, ^, ^, /, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test27() {
		syp.convertInput("pow(2, 4)");
		assertEquals("[2.0, 4.0, pow]", syp.getOutputRPN().toString());
	}

	@Test
	public void test28() {
		syp.convertInput("(pow(2, 4))");
		assertEquals("[2.0, 4.0, pow]", syp.getOutputRPN().toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test29() {
		syp.convertInput("(pow(2, 4)");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test30() {
		syp.convertInput("pow2, 4)");
	}

	@Test
	public void test31() {
		syp.convertInput("pow(2, 4)+4");
		assertEquals("[2.0, 4.0, pow, 4.0, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test32() {
		syp.convertInput("(pow(2, 4)+4)");
		assertEquals("[2.0, 4.0, pow, 4.0, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test33() {
		syp.convertInput("(pow(4*3, 5))");
		assertEquals("[4.0, 3.0, *, 5.0, pow]", syp.getOutputRPN().toString());
	}

	@Test
	public void test34() {
		syp.convertInput("(pow(4*(3-2), 5))");
		assertEquals("[4.0, 3.0, 2.0, -, *, 5.0, pow]", syp.getOutputRPN().toString());
	}

	@Test
	public void test35() {
		syp.convertInput("pow(3,(6+1))");
		assertEquals("[3.0, 6.0, 1.0, +, pow]", syp.getOutputRPN().toString());
	}

	@Test
	public void test36() {
		syp.convertInput("pow(3, 5/(6+1))");
		assertEquals("[3.0, 5.0, 6.0, 1.0, +, /, pow]", syp.getOutputRPN().toString());
	}

	@Test
	public void test37() {
		syp.convertInput("(pow(4*(3-2), 5/(6+1)))");
		assertEquals("[4.0, 3.0, 2.0, -, *, 5.0, 6.0, 1.0, +, /, pow]", syp.getOutputRPN().toString());
	}

	@Test
	public void test38() {
		syp.convertInput("sin ( max ( 2 , 3 ) / 3 * pi )");
		assertEquals("[2.0, 3.0, max, 3.0, /, pi, *, sin]", syp.getOutputRPN().toString());
	}

	@Test
	public void test39() {
		syp.convertInput("cotg ( log ( 2 , 3 ) / 3 * pi )");
		assertEquals("[2.0, 3.0, log, 3.0, /, pi, *, cotg]", syp.getOutputRPN().toString());
	}

	@Test
	public void test40() {
		syp.convertInput("pi*(6-4)");
		assertEquals("[pi, 6.0, 4.0, -, *]", syp.getOutputRPN().toString());
	}

	@Test
	public void test41() {
		syp.convertInput("sin(pi)");
		assertEquals("[pi, sin]", syp.getOutputRPN().toString());
	}

	@Test
	public void test42() {
		syp.convertInput("cotg(pi)");
		assertEquals("[pi, cotg]", syp.getOutputRPN().toString());
	}

	@Test
	public void test43() {
		syp.convertInput("(4 + 2 * 5) / (1 + 3 * 2)");
		assertEquals("[4.0, 2.0, 5.0, *, +, 1.0, 3.0, 2.0, *, +, /]", syp.getOutputRPN().toString());
	}

	@Test
	public void test44() {
		syp.convertInput("(5 + 8 * sin(pi/6)) / (2 + tg(pi/4))");
		assertEquals("[5.0, 8.0, pi, 6.0, /, sin, *, +, 2.0, pi, 4.0, /, tg, +, /]", syp.getOutputRPN().toString());
	}

	@Test
	public void test45() {
		syp.convertInput("((sin(pi/6) * 8 + 5) / (tg(pi/4) + 2))");
		assertEquals("[pi, 6.0, /, sin, 8.0, *, 5.0, +, pi, 4.0, /, tg, 2.0, +, /]", syp.getOutputRPN().toString());
	}

	@Test
	public void test46() {
		syp.convertInput("((3 * log(5, e^2) + 8 * cos(pi/3)))");
		assertEquals("[3.0, 5.0, e, 2.0, ^, log, *, 8.0, pi, 3.0, /, cos, *, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test47() {
		syp.convertInput("3 * 4^0.5");
		assertEquals("[3.0, 4.0, 0.5, ^, *]", syp.getOutputRPN().toString());
	}

	@Test
	public void test48() {
		syp.convertInput("3 * 4^0.5 - 1");
		assertEquals("[3.0, 4.0, 0.5, ^, *, 1.0, -]", syp.getOutputRPN().toString());
	}

	@Test
	public void test49() {
		syp.convertInput("2 / (3 * 4^0.5 - 1)");
		assertEquals("[2.0, 3.0, 4.0, 0.5, ^, *, 1.0, -, /]", syp.getOutputRPN().toString());
	}

	@Test
	public void test50() {
		syp.convertInput("(3 * log(5, e^2) + 8 * cos(pi/3)) / (3 * 4^0.5 - 1)");
		assertEquals("[3.0, 5.0, e, 2.0, ^, log, *, 8.0, pi, 3.0, /, cos, *, +, 3.0, 4.0, 0.5, ^, *, 1.0, -, /]",
				syp.getOutputRPN().toString());
	}

	@Test
	public void test51() {
		syp.convertInput("(log(3, e^2) * 3 + cos(pi/3) * 8)");
		assertEquals("[3.0, e, 2.0, ^, log, 3.0, *, pi, 3.0, /, cos, 8.0, *, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test52() {
		syp.convertInput("(4^0.5 * 3 - 1)");
		assertEquals("[4.0, 0.5, ^, 3.0, *, 1.0, -]", syp.getOutputRPN().toString());
	}

	@Test
	public void test53() {
		syp.convertInput("(log(3, e^2) * 3 + cos(pi/3) * 8) / (4^0.5 * 3 - 1)");
		assertEquals("[3.0, e, 2.0, ^, log, 3.0, *, pi, 3.0, /, cos, 8.0, *, +, 4.0, 0.5, ^, 3.0, *, 1.0, -, /]",
				syp.getOutputRPN().toString());
	}

	@Test
	public void test54() {
		syp.convertInput("5 + sin(pi) / pow(2, 10) - log(e, pow(e, sqrt(4)))");
		assertEquals("[5.0, pi, sin, 2.0, 10.0, pow, /, +, e, e, 4.0, sqrt, pow, log, -]",
				syp.getOutputRPN().toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test55() {
		syp.convertInput("5 + sin(pi) / pow(2, 10) - log(e, pow(e, sqrt(4))");
	}

	@Test
	public void test56() {
		syp.convertInput("5+sin(pi)");
		assertEquals("[5.0, pi, sin, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test57() {
		syp.convertInput("4*(-3)+6*(-2)");
		assertEquals("[4.0, 3.0, -, *, 6.0, 2.0, -, *, +]", syp.getOutputRPN().toString());
	}

	@Test
	public void test58() {
		syp.convertInput("5 + ((1 + 2) * 4) - 3");
		assertEquals("[5.0, 1.0, 2.0, +, 4.0, *, +, 3.0, -]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test59() {
		syp.convertInput("3*(-4)+7");
		assertEquals("[3.0, 4.0, -, *, 7.0, +]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test60() {
		syp.convertInput("siN(pi/6)");
		assertEquals("[pi, 6.0, /, sin]", syp.getOutputRPN().toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test61() {
		syp.convertInput("27 + 63. - sin(pi)");
	}
	
	@Test
	public void test62() {
		syp.convertInput("+7+3");
		assertEquals("[7.0, 3.0, +]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test63() {
		syp.convertInput("-10+60");
		assertEquals("[10.0, -, 60.0, +]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test63_1() {
		syp.convertInput("(-10+60)");
		assertEquals("[10.0, -, 60.0, +]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test64() {
		syp.convertInput("(-sin(pi/6))");
		assertEquals("[pi, 6.0, /, sin, -]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test65() {
		syp.convertInput("-sin(pi/6)");
		assertEquals("[pi, 6.0, /, sin, -]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test66() {
		syp.convertInput("-sqrt(9)");
		assertEquals("[9.0, sqrt, -]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test67() {
		syp.convertInput("(-sqrt(9))");
		assertEquals("[9.0, sqrt, -]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test68() {
		syp.convertInput("-1*5");
		assertEquals("[1.0, -, 5.0, *]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test69() {
		syp.convertInput("(-1)*5");
		assertEquals("[1.0, -, 5.0, *]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test70() {
		syp.convertInput("max(sin(pi), sin(pi/2))");
		assertEquals("[pi, sin, pi, 2.0, /, sin, max]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test71() {
		syp.convertInput("min(sin(pi), sin(pi/2))");
		assertEquals("[pi, sin, pi, 2.0, /, sin, min]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test72() {
		syp.convertInput("2^3 - pow(2, 3)");
		assertEquals("[2.0, 3.0, ^, 2.0, 3.0, pow, -]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test73() {
		syp.convertInput("2^(-3)");
		assertEquals("[2.0, 3.0, -, ^]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test74() {
		syp.convertInput("log(e, e^(sin(pi/6) + tg(pi/3)))");
		assertEquals("[e, e, pi, 6.0, /, sin, pi, 3.0, /, tg, +, ^, log]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test75() {
		syp.convertInput("pow(3, 0.5)");
		assertEquals("[3.0, 0.5, pow]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test76() {
		syp.convertInput("max(log(e, e^(sin(pi/6) + tg(pi/3))), pow(3, 0.5))");
		assertEquals("[e, e, pi, 6.0, /, sin, pi, 3.0, /, tg, +, ^, log, 3.0, 0.5, pow, max]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test77() {
		syp.convertInput("e^(-log(e, 2))");
		assertEquals("[e, e, 2.0, log, -, ^]", syp.getOutputRPN().toString());
	}
	
	@Test
	public void test78() {
		syp.convertInput("max(-1, -log(e, e^2))");
		assertEquals("[1.0, -, e, e, 2.0, ^, log, -, max]", syp.getOutputRPN().toString());
	}
	
}
