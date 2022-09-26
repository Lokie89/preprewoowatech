package ch2_racing;

/**
 * @author SeongRok.Oh
 * @since 2022/09/25
 */
public class RaceGameRandomMover {

    private static final RandomNumberGenerator RANDOM_NUMBER_GENERATOR = RandomNumberGenerator.of(1, 10);
    private static final int RULE_NUMBER = 4;

    public boolean isMovable() {
        return RANDOM_NUMBER_GENERATOR.generate() > RULE_NUMBER;
    }
}
