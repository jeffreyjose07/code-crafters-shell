package command;

import java.nio.file.Path;

public class Pwd implements Command {
    @Override
    public String name() {
        return "pwd";
    }

    @Override
    public void execute(String[] args) {
        System.out.println(Path.of("").toAbsolutePath());
    }
}
