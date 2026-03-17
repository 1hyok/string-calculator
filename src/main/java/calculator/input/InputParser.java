package calculator.input;

import calculator.delimiter.DelimiterExtractor;
import calculator.operation.Operands;
import calculator.operation.OperationType;
import calculator.operation.Operator;
import calculator.operation.OperatorExtractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 힌트: 입력 문자열 파싱을 담당하는 클래스.
 * 구분자 추출, 숫자 토큰 분리, 연산자 추출 등을 여기서 처리할 수 있다.
 * 반드시 이 클래스를 사용할 필요는 없다. 자유롭게 설계할 것.
 */
public class InputParser {
    private Operands operands;
    private final Operator operator;

    public InputParser(String input) {
        if (input == null || input.isEmpty()) {
            operands = new Operands(new ArrayList<>(List.of(0.0)));
            operator = new Operator(OperationType.from('+'));
            return;
        }
        InputTokenizer inputTokenizer = new InputTokenizer(input);
        List<String> inputTokenList = inputTokenizer.getInputTokenList();
        System.out.println("인풋을 둘로 나눔:" + inputTokenList);
        this.setOperandList(inputTokenList);
        String inputTokenFirst = inputTokenList.getFirst();
        OperatorExtractor operatorExtractor = new OperatorExtractor(inputTokenFirst);
        this.operator = operatorExtractor.extract();
    }

    private void setOperandList(List<String> inputTokenList) {
        String inputTokenFirst = inputTokenList.getFirst();
        String inputTokenLast = inputTokenList.getLast();
//        char delimiter = new DelimiterExtractor(inputTokenFirst).extract();
        String delimiterRegex = new DelimiterExtractor(inputTokenFirst).extract();
//        String delimiterRegex = "[:," + delimiter + "]";
        String[] operandPartTokens = inputTokenLast.split(delimiterRegex);
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
            this.operands = new Operands(list);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다");
        }
    }

    public double operate() {
        return operands.operate(operator);
    }
}
