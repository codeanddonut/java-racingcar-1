package calc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorAppTest {
    @Test
    void 덧셈테스트() {
        assertThat(new Calculator("1 +    2 + 3").getValue()).isEqualTo(6.0);
    }

    @Test
    void 뺄셈테스트() {
        assertThat(new Calculator("1 -   3").getValue()).isEqualTo(-2.0);
    }

    @Test
    void 곱셈테스트() {
        assertThat(new Calculator("1   * -3").getValue()).isEqualTo(-3.0);
    }

    @Test
    void 나눗셈테스트() {
        assertThat(new Calculator("12 /   3").getValue()).isEqualTo(4.0);
    }

    @Test
    void 수식테스트() {
        assertThat(new Calculator("1 - 3 * 6 + 6 / 2").getValue()).isEqualTo(-3.0);
    }

    @Test
    void 예외테스트A() {
        assertThrows(Exception.class, () -> {
            new Calculator("-");
        });
    }

    @Test
    void 예외테스트B() {
        assertThrows(Exception.class, () -> {
            new Calculator("1 +");
        });
    }

    @Test
    void 예외테스트C() {
        assertThrows(Exception.class, () -> {
            new Calculator("1 + /");
        });
    }

    @Test
    void 예외테스트D() {
        assertThrows(Exception.class, () -> {
            new Calculator("1       +  5  /");
        });
    }

    void 예외테스트E() {
        assertThrows(Exception.class, () -> {
            new Calculator("1 3 5");
        });
    }
}
