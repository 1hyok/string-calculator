package calculator.input;

import calculator.delimiter.DelimiterExtractor;
import calculator.operation.Operands;

import java.util.Arrays;
import java.util.List;

public class OperandParser {
    private final String inputTokenFirst;
    private final String inputTokenLast;

    OperandParser(String inputTokenFirst, String inputTokenLast) {
        this.inputTokenFirst = inputTokenFirst;
        this.inputTokenLast = inputTokenLast;
    }

    public Operands getOperandList() {
        String delimiterRegex = new DelimiterExtractor(this.inputTokenFirst).extract();
        String[] operandPartTokens = this.inputTokenLast.split(delimiterRegex);
        System.out.println("숫자 분리:" + Arrays.toString(operandPartTokens));

        try {
            List<Double> list = Arrays.stream(operandPartTokens)
                    .map(Double::parseDouble)
                    .peek(operand -> {
                        if (operand < 0) {
                            throw new IllegalArgumentException("음수는 입력할 수 없습니다");
                        }
                    })
                    .toList();
            return new Operands(list);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다");
        }
    }
}
