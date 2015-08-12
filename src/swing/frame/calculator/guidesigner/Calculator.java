package swing.frame.calculator.guidesigner;

public class Calculator {

    private Double valueA;
    private Double valueB;
    private Operation operation;
    private Double result;
    private Boolean isEmpty = true;

    private Boolean isATurn = true;
    private Boolean isBTurn = false;



    public enum Operation { ADD, SUBTRACT, MULTIPLY, DIVIDE }

    public void addValue(double input) {
        if (isATurn) {
            valueA = input;
        } else {
            valueB = input;
        }
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
        isATurn = false;
        isBTurn = true;
    }

    public Double getResult() {

        switch (operation) {
            case ADD: result = valueA + valueB; break;
            case SUBTRACT: result = valueA - valueB; break;
            case MULTIPLY: result = valueA * valueB; break;
            case DIVIDE: result = valueA / valueB; break;
            default: result = 0.0;
        }

        valueA = result;
        isATurn = true;
        isBTurn = false;

        return result;
    }

    public void clearEntry() {
        if (isATurn) {
            valueA = null;
        } else {
            valueB = null;
        }
    }

    public void clearAll() {
        valueA = null;
        valueB = null;
        operation = null;
        isATurn = true;
        isBTurn = false;
    }
}
