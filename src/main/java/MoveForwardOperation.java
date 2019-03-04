public class MoveForwardOperation implements LocationOperation {

    public MoveForwardOperation() {
    }

    @Override
    public Location execute(Location location) {
        return this.moveForward(location);
    }

    Location moveForward(Location location) {
        switch (location.direction) {
            case NORTH: {
                return moveNorth(location);
            }
            case EAST: {
                return moveEast(location);
            }
            case SOUTH: {
                return moveSouth(location);
            }
            case WEST: {
                return moveWest(location);
            }
            default:
                throw new UnsupportedOperationException();
        }
    }

    private Location moveNorth(Location location) {
        int newYCoordinate = location.yCoordinate + 1;
        if (isWrappingTop(newYCoordinate))
            newYCoordinate = teleportToBottom();
        return new Location(location.xCoordinate, newYCoordinate, location.direction);
    }

    private Location moveEast(Location location) {
        int newXCoordinate = location.xCoordinate + 1;
        if (isWrappingRight(newXCoordinate))
            newXCoordinate = teleportToLeft();
        return new Location(newXCoordinate, location.yCoordinate, location.direction);
    }

    private Location moveSouth(Location location) {
        int newYCoordinate = location.yCoordinate - 1;
        if (isWrappingBottom(newYCoordinate))
            newYCoordinate = teleportToTop();
        return new Location(location.xCoordinate, newYCoordinate, location.direction);
    }

    private Location moveWest(Location location) {
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
