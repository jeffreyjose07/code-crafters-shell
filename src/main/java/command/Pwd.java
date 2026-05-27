package command;

import java.nio.file.Path;

public class Pwd implements Command{
    @Override
    public String name() {
        return "pwd";
    }

    @Override
    public void execute(String[] args) {
        String presentWorkingDirectory = Path.of("").toAbsolutePath().toString();
        System.out.println(presentWorkingDirectory);
    }
}
