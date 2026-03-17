package calculator.inputparser;

public class DelimiterPart {
    String value;

    DelimiterPart(String value) {
        this.value = value;
    }

    boolean hasDelimiterPrefix() {
        return this.value.contains("//") && this.value.contains("\n");
    }

    char symbolAt(int index) {
        return this.value.charAt(index);
    }
}
