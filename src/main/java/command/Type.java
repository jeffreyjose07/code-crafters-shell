package command;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

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
                .ifPresentOrElse(_ -> System.out.println(args[0] + " is a shell builtin"),
                        searchPath(args));
    }

    private Runnable searchPath(String[] args) {
        return () -> Arrays.stream(System.getenv("PATH").split(File.pathSeparator))
                .map(dir -> Path.of(dir, args[0]))
                .filter(Files::isExecutable)
                .findFirst()
                .ifPresentOrElse(
                        path -> System.out.println(args[0] + " is " + path),
                        () -> System.out.println(args[0] + ": not found"));
    }
}
