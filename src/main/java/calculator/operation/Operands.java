package calculator.operation;

import java.util.List;

public class Operands {
    private final List<Double> values;

    public Operands(List<Double> values) {
        this.values = values;
    }

    public double operate(Operator operator) {
        double result = 0;
        boolean first = true;
        for (double value : this.values) {
            if (first) {
                result = value;
                first = false;
                continue;
            }
            result = operator.operate(result, value);
        }
        return result;
    }
}
