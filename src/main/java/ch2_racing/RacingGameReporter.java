package ch2_racing;

import java.util.Collection;

/**
 * @author SeongRok.Oh
 * @since 2022/09/25
 */
public class RacingGameReporter implements Reporter<Racer> {

    @Override
    public void report(Collection<Racer> reported) {
        System.out.println("----------------------------------------");
        reported.forEach(System.out::println);
        System.out.println("----------------------------------------");
    }
}
