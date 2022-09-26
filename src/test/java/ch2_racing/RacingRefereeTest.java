package ch2_racing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SeongRok.Oh
 * @since 2022/09/25
 */
public class RacingRefereeTest {

    @Test
    void racingRefereeJudgeTest() {
        Racer racer1 = Racer.from("오성록");
        Racer racer2 = Racer.from("홍길동");
        Racer racer3 = Racer.from("홍길동아빠");

        racer1.move();
        racer1.move();
        racer1.move();

        racer2.move();
        racer2.move();

        racer3.move();
        racer3.move();
        racer3.move();

        List<Racer> racers = new ArrayList<>();
        racers.add(racer1);
        racers.add(racer2);
        racers.add(racer3);

        RaceGameReferee raceGameReferee = RaceGameReferee.from(racers);
        List<Racer> winners = raceGameReferee.judge();
        Assertions.assertEquals(2, winners.size());

    }

}
