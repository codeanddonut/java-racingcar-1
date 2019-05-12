package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name, int position) {
        if (name.length() < 1 || MAX_NAME_LENGTH < name.length() || position < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car move(Movable cond) {
        if (cond.isMovable()) {
            position++;
        }
        return this;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Car rhs) {
        return position - rhs.position;
    }

    @Override
    public boolean equals(Object rhs) {
        if (rhs == this) {
            return true;
        }
        if (!(rhs instanceof Car)) {
            return false;
        }
        Car car = (Car) rhs;
        return name == car.name && position == car.position;
    }

    @Override
    public int hashCode() {
        return name.length() * 65535 + position;
    }
}