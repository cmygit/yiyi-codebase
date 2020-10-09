package org.example.command;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/9 22:17
 */
public class RemoteController {

    Command[] onCommands;

    Command[] offCommands;

    Command undoCommand;

    public RemoteController() {
        int count = 5;
        this.onCommands = new Command[count];
        this.offCommands = new Command[count];

        for (int i = 0; i < count; i++) {
            this.onCommands[i] = new NoCommand();
            this.offCommands[i] = new NoCommand();
        }
    }

    public void setCommand(int no, Command onCommand, Command offCommand) {
        this.onCommands[no] = onCommand;
        this.offCommands[no] = offCommand;
    }

    public void onButtonWasPushed(int no) {
        // 调用按钮对应的方法
        this.onCommands[no].execute();
        // 记录这次操作，用于撤销
        this.undoCommand = this.onCommands[no];
    }

    public void offButtonWasPushed(int no) {
        this.offCommands[no].execute();
        this.undoCommand = this.offCommands[no];
    }

    public void undoButtonWasPushed() {
        this.undoCommand.undo();
    }
}
