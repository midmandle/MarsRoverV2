public class Location {
    Integer xCoordinate;
    Integer yCoordinate;
    Direction direction;

    public Location(int xCoordinate, int yCoordinate, Direction direction) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return this.xCoordinate + "," + this.yCoordinate + "," + this.direction;
    }
}