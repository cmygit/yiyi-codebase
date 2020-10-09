package org.example.command;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/9 22:07
 */
public interface Command {

    void execute();

    void undo();
}
