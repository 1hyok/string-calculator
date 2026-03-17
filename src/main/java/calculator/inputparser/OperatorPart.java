package calculator.inputparser;

public class OperatorPart {
    String value;
    OperatorPart(String value){
        this.value = value;
    }

    boolean hasOperatorPrefix(){
        return this.value.contains("op=");
    }

    char symbolAt(int index){
        return this.value.charAt(index);
    }
}