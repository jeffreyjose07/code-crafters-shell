package utility;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

public class PathResolver {
    public static Optional<Path> resolve(String commandName) {
        return Arrays.stream(System.getenv("PATH").split(File.pathSeparator))
                .map(dir -> Path.of(dir, commandName))
                .filter(Files::isExecutable)
                .findFirst();
    }
}
