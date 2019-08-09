package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    void initExceptionTestA() {
        assertThatThrownBy(() -> new Car("", 3));
    }

    @Test
    void initExceptionTestB() {
        assertThatThrownBy(() -> new Car("asfdsgs"));
    }

    @Test
    void moveTest() {
        assertThat(
                new Car("TOAST", 4).move(() -> true).move(() -> true).position()
        ).isEqualTo(6);
    }

    @Test
    void stopTest() {
        assertThat(
                new Car("TOAST", 4).move(() -> false).position()
        ).isEqualTo(4);
    }
}