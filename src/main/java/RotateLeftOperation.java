public class RotateLeftOperation implements LocationOperation{

    public RotateLeftOperation() {
    }

    @Override
    public Location execute(Location location) {
        return this.rotateLeft(location);
    }

    public Location rotateLeft(Location location) {
        return new Location(location.xCoordinate, location.yCoordinate, location.direction.rotateLeft());
    }
}
