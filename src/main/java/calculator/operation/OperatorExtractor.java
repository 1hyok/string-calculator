package calculator.operation;

public class OperatorExtractor {
    private final OperatorPart operatorPart;

    public OperatorExtractor(String operatorPart) {
        this.operatorPart = new OperatorPart(operatorPart);
    }

    public char extract() {
        if (!this.operatorPart.hasOperatorPrefix()) return '+';
        return this.operatorPart.symbolAt(3);
    }
}
