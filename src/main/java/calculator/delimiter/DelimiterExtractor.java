package calculator.delimiter;

public class DelimiterExtractor {
    private final DelimiterPart delimiterPart;

    public DelimiterExtractor(String delimiterPart) {
        System.out.println("디리미터파트:" + delimiterPart);
        this.delimiterPart = new DelimiterPart(delimiterPart);
    }

    public char extract() {
        if (!this.delimiterPart.hasDelimiterPrefix()) {
            return ',';
        }
        return this.delimiterPart.getDelimiter();
    }
}
