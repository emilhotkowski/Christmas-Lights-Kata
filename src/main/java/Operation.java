public class Operation {

    private final Rectangle rectangle;
    private final OperationType operationType;

    public Operation(Rectangle rectangle, OperationType operationType) {
        this.rectangle = rectangle;
        this.operationType = operationType;
    }

    public enum OperationType {
        TURN_ON,
        TOGGLE
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public OperationType getOperationType() {
        return operationType;
    }
}
