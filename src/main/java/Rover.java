import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Rover {
    private Location location;

    public Rover() {
        location = new Location(0, 0, Direction.NORTH);
    }

    public String executeCommands(String commands) {
        Queue<LocationOperation> operations = generateOperations(commands);

        this.location = executeOperations(operations);

        return location.toString();
    }

    private Queue<LocationOperation> generateOperations(String commands) {
        Queue<LocationOperation> generatedOperations = new LinkedBlockingQueue<>();

        for (char command : commands.toCharArray()) {
            LocationOperation operation = getOperationFor(command);
            generatedOperations.add(operation);
        }

        return generatedOperations;
    }

    private LocationOperation getOperationFor(char command) {
        switch(command) {
            case RoverCommand.MOVE_FORWARD:{
                return new MoveForwardOperation();
            }
            case RoverCommand.ROTATE_LEFT:{
                return new RotateLeftOperation();
            }
            case RoverCommand.ROTATE_RIGHT:{
                return new RotateRightOperation();
            }
            default:
                throw new UnsupportedOperationException();
        }
    }

    private Location executeOperations(Queue<LocationOperation> operations) {
        Location currentLocation = this.location;

        for (LocationOperation operation :
                operations) {
            currentLocation = operation.execute(currentLocation);
        }

        return currentLocation;
    }

}
