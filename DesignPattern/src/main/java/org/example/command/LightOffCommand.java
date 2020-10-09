package org.example.command;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/9 22:11
 */
public class LightOffCommand implements Command {

    LightReceiver lightReceiver;

    public LightOffCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        this.lightReceiver.off();
    }

    @Override
    public void undo() {
        this.lightReceiver.on();
    }
}
