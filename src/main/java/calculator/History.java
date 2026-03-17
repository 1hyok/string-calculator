package calculator;

import java.util.List;

public class History {
    private final List<String> values;

    History(List<String> values) {
        this.values = values;
    }

    public void addValue(String value) {
        if (this.values.size() >= 10) {
            values.removeLast();
        }
        values.addFirst(value);
    }

    public List<String> getValues() {
        return values;
    }
}
