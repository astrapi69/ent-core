package io.github.astrapi69.entity.id.generator;

import io.github.astrapi69.entity.id.generator.SystemTimeIdGenerator;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * The unit test class for the class {@link SystemTimeIdGenerator}.
 */
public class SystemTimeIdGeneratorTest
{

	/**
	 * Test method for {@link SystemTimeIdGenerator#getNextId()}
	 */
	@Test void getNextId()
	{
		final List<Integer> nextIds = new ArrayList<>();
		for (int i = 0; i < 1000; i++)
		{
			final int nextId = SystemTimeIdGenerator.getInstance().getNextId();
			assertFalse(nextIds.contains(nextId),
				"Next id" + nextId + " should not generated twice");
			nextIds.add(nextId);
		}
	}

	/**
	 * Test method for {@link SystemTimeIdGenerator}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(SystemTimeIdGenerator.class);
	}
}
