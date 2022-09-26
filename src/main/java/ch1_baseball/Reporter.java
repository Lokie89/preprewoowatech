package ch1_baseball;

/**
 * @author SeongRok.Oh
 * @since 2022/09/22
 */
public interface Reporter {
    // fixme Reporter 인데 BaseballResult 를 왜 받음????????????
    void add(BaseballResult judge);
    boolean report();
}
