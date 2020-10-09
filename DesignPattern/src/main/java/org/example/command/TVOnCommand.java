package org.example.command;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/9 22:38
 */
public class TVOnCommand implements Command {

    TVReceiver tvReceiver;

    public TVOnCommand(TVReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    @Override
    public void execute() {
        this.tvReceiver.on();
    }

    @Override
    public void undo() {
        this.tvReceiver.off();
    }
}
