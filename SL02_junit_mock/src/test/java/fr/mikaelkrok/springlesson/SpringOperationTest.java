package fr.mikaelkrok.springlesson;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**99S120164080297768600012​
 * 
 * @author Mikael KROK
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SpringOperationTest {

	@Inject
	private OperationsService operations;
	
	@Test
	public void addTwoNumbers() {
		final long result = operations.add(10, 20);
		Assert.assertEquals(30, result);
	}

	@Test
	public void addFiveNumbers() {
		final long result = operations.add(256, 512, 1024, 2048, 4096);
		Assert.assertEquals(7936, result);
	}

	@Test
	public void multiplyTwoNumbers() {
		final long lMultiplication = operations.multiply(10, 20);
		assertEquals(200, lMultiplication);
	}

	@Test(expected = IllegalArgumentException.class)
	public void divideSingleNumber() {
		operations.divide(1);
	}

	@Test(expected = ArithmeticException.class)
	public void divideTwoNumbersButZero() {
		operations.divide(10, 0);
	}
}