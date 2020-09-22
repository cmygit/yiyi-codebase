package org.example.uml.aggregation;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/22 21:20
 */
public class Computer {

    /**
     * mouse 可以和 computer 分离
     */
    private Mouse mouse;

    /**
     * monitor 可以和 computer 分离
     */
    private Monitor monitor;

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}
