package task13;

import java.util.ArrayList;

public class Calculator {

    public int id;

    public ArrayList<Operation> availableOperations;

    Operation add;
    Operation subtract;
    Operation divide;
    Operation multiply;

    public Calculator(int id) {
        this.id = id;
        this.availableOperations = new ArrayList<>();
        this.add = Operation.ADD;
        availableOperations.add(Operation.ADD);
        this.subtract = Operation.SUBTRACT;
        availableOperations.add(Operation.SUBTRACT);
        this.divide = Operation.DIVIDE;
        availableOperations.add(Operation.DIVIDE);
        this.multiply = Operation.MULTIPLY;
        availableOperations.add(Operation.MULTIPLY);
    }

}
