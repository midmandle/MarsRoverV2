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
            if(command == 'M')
                this.moveForward();
            if(command == ROTATE_LEFT)
                this.direction = this.direction.rotateLeft();
            if(command == ROTATE_RIGHT)
                this.direction = this.direction.rotateRight();
        }

        return this.generateCurrentLocation();
    }

    private void moveForward() {
        switch (this.direction){
            case NORTH:{
                yCoordinate += 1;
                break;
            }
            case EAST:{
                xCoordinate += 1;
                break;
            }
            case SOUTH:{
                yCoordinate -= 1;
                break;
            }
            case WEST:{
                xCoordinate -= 1;
                break;
            }
            default:
                throw new UnsupportedOperationException();
        }

        if(xCoordinate < 0)
            xCoordinate = 9;
        if(yCoordinate < 0)
            yCoordinate = 9;
        if(xCoordinate > 9)
            xCoordinate = 0;
        if(yCoordinate > 9)
            yCoordinate = 0;
    }

    private String generateCurrentLocation() {
        return this.xCoordinate + "," + this.yCoordinate + "," + this.direction;
    }
}
