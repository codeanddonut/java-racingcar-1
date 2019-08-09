package racingcar.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoundSnapshot implements Iterator<LineSnapshot> {
    private final List<LineSnapshot> lineSnapshots;
    private int index = 0;

    public RoundSnapshot(List<Car> cars) {
        this.lineSnapshots = cars.stream()
                                .map(LineSnapshot::new)
                                .collect(
                                        Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                Collections::unmodifiableList
                                        )
                                );
    }

    public Stream<String> winners() {
        final int positionOfWinner = this.lineSnapshots.stream()
                                                        .sorted()
                                                        .findFirst()
                                                        .get()
                                                        .position();
        return this.lineSnapshots.stream()
                                .filter(x -> x.position() == positionOfWinner)
                                .map(LineSnapshot::name);
    }

    @Override
    public boolean hasNext() {
        return this.index < this.lineSnapshots.size();
    }

    @Override
    public LineSnapshot next() {
        return this.lineSnapshots.get(this.index++);
    }
}