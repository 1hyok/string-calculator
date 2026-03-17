package calculator.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputTokenizer {
    final private String input;

    InputTokenizer(String input) {
        this.input = input;
    }

    private String getInputToken() {
        if (this.input.contains("op=") && this.input.contains("|")) {
            System.out.println("커스텀 연산자 받음");
            return "\\|";
        }
        if (this.input.contains("//") && this.input.contains("\n")) {
            System.out.println("커스텀 구분자 받음");
            return "\n";
        }
        System.out.println("커스텀 아무 것도 안 받음");
        return "";
    }

    ArrayList<String> getInputTokenList() {
        String inputToken = this.getInputToken();
        System.out.println("인풋 토큰:" + inputToken);
        if (inputToken.isEmpty()) {
            return new ArrayList<>(List.of("", this.input));
        }
        String[] inputTokenArray = this.input.split(inputToken);
        return new ArrayList<>(Arrays.asList(inputTokenArray));
    }

}
