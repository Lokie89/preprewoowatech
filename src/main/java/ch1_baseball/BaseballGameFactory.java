package ch1_baseball;

/**
 * @author SeongRok.Oh
 * @since 2022/09/20
 */
public class BaseballGameFactory {
    private final BaseballGameType type;

    private BaseballGameFactory(BaseballGameType type) {
        this.type = type;
    }

    public static BaseballGame of(BaseballGameType type){
        return type.getBaseballGame();
    }
}
