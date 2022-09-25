package ch1_baseball;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author SeongRok.Oh
 * @since 2022/09/20
 */
public class RandomBaseballGame extends BaseballGame {

    private final RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.of(MINIMUM_NUMBER, MAXIMUM_NUMBER);

    // fixme protected 필드에 값을 채워넣는게 좋을까?
    //  강제로 Integer[] 를 반환하게 하여 넣는게 좋을까?
    @Override
    protected Set<Integer> getQuiz(int capacity) {
        Set<Integer> quiz = new LinkedHashSet<>();
        while (quiz.size() < capacity) {
            quiz.add(randomNumberGenerator.generate());
        }
        return quiz;
    }

    @Override
    protected void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("응답 해야 하는 자리수는 %d 자리 입니다.", quiz.size());
        System.out.println();
        String report;
        do {
            System.out.println("답을 입력하세요.");
            report = scanner.nextLine();
            try {
                if (referee.judge(report)) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("잘못 입력 하였습니다.");
                System.out.printf("응답 해야 하는 자리수는 %d 자리 입니다.", quiz.size());
            }
        } while (true);

    }
}
