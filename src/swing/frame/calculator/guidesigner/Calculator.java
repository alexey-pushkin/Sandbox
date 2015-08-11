package swing.frame.calculator.guidesigner;

public class Calculator {

    private Double valueA;
    private Double valueB;
    private Operation operation;
    private Double result;

    public enum Operation { ADD, SUBTRACT, MULTIPLY, DIVIDE }

    public void addValue(double input) {
        if (operation == null) {
            valueA = input;
        } else {
            valueB = input;
        }
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Double getResult() {

        if (valueB == null) {
            valueB = valueA;
            valueA = 0.0;
        }


        switch (operation) {
            case ADD: result = valueA + valueB; break;
            case SUBTRACT: result = valueA - valueB; break;
            case MULTIPLY: result = valueA * valueB; break;
            case DIVIDE: result = valueA / valueB; break;
            default: result = 0.0;
        }

        valueA = result;

        return result;
    }
}
