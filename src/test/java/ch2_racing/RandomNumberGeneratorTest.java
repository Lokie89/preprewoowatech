package ch2_racing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author SeongRok.Oh
 * @since 2022/09/25
 */


public class RandomNumberGeneratorTest {

    @Test
    void randomNumberGenerateTest() {
        final int min = 0;
        final int max = 10;
        RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.of(min, max);
        for (int i = 0; i < 100; i++) {
            Assertions.assertTrue(randomNumberGenerator.generate() >= min);
            Assertions.assertTrue(randomNumberGenerator.generate() <= max);
        }

    }
}
