package calc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CalculatorTest {
    @Test
    void additionTest() {
        assertThat(
                new Calculator("  1 +    2 + 3").result()
        ).isEqualTo(6.0);
    }

    @Test
    void subtractionTest() {
        assertThat(
                new Calculator("1 -   3").result()
        ).isEqualTo(-2.0);
    }

    @Test
    void multiplicationTest() {
        assertThat(
                new Calculator("1   * -3").result()
        ).isEqualTo(-3.0);
    }

    @Test
    void divisionTest() {
        assertThat(
                new Calculator("  12 /   3").result()
        ).isEqualTo(4.0);
    }

    @Test
    void divisionExceptionTestA() {
        assertThatThrownBy(() -> new Calculator("11 /   0"));
    }

    @Test
    void divisionExceptionTestB() {
        assertThatThrownBy(() -> new Calculator("0        /   0"));
    }

    @Test
    void divisionExceptionTestC() {
        assertThatThrownBy(() -> new Calculator("1 /  0 + 1"));
    }

    @Test
    void expressionTest() {
        assertThat(
                new Calculator("1 - 3 * 6 + 6 / 2").result()
        ).isEqualTo(-3.0);
    }

    @Test
    void exceptionTestA() {
        assertThatThrownBy(() -> new Calculator("-"));
    }

    @Test
    void exceptionTestB() {
        assertThatThrownBy(() -> new Calculator("1 +"));
    }

    @Test
    void exceptionTestC() {
        assertThatThrownBy(() -> new Calculator("1 + /"));
    }

    @Test
    void exceptionTestD() {
        assertThatThrownBy(() -> new Calculator("1       +  5  /"));
    }

    @Test
    void exceptionTestE() {
        assertThatThrownBy(() -> new Calculator("1 3 5"));
    }
}