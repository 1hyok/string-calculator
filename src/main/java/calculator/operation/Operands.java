package calculator.operation;

import java.util.List;

public class Operands {
    private final List<Double> values;

    public Operands(List<Double> values) {
        this.values = values;
    }

    public double operate(Operator operator) {
        return values.stream()
                .reduce(operator::operate)
                .orElse(0.0);
    }
}
