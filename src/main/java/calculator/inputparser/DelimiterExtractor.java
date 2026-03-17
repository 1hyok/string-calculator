package calculator.inputparser;

public class DelimiterExtractor {
    private final DelimiterPart delimiterPart;

    DelimiterExtractor(String delimiterPart) {
        this.delimiterPart = new DelimiterPart(delimiterPart);
    }

    char extract() {
        if (this.delimiterPart.hasDelimiterPrefix()) {
            return ',';
        }
        return this.delimiterPart.symbolAt(2);
    }
}
