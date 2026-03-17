package calculator.input.operator;

import calculator.operation.OperationType;
import calculator.operation.Operator;

public class OperatorPart {
    private final String value;

    OperatorPart(String value) {
        this.value = value;
    }

    private boolean hasOperatorPrefix() {
        return this.value.contains("op=");
    }

    Operator toOperator() {
        if (!this.hasOperatorPrefix()) {
            OperationType operationType = OperationType.from('+');
            return new Operator(operationType);
        }
        return new Operator(OperationType.from(this.value.charAt(3)));
    }
}