package ch1_baseball;

import java.util.Scanner;

/**
 * @author SeongRok.Oh
 * @since 2022/09/19
 */
public class BaseballGameStarter {
    public static void main(String[] args) {

        BaseballGameType[] types = BaseballGameType.values();

        for (int i = 0; i < types.length; i++) {
            System.out.printf("%d. %s ", i + 1, types[i].name());
            System.out.println();
            System.out.println(types[i].getDescription());
        }

        Scanner scanner = new Scanner(System.in);
        int ordinal = scanner.nextInt();

        Game baseBallGame = BaseballGameFactory.of(BaseballGameType.getByOrdinal(ordinal));

        baseBallGame.start();

    }
}
