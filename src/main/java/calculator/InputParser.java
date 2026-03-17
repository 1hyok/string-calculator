package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 힌트: 입력 문자열 파싱을 담당하는 클래스.
 * 구분자 추출, 숫자 토큰 분리, 연산자 추출 등을 여기서 처리할 수 있다.
 * 반드시 이 클래스를 사용할 필요는 없다. 자유롭게 설계할 것.
 */
public class InputParser {
    //    private String input = "";
//    private String inputToken = "";
//    private List<String> inputTokenList;

//    private String numberPart = "";
//    private String operatorPart = "";
//    private String delimiterPart = "";

//    private char delimiter;

    private List<Integer> numberList = new ArrayList<>(List.of(0));
    private char operator = '+';


    InputParser(String input) {
        List<String> inputTokenList = getInputTokenList(input);
        getNumberList(inputTokenList);
        setOperator(inputTokenList);
    }

    private void getNumberList(List<String> inputTokenList) {
        char delimiter = getDelimiter(inputTokenList);
        String numberPart = inputTokenList.getLast();
        String[] numberPartTokens = numberPart.split(String.valueOf(delimiter));
        this.numberList = Arrays.stream(numberPartTokens)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void setOperator(List<String> inputTokenList) {
        String operatorPart = inputTokenList.getFirst();
        if (!operatorPart.contains("op=")) return;
        this.operator = operatorPart.charAt(3);
    }

    private ArrayList<String> getInputTokenList(String input) {
        String inputToken = getInputToken(input);
        String[] inputTokenArray = input.split(inputToken);
        return new ArrayList<>(Arrays.asList(inputTokenArray));
    }

//    private String getNonNumberPart() {
//        if (input.contains("op=") && input.contains("\\|")) {
//            return getOperatorPart();
//        }
//        if (input.contains("//") && input.contains("\n")) {
//            return getDelimiterPart();
//        }
//    }

    private String getInputToken(String input) {
        if (input.contains("op=") && input.contains("\\|")) {
            return "\\|";
        }
        if (input.contains("//") && input.contains("\n")) {
            return "\n";
        }
        return "";
    }

    private char getDelimiter(List<String> inputTokenList) {
        String delimiterPart = inputTokenList.getFirst();
        if (delimiterPart.compareTo("") == 0) {
            return ',';
        }
        return delimiterPart.charAt(2);
    }
}
