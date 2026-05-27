package shell;

import command.CommandRegistry;
import utility.PathResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Shell {
    private final CommandRegistry registry;

    public Shell(CommandRegistry registry) {
        this.registry = registry;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            System.out.flush();

            if (!scanner.hasNextLine()) {
                break;
            }
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split(" ", 2);
            String commandName = parts[0];
            String[] cmdArgs = parts.length > 1 ? parts[1].split(" ") : new String[0];

            dispatch(commandName, cmdArgs);
        }
    }

    private void dispatch(String commandName, String[] cmdArgs) {
        registry.find(commandName)
                .ifPresentOrElse(
                        cmd -> cmd.execute(cmdArgs),
                        () -> PathResolver.resolve(commandName)
                                .ifPresentOrElse(
                                        _ -> runExternal(commandName, cmdArgs),
                                        () -> System.out.println(commandName + ": command not found")));
    }

    private void runExternal(String commandName, String[] cmdArgs) {
        List<String> commandList = new ArrayList<>();
        commandList.add(commandName);
        commandList.addAll(Arrays.asList(cmdArgs));
        try {
            new ProcessBuilder(commandList).inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
