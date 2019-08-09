package racingcar.domain;

public class LineSnapshot implements Comparable<LineSnapshot>{
    private final String name;
    private final int position;

    public LineSnapshot(Car car) {
        this.name = car.name();
        this.position = car.position();
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }

    @Override
    public int compareTo(LineSnapshot rhs) {
        return rhs.position - this.position;
    }
}