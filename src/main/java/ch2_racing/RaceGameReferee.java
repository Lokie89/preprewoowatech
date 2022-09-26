package ch2_racing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SeongRok.Oh
 * @since 2022/09/25
 */
public class RaceGameReferee {

    private final List<Racer> racers;

    private RaceGameReferee(List<Racer> racers) {
        this.racers = racers;
        validateRacers();
    }

    private void validateRacers() {
        if (this.racers == null || this.racers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static RaceGameReferee from(List<Racer> racers) {
        return new RaceGameReferee(racers);
    }

    public List<Racer> judge() {
        return findWinners();
    }

    private Racer findWinner() {
        return this.racers.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(IllegalArgumentException::new)
                ;
    }

    private List<Racer> findWinners() {
        Racer winner = findWinner();
        return this.racers.stream()
                .filter(winner::isDraw)
                .collect(Collectors.toList())
                ;
    }
}
