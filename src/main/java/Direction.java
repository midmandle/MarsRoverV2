public enum Direction {
    EAST("E"), SOUTH("S"), WEST("W"), NORTH("N");
    private String value;

    Direction(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    Direction rotateRight() {
        switch(this){
            case NORTH: {
                return EAST;
            }
            case EAST: {
                return SOUTH;
            }
            case SOUTH: {
                return WEST;
            }
            case WEST: {
                return NORTH;
            }
            default:
                throw new UnsupportedOperationException();
        }
    }

    Direction rotateLeft() {
        switch(this){
            case NORTH: {
                return WEST;
            }
            case EAST: {
                return NORTH;
            }
            case SOUTH: {
                return EAST;
            }
            case WEST: {
                return SOUTH;
            }
            default:
                throw new UnsupportedOperationException();
        }
    }
}