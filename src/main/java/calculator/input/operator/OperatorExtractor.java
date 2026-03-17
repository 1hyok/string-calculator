package calculator.input.operator;

import calculator.operation.Operator;

public class OperatorExtractor {
    private final OperatorPart operatorPart;

    public OperatorExtractor(String operatorPart) {
        this.operatorPart = new OperatorPart(operatorPart);
    }

    public Operator extract() {
        return operatorPart.toOperator();
    }
}
