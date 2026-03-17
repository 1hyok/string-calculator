package calculator.delimiter;

public class DelimiterPart {
    private final String value;

    DelimiterPart(String value) {
        this.value = value;
    }

    private boolean hasDelimiterPrefix() {
        return this.value.contains("//");
    }

    String getDelimiterRegex() {
        if (!this.hasDelimiterPrefix()) {
            return "[:,]";
        }
        return "[:," + this.value.charAt(2) + "]";
    }
}
