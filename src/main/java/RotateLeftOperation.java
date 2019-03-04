public class RotateLeftOperation implements LocationOperation{
    private Location location;

    public RotateLeftOperation() {
    }

    @Override
    public Location execute(Location location) {
        this.location = location;
        return this.rotateLeft();
    }

    public Location rotateLeft() {
        return new Location(location.xCoordinate, location.yCoordinate, location.direction.rotateLeft());
    }
}
