import command.CommandRegistry;
import command.Echo;
import command.Exit;
import command.Type;
import shell.Shell;

public class Main {
    public static void main(String[] args) {
        CommandRegistry registry = CommandRegistry.of(new Exit(), new Echo());
        registry.register(new Type(registry));

        new Shell(registry).run();
    }
}
