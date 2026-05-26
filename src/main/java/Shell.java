import command.CommandRegistry;

import java.util.Scanner;

public class Shell {
    private final CommandRegistry registry = new CommandRegistry();

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("$ ");
        System.out.flush();

        String input = scanner.nextLine().trim();
        String[] parts = input.split(" ", 2);
        String commandName = parts[0];

        registry.find(commandName)
                .ifPresentOrElse(
                        cmd -> cmd.execute(parts.length > 1 ? parts[1].split(" ") : new String[0]),
                        () -> System.out.println(commandName + ": command not found")
                );

        scanner.close();
    }
}
