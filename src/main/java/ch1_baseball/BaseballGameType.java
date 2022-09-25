package ch1_baseball;

import java.util.Arrays;

/**
 * @author SeongRok.Oh
 * @since 2022/09/19
 */

public enum BaseballGameType {
    RANDOM("본 게임은 컵퓨터가 출제가 되어 랜덤으로 구성된 3개의 숫자를 맞추는 야구 게임 입니다.") {
        @Override
        public BaseballGame getBaseballGame() {
            return new RandomBaseballGame();
        }
    },
    ;

    private String description;


    BaseballGameType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static BaseballGameType getByOrdinal(int ordinal) {
        return Arrays.stream(BaseballGameType.values())
                .filter(type -> type.ordinal() == (ordinal - 1))
                .findAny()
                .orElseThrow(IllegalArgumentException::new)
                ;
    }

    public abstract BaseballGame getBaseballGame();
}
