package ch1_baseball;

/**
 * @author SeongRok.Oh
 * @since 2022/09/22
 */
public interface Referee {
    // fixme Referee 의 judge 에 대한 return, parameter 타입을 너무 쉽게 명시했음, 좀더 생각해볼것
    boolean judge(String report);
}
