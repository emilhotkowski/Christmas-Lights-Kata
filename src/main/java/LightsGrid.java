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

    public int getLights(Rectangle rectangle) {
        // Slow implementation of toggling manually all lights in the rectangle
        int total = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (isLightOn(x, y)) {
                    total++;
                }
            }
        }
        return total;
    }

    private boolean isLightOn(int x, int y) {
        for (Operation operation : operations) {
            if (operation.getRectangle().contains(x, y)) {
                return operation.getOperationType() == Operation.OperationType.TURN_ON;
            }
        }
        return false;
    }
}
