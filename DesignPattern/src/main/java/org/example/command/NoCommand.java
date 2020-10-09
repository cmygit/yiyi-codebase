package org.example.command;

/**
 * @Title: 没有任何命令，即空执行，用于初始化组件
 * @Author: cmy
 * @Date: 2020/10/9 22:12
 */
public class NoCommand implements Command {

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
