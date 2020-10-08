package org.example.template;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/8 22:59
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("---制作红豆豆浆---");
        SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();

        System.out.println("---制作花生豆浆---");
        SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();
    }
}
