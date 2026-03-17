package calculator;

public class OperatorExtractor {
    private final String operatorPart;

    OperatorExtractor(String operatorPart) {
        this.operatorPart = operatorPart;
    }

    public char extract() {
        if (!operatorPart.contains("op=")) return '+';
        return operatorPart.charAt(3);
    }
}
