package calculator.delimiter;

public class DelimiterExtractor {
    private final DelimiterPart delimiterPart;

    public DelimiterExtractor(String delimiterPart) {
        System.out.println("디리미터파트:" + delimiterPart);
        this.delimiterPart = new DelimiterPart(delimiterPart);
    }

    public String extract() {
        return this.delimiterPart.getDelimiterRegex();
    }
}
