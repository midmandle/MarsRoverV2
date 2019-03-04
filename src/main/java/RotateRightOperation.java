public class RotateRightOperation implements LocationOperation{

    public RotateRightOperation() {
    }

    @Override
    public Location execute(Location location) {
        return this.rotateRight(location);
    }

    public Location rotateRight(Location location) {
        return new Location(location.xCoordinate, location.yCoordinate, location.direction.rotateRight());
    }
}
