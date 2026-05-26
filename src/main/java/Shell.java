import command.CommandRegistry;

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

            if (!scanner.hasNextLine()) break;
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            String[] parts = input.split(" ", 2);
            String commandName = parts[0];
            String[] cmdArgs = parts.length > 1 ? parts[1].split(" ") : new String[0];

            registry.find(commandName)
                    .ifPresentOrElse(
                            cmd -> cmd.execute(cmdArgs),
                            () -> System.out.println(commandName + ": command not found"));
        }
    }
}
