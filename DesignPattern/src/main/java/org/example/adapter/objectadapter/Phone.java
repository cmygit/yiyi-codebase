package org.example.adapter.objectadapter;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 18:16
 */
public class Phone {

    public void charging(IVoltage5V voltage5V) {
        int vol = voltage5V.output5V();
        if (vol == 5) {
            System.out.println("电压为5V，可以充电");
        } else if (vol > 5) {
            System.out.println("电压大于5V，无法充电");
        }
    }
}
