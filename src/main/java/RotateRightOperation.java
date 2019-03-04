public class RotateRightOperation implements LocationOperation{
    private Location location;

    public RotateRightOperation() {
    }

    @Override
    public Location execute(Location location) {
        this.location = location;
        return this.rotateRight();
    }

    public Location rotateRight() {
        return new Location(location.xCoordinate, location.yCoordinate, location.direction.rotateRight());
    }
}
