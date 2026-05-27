package command;

public class Exit implements Command {
    @Override
    public String name() {
        return "exit";
    }

    @Override
    public void execute(String[] args) {
        System.exit(0);
    }
}
