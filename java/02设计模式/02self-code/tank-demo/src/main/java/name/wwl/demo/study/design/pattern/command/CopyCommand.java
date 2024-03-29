package name.wwl.demo.study.design.pattern.command;

public class CopyCommand extends Command {
    Content c;

    public CopyCommand(Content c){
        this.c = c;
    }


    @Override
    public void doIt() {
        c.msg = c.msg+c.msg;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length()/2);
    }
}
