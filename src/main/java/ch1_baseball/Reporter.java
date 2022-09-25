package ch1_baseball;

/**
 * @author SeongRok.Oh
 * @since 2022/09/22
 */
public interface Reporter {
    void add(BaseballResult judge);
    boolean report();
}
