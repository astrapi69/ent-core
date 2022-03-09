package io.github.astrapi69.entity.id.generator;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LongIdGeneratorTest {

    /**
     * Test method for {@link LongIdGenerator#getNextId()}
     */
    @Test
    void getNextId()
    {
        final List<Long> nextIds = new ArrayList<>();
        for (int i = 0; i < 1000; i++)
        {
            final Long nextId = LongIdGenerator.getInstance().getNextId();
            assertFalse(nextIds.contains(nextId),
                    "Next id" + nextId + " should not generated twice");
            nextIds.add(nextId);
        }
        System.out.println(nextIds);
    }
}
