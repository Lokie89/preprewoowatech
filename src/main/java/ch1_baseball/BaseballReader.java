package ch1_baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author SeongRok.Oh
 * @since 2022/09/22
 */
public class BaseballReader implements Reader {
    private final Set<Integer> answer;

    public BaseballReader(Set<Integer> answer) {
        this.answer = answer;
    }

    @Override
    public BaseballResult judge(int index, Integer number) {
        List<Integer> answer = new ArrayList<>(this.answer);
        if (answer.get(index).equals(number)) {
            return BaseballResult.STRIKE;
        }
        if (answer.contains(number)) {
            return BaseballResult.BALL;
        }
        return BaseballResult.OUT;
    }
}
