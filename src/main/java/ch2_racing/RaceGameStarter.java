package ch2_racing;

import java.util.Scanner;

/**
 * @author SeongRok.Oh
 * @since 2022/09/26
 */
public class RaceGameStarter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String racerNames = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        final int raceCount = scanner.nextInt();
        RaceGame raceGame = RaceGame.of(racerNames, raceCount);
        raceGame.start();
    }
}
