public class Rover {
    private Location location;
    private final CommandExecutor commandExecutor;

    public Rover() {
        location = new Location(0, 0, Direction.NORTH);
        commandExecutor = new CommandExecutor();
    }

    public String executeCommands(String commands) {
        for (char command : commands.toCharArray()) {
            if(command == RoverCommand.MOVE_FORWARD)
                this.location = commandExecutor.execute(new MoveForwardOperation(this.location));
            if(command == RoverCommand.ROTATE_LEFT)
                this.location = commandExecutor.execute(new RotateLeftOperation(this.location));
            if(command == RoverCommand.ROTATE_RIGHT)
                this.location = commandExecutor.execute(new RotateRightOperation(this.location));
        }

        return location.toString();
    }
}
