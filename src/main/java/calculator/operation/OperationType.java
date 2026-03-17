package calculator.operation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

/**
 * 힌트: 연산자 종류를 나타내는 enum.
 * +, -, *, / 를 표현하고, 각 연산자에 맞는 계산을 수행할 수 있다.
 * 반드시 이 클래스를 사용할 필요는 없다. 자유롭게 설계할 것.
 */
public enum OperationType {
    ADD('+', Double::sum),
    SUBTRACT('-', (a, b) -> a - b),
    MULTIPLY('*', (a, b) -> a * b),
    DIVIDE('/', (a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }
        double result = a / b;
        return BigDecimal.valueOf(result)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
    });

    private final char symbol;
    private final DoubleBinaryOperator operation;

    OperationType(char symbol, DoubleBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static OperationType from(char symbol) {
        return Arrays.stream(values())
                .filter(s -> s.symbol == symbol)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다:"));
    }

    public double operate(double operand1, double operand2) {
        return operation.applyAsDouble(operand1, operand2);
    }
}
