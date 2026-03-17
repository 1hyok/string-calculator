package calculator.inputparser;

public class OperatorExtractor {
    private final OperatorPart operatorPart;

    OperatorExtractor(String operatorPart) {
        this.operatorPart = new OperatorPart(operatorPart);
    }

    char extract() {
        if (!this.operatorPart.hasOperatorPrefix()) return '+';
        return this.operatorPart.symbolAt(3);
    }
}
