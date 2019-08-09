package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @Test
    void initExceptionTestA() {
        assertThatThrownBy(() -> new Cars("aa"));
    }

    @Test
    void initExceptionTestB() {
        assertThatThrownBy(() -> new Cars("a, b, cc, d    e, f"));
    }

    @Test
    void initExceptionTestC() {
        assertThatThrownBy(() -> new Cars(" a, a"));
    }

    @Test
    void moveAll() {
        final RoundSnapshot roundSnapshot =
                (new Cars("a, b, c, d, e")).moveAll(() -> true).captureSnapshot();
        while (roundSnapshot.hasNext()) {
            assertThat(roundSnapshot.next().position()).isEqualTo(1);
        }
    }
}