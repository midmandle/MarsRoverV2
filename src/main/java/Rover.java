public class Rover {

    public static final char ROTATE_LEFT = 'L';
    public static final char ROTATE_RIGHT = 'R';
    private Integer xCoordinate;
    private Integer yCoordinate;
    private Direction direction;

    public Rover() {
        xCoordinate = 0;
        yCoordinate = 0;
        direction = Direction.NORTH;
    }

    public String executeCommands(String commands) {
        for (char command : commands.toCharArray()) {
            if(command == ROTATE_LEFT)
                this.direction = this.direction.rotateLeft();
            if(command == ROTATE_RIGHT)
                this.direction = this.direction.rotateRight();
        }

        return this.generateCurrentLocation();
    }

    private String generateCurrentLocation() {
        return this.xCoordinate + "," + this.yCoordinate + "," + this.direction;
    }
}
