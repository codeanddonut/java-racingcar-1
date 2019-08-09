package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Trial {
    private static final int MIN_NUMBER_OF_TRIALS = 1;
    private static final Map<Integer, Trial> cache = new HashMap<>();

    private final int number;

    public static Trial of(int number) {
        number = (number >= MIN_NUMBER_OF_TRIALS) ? number : MIN_NUMBER_OF_TRIALS;
        cache.computeIfAbsent(number, Trial::new);
        return cache.get(number);
    }

    private Trial(int number) {
        this.number = number;
    }

    public int number() {
        return this.number;
    }
}