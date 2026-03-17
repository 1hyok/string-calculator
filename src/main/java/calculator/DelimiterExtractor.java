package calculator;

public class DelimiterExtractor {
    private final String delimiterPart;
    DelimiterExtractor(String delimiterPart){
        this.delimiterPart = delimiterPart;
    }
    public char extract() {
        if (this.delimiterPart.compareTo("") == 0) {
            return ',';
        }
        return this.delimiterPart.charAt(2);
    }
}
