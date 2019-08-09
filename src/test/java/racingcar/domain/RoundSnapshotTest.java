package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundSnapshotTest {
    @Test
    void winners() {
        assertThat(new Cars("a, b, c, d, e").captureSnapshot().winners().count()).isEqualTo(5);
    }
}