package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final int MIN_NUMBER_OF_CARS = 2;

    private final List<Car> cars;

    public Cars(String input) {
        this.cars = Stream.of(
                Optional.ofNullable(input)
                        .map(x -> x.split(",+"))
                        .orElseThrow(IllegalArgumentException::new)
        ).map(String::trim)
        .filter(x -> x.length() > 0)
        .distinct()
        .map(Car::new)
        .collect(
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                )
        );
        if (this.cars.size() < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException();
        }
    }

    public Cars moveAll(MovementStrategy strategy) {
        this.cars.forEach(car -> car.move(strategy));
        return this;
    }

    public RoundSnapshot captureSnapshot() {
        return new RoundSnapshot(this.cars);
    }
}