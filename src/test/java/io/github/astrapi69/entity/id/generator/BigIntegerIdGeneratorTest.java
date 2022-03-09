package io.github.astrapi69.entity.id.generator;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BigIntegerIdGeneratorTest {

    /**
     * Test method for {@link BigIntegerIdGenerator#getNextId()}
     */
    @Test
    void getNextId()
    {
        final List<BigInteger> nextIds = new ArrayList<>();
        for (int i = 0; i < 1000; i++)
        {
            final BigInteger nextId = BigIntegerIdGenerator.getInstance().getNextId();
            assertFalse(nextIds.contains(nextId),
                    "Next id" + nextId + " should not generated twice");
            nextIds.add(nextId);
        }
    }
}
