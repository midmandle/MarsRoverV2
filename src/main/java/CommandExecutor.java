public class CommandExecutor {
    public CommandExecutor() {
    }

    public Location execute(LocationOperation operation) {
        return operation.execute();
    }
}
