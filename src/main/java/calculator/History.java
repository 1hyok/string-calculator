package calculator;

import java.util.ArrayList;
import java.util.List;

public class History {
    private final List<String> values;

    History() {
        this.values = new ArrayList<>();
    }

    public void addValue(String value) {
        if (values.size() == 10) {
            values.removeLast();
        }
        values.addFirst(value);
    }

    public List<String> getValues() {
        return values;
    }
}
