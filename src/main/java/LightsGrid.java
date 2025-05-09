import java.util.ArrayList;
import java.util.List;

public class LightsGrid {

    private final int width;
    private final int height;
    private final List<Operation> operations;

    public LightsGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.operations = new ArrayList<>();
    }

    public void turnOnLights(Rectangle rectangle) {
        operations.add(new Operation(rectangle, Operation.OperationType.TURN_ON));
    }

    public void toggleLights(Rectangle rectangle) {
        operations.add(new Operation(rectangle, Operation.OperationType.TOGGLE));
    }

    public void turnOffLights(Rectangle rectangle) {
        operations.add(new Operation(rectangle, Operation.OperationType.TURN_OFF));
    }

    public int getLights(Rectangle rectangle) {
        // Slow implementation of toggling manually all lights in the rectangle
        int total = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                total += lightState(x, y);
            }
        }
        return total;
    }

    private int lightState(int x, int y) {
        int state = 0;
        for (Operation operation : operations) {
            if (operation.getRectangle().contains(x, y)) {
                if (operation.getOperationType() == Operation.OperationType.TURN_ON) {
                    state += 1;
                } else if (operation.getOperationType() == Operation.OperationType.TOGGLE) {
                    state += 2;
                } else if (operation.getOperationType() == Operation.OperationType.TURN_OFF) {
                    state = Math.max(0, state - 1);
                }
            }
        }
        return state;
    }
}
