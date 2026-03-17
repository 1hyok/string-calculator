package calculator;

import java.util.List;

/**
 * 진입점. 흐름 조율만 담당한다.
 * 파싱, 계산, 이력 관리를 직접 구현하지 말 것.
 * 각 책임은 별도 클래스에 위임할 것.
 */
public class StringCalculator {
    private final History history = new History();

    public double calculate(String input) {
//        throw new UnsupportedOperationException("구현 필요");
        history.addValue(input);
        InputParser inputParser = new InputParser(input);
        return inputParser.operate();
    }

    public List<String> getHistory() {

//        throw new UnsupportedOperationException("구현 필요");
        return history.getValues();
    }
}
