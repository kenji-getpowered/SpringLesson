package fr.mikaelkrok.springlesson;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Mikael KROK
 */
public class StaticOperationTest {

	@Test
	public void addTwoNumbers() {
		final long result = Operations.add(10, 20);
		Assert.assertEquals(30, result);
	}

	@Test
	public void additionCinqNumbers() {
		final long result = Operations.add(256, 512, 1024, 2048, 4096);
		Assert.assertEquals(7936, result);
	}

	@Test
	public void multiplyDeuxNumbers() {
		final long lMultiplication = Operations.multiply(10, 20);
		Assert.assertEquals(200, lMultiplication);
	}

	public void testMutiplicationCinqNumbers() {
		final long lMultiplication = Operations.add(256, 512, 1024, 2048, 4096);
		Assert.assertEquals(1125899906842624L, lMultiplication);
	}

	@Test(expected = IllegalArgumentException.class)
	public void divideSingleNumber() {
		Operations.divide(1);
	}

	@Test(expected = ArithmeticException.class)
	public void divideTwoNumbersButZero() {
		Operations.divide(10, 0);
	}
}