public class RotateLeftOperation implements LocationOperation{
    private Location location;

    public RotateLeftOperation(Location location) {
        this.location = location;
    }

    @Override
    public Location execute() {
        return this.rotateLeft();
    }

    public Location rotateLeft() {
        return new Location(location.xCoordinate, location.yCoordinate, location.direction.rotateLeft());
    }
}
