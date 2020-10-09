package org.example.command;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/9 22:38
 */
public class TVOffCommand implements Command {

    TVReceiver tvReceiver;

    public TVOffCommand(TVReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    @Override
    public void execute() {
        this.tvReceiver.off();
    }

    @Override
    public void undo() {
        this.tvReceiver.on();
    }
}
