package org.example.bridge;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 23:55
 */
public class Client {

    public static void main(String[] args) {
        FoldedPhone phone1 = new FoldedPhone(new XiaoMi());
        phone1.open();
        phone1.call();
        phone1.close();

        UpRightPhone phone2 = new UpRightPhone(new Vivo());
        phone2.open();
        phone2.call();
        phone2.close();
    }
}
