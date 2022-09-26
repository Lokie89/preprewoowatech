package ch2_racing;

import java.util.Random;

/**
 * @author SeongRok.Oh
 * @since 2022/09/20
 */
public class RandomNumberGenerator {
    private final int minNumber;
    private final int maxNumber;
    private final Random random;

    private RandomNumberGenerator(int minNumber, int maxNumber) {
        random = new Random();
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }


    public static RandomNumberGenerator of(int minNumber, int maxNumber) {
        return new RandomNumberGenerator(minNumber, maxNumber);
    }

    public int generate() {
        int randomNumber = random.nextInt(maxNumber - minNumber + 1);
        return randomNumber + minNumber;
    }
}
