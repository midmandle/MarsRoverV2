public class RotateRightOperation implements LocationOperation{
    private Location location;

    public RotateRightOperation(Location location) {
        this.location = location;
    }

    @Override
    public Location execute() {
        return this.rotateRight();
    }

    public Location rotateRight() {
        return new Location(location.xCoordinate, location.yCoordinate, location.direction.rotateRight());
    }
}
