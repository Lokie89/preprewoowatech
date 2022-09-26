package ch2_racing;

import java.util.Collection;

/**
 * @author SeongRok.Oh
 * @since 2022/09/25
 */
public interface Reporter<T> {
    void report(Collection<T> reported);
}
