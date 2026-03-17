package calculator.operation;

public class Operator {
    private final OperationType value;

    public Operator(OperationType value) {
        this.value = value;
    }

    public double operate(double operand1, double operand2) {
        return this.value.operate(operand1, operand2);
    }
}
