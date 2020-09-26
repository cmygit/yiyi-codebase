package org.example.adapter.objectadapter;



/**
 * @Title: 适配器
 * @Author: cmy
 * @Date: 2020/9/26 18:06
 */
public class VoltageAdapter implements IVoltage5V {

    /**
     * 关联关系-聚合
     */
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dst = 0;

        if (this.voltage220V != null) {
            // 获取到220V的电压
            int src = this.voltage220V.output220V();
            // 降压
            dst = src / 44;
        }

        return dst;
    }
}
