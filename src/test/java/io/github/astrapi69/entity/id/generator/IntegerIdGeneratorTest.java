package io.github.astrapi69.entity.id.generator;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class IntegerIdGeneratorTest {

    /**
     * Test method for {@link BigIntegerIdGenerator#getNextId()}
     */
    @Test
    void getNextId()
    {
        final List<Integer> nextIds = new ArrayList<>();
        for (int i = 0; i < 1000; i++)
        {
            final Integer nextId = IntegerIdGenerator.getInstance().getNextId();
            assertFalse(nextIds.contains(nextId),
                    "Next id" + nextId + " should not generated twice");
            nextIds.add(nextId);
        }
        System.out.println(nextIds);
    }
}
