package org.example.adapter.classadapter;

/**
 * @Title: 适配器
 * @Author: cmy
 * @Date: 2020/9/26 18:06
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {

    @Override
    public int output5V() {
        // 获取到220V的电压
        int src = this.output220V();
        // 降压
        int dst = src / 44;
        return dst;
    }
}
