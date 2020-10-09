package org.example.command;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/9 22:08
 */
public class LightOnCommand implements Command {

    LightReceiver lightReceiver;

    public LightOnCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        this.lightReceiver.on();
    }

    @Override
    public void undo() {
        this.lightReceiver.off();
    }
}
