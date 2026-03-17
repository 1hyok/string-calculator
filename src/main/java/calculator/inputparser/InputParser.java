package calculator.inputparser;

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
    private Operator operator;

    InputParser(String input) {
        List<String> inputTokenList = getInputTokenList(input);
        this.setOperandList(inputTokenList);
        String inputTokenFirst = inputTokenList.getFirst();
        char extractedOperator = new OperatorExtractor(inputTokenFirst).extract();
        this.operator = new Operator(extractedOperator);
    }

    private void setOperandList(List<String> inputTokenList) {
        String inputTokenFirst = inputTokenList.getFirst();
        String inputTokenLast = inputTokenList.getLast();
        char delimiter = new DelimiterExtractor(inputTokenFirst).extract();
        String token = String.valueOf(delimiter);
        String[] operandPartTokens = inputTokenLast.split(token);
        List<Integer> list = Arrays.stream(operandPartTokens)
                .map(Integer::parseInt)
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
}
