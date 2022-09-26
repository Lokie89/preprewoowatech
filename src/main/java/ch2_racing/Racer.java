package ch2_racing;

/**
 * @author SeongRok.Oh
 * @since 2022/09/25
 */
public class Racer implements Comparable<Racer> {

    private static final int RACER_NAME_LENGTH_LIMIT = 5;
    private final String name;
    private int mileage;

    private Racer(String name) {
        this.name = name;
        mileage = 0;
        validateName();
    }

    public static Racer from(String name) {
        return new Racer(name);
    }

    public void move() {
        mileage++;
    }

    private void validateName() {
        if (isIllegalName()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isIllegalName() {
        return isEmptyName()
                || isOutOfLength();
    }

    private boolean isOutOfLength() {
        return this.name == null
                || this.name.trim().length() > RACER_NAME_LENGTH_LIMIT;
    }

    private boolean isEmptyName() {
        return this.name == null
                || this.name.trim().isEmpty();
    }

    @Override
    public int compareTo(Racer other) {
        return this.mileage - other.mileage;
    }

    public boolean isDraw(Racer other) {
        return this.mileage == other.mileage;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(name)
                .append(" \t")
                .append("-".repeat(Math.max(0, mileage)))
                .toString();
    }
}
