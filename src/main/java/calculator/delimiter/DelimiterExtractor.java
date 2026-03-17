package calculator.delimiter;

public class DelimiterExtractor {
    private final DelimiterPart delimiterPart;

    public DelimiterExtractor(String delimiterPart) {
        this.delimiterPart = new DelimiterPart(delimiterPart);
    }

    public char extract() {
        if (!this.delimiterPart.hasDelimiterPrefix()) {
            return ',';
        }
        return this.delimiterPart.symbolAt(2);
    }
}
