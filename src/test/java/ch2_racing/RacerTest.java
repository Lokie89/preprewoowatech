package ch2_racing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * @author SeongRok.Oh
 * @since 2022/09/25
 */
public class RacerTest {

    @Test
    void moveTest() throws NoSuchFieldException, IllegalAccessException {
        Racer racer = Racer.from("오성록");
        racer.move();
        Field field = racer.getClass().getDeclaredField("mileage");
        field.setAccessible(true);

        int mileage = (int) field.get(racer);
        Assertions.assertEquals(1, mileage);

        racer.move();
        int mileage2 = (int) field.get(racer);
        Assertions.assertEquals(2, mileage2);
    }

    @Test
    void constructorTest() {

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> Racer.from("오성록Test"));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> Racer.from("오성록 아닌 데 아아아"));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> Racer.from(""));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> Racer.from(null));

    }

    @Test
    void compareRacerTest() {
        Racer loser = Racer.from("패배자");
        Racer winner = Racer.from("승리자");

        loser.move();

        winner.move();
        winner.move();

        Assertions.assertTrue(winner.compareTo(loser) >= 0);
        Assertions.assertTrue(loser.compareTo(winner) < 0);
    }

    @Test
    void drawRacerTest() {
        Racer drawRacer1 = Racer.from("승리자1");
        Racer drawRacer2 = Racer.from("승리자2");

        Assertions.assertTrue(drawRacer1.isDraw(drawRacer2));
    }

}
