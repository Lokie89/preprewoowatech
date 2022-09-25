package ch1_baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author SeongRok.Oh
 * @since 2022/09/22
 */
public class BaseballReporter implements Reporter {

    private final List<BaseballResult> results = new ArrayList<>();

    @Override
    public void add(BaseballResult result) {
        results.add(result);
    }

    @Override
    public boolean report() {

        Map<BaseballResult, Long> map = Arrays.stream(BaseballResult.values())
                .collect(Collectors.toMap(item -> item, item -> results.stream().filter(result -> result.equals(item)).count()));
        for (BaseballResult key : map.keySet()) {
            System.out.println(map.get(key) + key.name());
        }
        return allStrikes();
    }

    private boolean allStrikes(){
        return !results.contains(BaseballResult.BALL)
                && !results.contains(BaseballResult.OUT);
    }
}
