package calculator.delimiter;

public class DelimiterPart {
    String value;

    DelimiterPart(String value) {
        this.value = value;
    }

    boolean hasDelimiterPrefix() {
        return this.value.contains("//");
    }

    char getDelimiter() {
        return this.value.charAt(2);
    }
}
