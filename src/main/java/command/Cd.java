package command;

import java.nio.file.Files;
import java.nio.file.Path;

public class Cd implements Command{
    @Override
    public String name() {
        return "cd";
    }

    @Override
    public void execute(String[] args) {
        Path target = Path.of(System.getProperty("user.dir")).resolve(args[0]).normalize();
        if (Files.isDirectory(target)) {
            System.setProperty("user.dir", target.toString());
        } else {
            System.out.println("cd: " + args[0] + ": No such file or directory");
        }
    }
}
