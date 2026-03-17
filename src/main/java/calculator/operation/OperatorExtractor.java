package calculator.operation;

public class OperatorExtractor {
    private final OperatorPart operatorPart;

    public OperatorExtractor(String operatorPart) {
        this.operatorPart = new OperatorPart(operatorPart);
    }

    public Operator extract() {
        return operatorPart.toOperator();
    }
}
