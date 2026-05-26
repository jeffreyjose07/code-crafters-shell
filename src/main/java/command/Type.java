package command;

public class Type implements Command {

    private final CommandRegistry commandRegistry;

    public Type(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

    @Override
    public String name() {
        return "type";
    }

    @Override
    public void execute(String[] args) {
        commandRegistry.find(args[0])
                .ifPresentOrElse(cmd -> System.out.println(args[0] + " is a shell builtin"),
                        () -> System.out.println(args[0] + ": not found"));
    }
}
