package command;

public class Echo implements Command {
    @Override
    public String name() {
        return "echo";
    }

    @Override
    public void execute(String[] args) {
        System.out.println(String.join(" ", args));
    }
}
