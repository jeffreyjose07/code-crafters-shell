package command;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandRegistry {
    private final Map<String, Command> commands = new HashMap<>();

    public void register(Command command) {
        commands.put(command.name(), command);
    }

    public Optional<Command> find(String name) {
        return Optional.ofNullable(commands.get(name));
    }
}
