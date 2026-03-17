package calculator.operation;

public class OperatorPart {
    String value;

    OperatorPart(String value) {
        this.value = value;
    }

    boolean hasOperatorPrefix() {
        return this.value.contains("op=");
    }

    char getOperator() {
        return this.value.charAt(3);
    }
}