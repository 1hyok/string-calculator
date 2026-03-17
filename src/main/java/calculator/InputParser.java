package calculator;

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

    InputParser(String input) {
        List<String> inputTokenList = getInputTokenList(input);
        this.setOperandList(inputTokenList);
        String inputTokenFirst = inputTokenList.getFirst();
        char extractedOperator = new OperatorExtractor(inputTokenFirst).extract();
        OperationType operationType = OperationType.from(extractedOperator);
        this.operator = new Operator(operationType);
    }

    private void setOperandList(List<String> inputTokenList) {
        String inputTokenFirst = inputTokenList.getFirst();
        String inputTokenLast = inputTokenList.getLast();
        char delimiter = new DelimiterExtractor(inputTokenFirst).extract();
        String token = String.valueOf(delimiter);
        String[] operandPartTokens = inputTokenLast.split(token);
        List<Double> list = Arrays.stream(operandPartTokens)
                .map(Double::parseDouble)
                .toList();
        this.operands = new Operands(list);
    }

    private ArrayList<String> getInputTokenList(String input) {
        String inputToken = getInputToken(input);
        String[] inputTokenArray = input.split(inputToken);
        return new ArrayList<>(Arrays.asList(inputTokenArray));
    }

    private String getInputToken(String input) {
        if (input.contains("op=") && input.contains("\\|")) {
            return "\\|";
        }
        if (input.contains("//") && input.contains("\n")) {
            return "\n";
        }
        return "";
    }

    double operate() {
        return operands.operate(operator);
    }
}
