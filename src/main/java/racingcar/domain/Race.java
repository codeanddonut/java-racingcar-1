package racingcar.domain;

import java.util.Iterator;

public class Race implements Iterator<RoundSnapshot> {
    private final MovementStrategy strategy = new RandomMovement();
    private final Cars cars;
    private int leftRounds;

    public Race(Cars cars, Trial trial) {
        this.cars = cars;
        this.leftRounds = trial.number();
    }

    @Override
    public boolean hasNext() {
        return this.leftRounds > 0;
    }

    @Override
    public RoundSnapshot next() {
        this.leftRounds--;
        return cars.moveAll(this.strategy).captureSnapshot();
    }
}