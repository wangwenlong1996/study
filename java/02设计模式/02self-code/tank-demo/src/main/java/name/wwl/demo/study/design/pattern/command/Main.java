package name.wwl.demo.study.design.pattern.command;

public class Main {

    public static void main(String[] args) {
        Content c = new Content();

        Command insertCommand = new InsertCommand(c);
        insertCommand.doIt();
        insertCommand.undo();

        Command copyCommand = new CopyCommand(c);
        insertCommand.doIt();
        insertCommand.undo();

        Command deleteCommand = new DeleteCommand(c);
        deleteCommand.doIt();
        deleteCommand.undo();

        System.out.println(c.msg);
    }
}


