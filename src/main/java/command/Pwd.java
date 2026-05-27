package command;


public class Pwd implements Command {
    @Override
    public String name() {
        return "pwd";
    }

    @Override
    public void execute(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
}
