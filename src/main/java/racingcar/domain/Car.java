package racingcar.domain;

import java.util.Optional;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_POSITION = 0;
    private static final int DEFAULT_INITIAL_POSITION = 0;

    private final String name;
    private int position;

    protected Car(String name, int position) {
        this.name = Optional.of(name).filter(x -> x.length() > 0)
                                    .filter(x -> x.length() <= MAX_NAME_LENGTH)
                                    .orElseThrow(IllegalArgumentException::new);
        this.position = (position > MIN_POSITION) ? position : MIN_POSITION;
    }

    protected Car(String name) {
        this(name, DEFAULT_INITIAL_POSITION);
    }

    public Car move(MovementStrategy cond) {
        if (cond.isMovable()) {
            position++;
        }
        return this;
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.position;
    }
}