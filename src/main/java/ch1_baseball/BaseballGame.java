package ch1_baseball;

import java.util.Scanner;
import java.util.Set;

/**
 * @author SeongRok.Oh
 * @since 2022/09/19
 */
public abstract class BaseballGame implements Game {
    protected static int MINIMUM_NUMBER = 0;
    protected static int MAXIMUM_NUMBER = 9;
    protected static Referee referee;
    protected Set<Integer> quiz;

    @Override
    public final void start() {
        Scanner scanner = new Scanner(System.in);
        int capacity;
        do {
            System.out.println("몇 자리 수 게임을 하시겠습니까? ( 1 자리 이상 10 자리 이하 )");
            capacity = scanner.nextInt();
        } while (1 > capacity || capacity > 10);
        quiz = getQuiz(capacity);
        referee = BaseballReferee.from(quiz);
        run();
    }

    protected abstract Set<Integer> getQuiz(int capacity);

    protected abstract void run();
}
