package ch2_racing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author SeongRok.Oh
 * @since 2022/09/25
 */
public class RaceGameTest {

    @Test
    void constructRaceGameTest() throws NoSuchFieldException, IllegalAccessException {
        RaceGame raceGame = RaceGame.of("오성록,홍길동,홍길동아빠,홍길동,테스트",10);
        Field field = raceGame.getClass().getDeclaredField("racers");
        field.setAccessible(true);

        List<RaceGame> raceGames = (List<RaceGame>) field.get(raceGame);
        Assertions.assertEquals(5, raceGames.size());
    }
}
