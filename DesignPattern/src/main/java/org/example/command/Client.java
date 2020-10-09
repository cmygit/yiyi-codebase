package org.example.command;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/9 22:28
 */
public class Client {

    public static void main(String[] args) {
        // 使用命令模式，通过遥控器完成对电灯的操作

        // 创建电灯的对象（接收者）
        LightReceiver lightReceiver = new LightReceiver();

        // 创建电灯相关的命令
        LightOnCommand onCommand = new LightOnCommand(lightReceiver);
        LightOffCommand offCommand = new LightOffCommand(lightReceiver);

        // 初始化遥控器
        RemoteController remoteController = new RemoteController();
        remoteController.setCommand(0, onCommand, offCommand);

        System.out.println("------按下电灯的开按钮------");
        remoteController.onButtonWasPushed(0);
        System.out.println("------按下电灯的关按钮------");
        remoteController.offButtonWasPushed(0);
        System.out.println("------按下电灯的撤销按钮------");
        remoteController.undoButtonWasPushed();

        System.out.println("------使用遥控器操作TV------");
        TVReceiver tvReceiver = new TVReceiver();
        TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
        TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);

        remoteController.setCommand(1, tvOnCommand, tvOffCommand);
        System.out.println("------按下TV的开按钮------");
        remoteController.onButtonWasPushed(1);
        System.out.println("------按下TV的关按钮------");
        remoteController.offButtonWasPushed(1);
        System.out.println("------按下TV的撤销按钮------");
        remoteController.undoButtonWasPushed();
    }
}
