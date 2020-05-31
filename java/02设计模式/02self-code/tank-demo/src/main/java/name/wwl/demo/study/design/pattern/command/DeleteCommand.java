package name.wwl.demo.study.design.pattern.command;

public class DeleteCommand extends Command {

    Content content;

    String deleted;
    public DeleteCommand(Content content) {
        this.content = content;
    }

    @Override
    public void doIt() {
        deleted = content.msg.substring(0,5);

        content.msg = content.msg.substring(5,content.msg.length());
    }

    @Override
    public void undo() {

        content.msg = deleted+content.msg;

    }
}
