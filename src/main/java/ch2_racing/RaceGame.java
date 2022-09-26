package ch2_racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SeongRok.Oh
 * @since 2022/09/25
 */
public class RaceGame implements Game {

    private static final RaceGameRandomMover MOVER = new RaceGameRandomMover();
    private static final Reporter<Racer> REPORTER = new RacingGameReporter();
    private final List<Racer> racers;
    private final int racingCount;

    private RaceGame(List<Racer> racers, int racingCount) {
        this.racers = racers;
        this.racingCount = racingCount;
    }

    public static RaceGame of(String racersStr, int racingCount) {
        List<Racer> racers = Arrays.stream(racersStr.split(","))
                .map(Racer::from)
                .collect(Collectors.toList());
        return new RaceGame(racers, racingCount);
    }

    @Override
    public void start() {
        for (int i = 0; i < racingCount; i++) {
            run();
            report();
        }
        RaceGameReferee referee = RaceGameReferee.from(this.racers);
        List<Racer> winners = referee.judge();
        report(winners);
    }

    private void report() {
        REPORTER.report(this.racers);
    }

    private void report(List<Racer> racers) {
        REPORTER.report(racers);
    }

    private void run() {
        racers.forEach(racer -> {
            if (MOVER.isMovable()) {
                racer.move();
            }
        });
    }
}
