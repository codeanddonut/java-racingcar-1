package calc;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {
    private static final String DELIMITER = "\\s+";

    private double result;

    Calculator(String expression) {
        try {
            final Queue<String> tokens = Stream.of(expression.split(DELIMITER))
                                                .filter(token -> token.length() > 0)
                                                .collect(Collectors.toCollection(LinkedList::new));
            this.result = extractNumber(tokens);
            calculate(tokens);
        } catch (
                IndexOutOfBoundsException
                        | NoSuchElementException
                        | NullPointerException
                        | NumberFormatException e
        ) {
            throw new IllegalArgumentException();
        }
    }

    private double extractNumber(Queue<String> tokens) {
        return Double.parseDouble(tokens.poll());
    }
    private boolean calculate(Queue<String> tokens) {
        this.result = Operation.ofSymbol(tokens.poll()).apply(this.result, extractNumber(tokens));
        return tokens.isEmpty() || calculate(tokens);
    }

    public double result() {
        return this.result;
    }

    @Override
    public String toString() {
        return String.valueOf(this.result);
    }
}