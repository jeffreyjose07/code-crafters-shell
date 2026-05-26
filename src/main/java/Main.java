import command.CommandRegistry;
import command.Echo;
import command.Exit;

public class Main {
    public static void main(String[] args) {
        new Shell(CommandRegistry.of(
                new Exit(),
                new Echo()
        )).run();
    }
}
