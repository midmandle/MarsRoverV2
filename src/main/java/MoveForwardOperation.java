public class MoveForwardOperation implements LocationOperation {
    private Location location;

    public MoveForwardOperation(Location location) {
        this.location = location;
    }

    @Override
    public Location execute() {
        return this.moveForward();
    }

    Location moveForward() {
        switch (location.direction) {
            case NORTH: {
                return moveNorth();
            }
            case EAST: {
                return moveEast();
            }
            case SOUTH: {
                return moveSouth();
            }
            case WEST: {
                return moveWest();
            }
            default:
                throw new UnsupportedOperationException();
        }
    }

    private Location moveNorth() {
        int newYCoordinate = location.yCoordinate + 1;
        if (isWrappingTop(newYCoordinate))
            newYCoordinate = teleportToBottom();
        return new Location(location.xCoordinate, newYCoordinate, location.direction);
    }

    private Location moveEast() {
        int newXCoordinate = location.xCoordinate + 1;
        if (isWrappingRight(newXCoordinate))
            newXCoordinate = teleportToLeft();
        return new Location(newXCoordinate, location.yCoordinate, location.direction);
    }

    private Location moveSouth() {
        int newYCoordinate = location.yCoordinate - 1;
        if (isWrappingBottom(newYCoordinate))
            newYCoordinate = teleportToTop();
        return new Location(location.xCoordinate, newYCoordinate, location.direction);
    }

    private Location moveWest() {
        int newXCoordinate = location.xCoordinate - 1;
        if (isWrappingLeft(newXCoordinate))
            newXCoordinate = teleportToRight();
        return new Location(newXCoordinate, location.yCoordinate, location.direction);
    }

    int teleportToBottom() {
        return 0;
    }

    int teleportToLeft() {
        return 0;
    }

    int teleportToTop() {
        return 9;
    }

    int teleportToRight() {
        return 9;
    }

    boolean isWrappingTop(int yCoordinate) {
        return yCoordinate > 9;
    }

    boolean isWrappingRight(int xCoordinate) {
        return xCoordinate > 9;
    }

    boolean isWrappingBottom(int yCoordinate) {
        return yCoordinate < 0;
    }

    boolean isWrappingLeft(int xCoordinate) {
        return xCoordinate < 0;
    }
}
