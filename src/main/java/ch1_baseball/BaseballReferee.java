package ch1_baseball;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author SeongRok.Oh
 * @since 2022/09/22
 */
public class BaseballReferee implements Referee {

    private final Reader reader;
    private final Set<Integer> answer;

    private BaseballReferee(Set<Integer> answer) {
        this.answer = answer;
        reader = new BaseballReader(answer);
    }

    public static BaseballReferee from(Set<Integer> answer) {
        return new BaseballReferee(answer);
    }

    @Override
    public boolean judge(String report) {
        Set<Integer> reportSet = strToIntegerSet(report);
        return compareReport(reportSet);
    }

    private Set<Integer> strToIntegerSet(String s) throws NumberFormatException {
        return Arrays.stream(s.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new))
                ;
    }

    private boolean compareReport(Set<Integer> reportSet) {
        if (isInvalidReport(reportSet)) {
            throw new IllegalArgumentException();
        }
        List<Integer> report = new ArrayList<>(reportSet);

        Reporter reporter = new BaseballReporter();
        for (int i = 0; i < report.size(); i++) {
            reporter.add(reader.judge(i, report.get(i)));
        }
        return reporter.report();
    }

    private boolean isInvalidReport(Set<Integer> reportSet) {
        return this.answer.size() != reportSet.size();
    }

}
