package org.example.facade;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/3 12:05
 */
public class Client {

    public static void main(String[] args) {
        HomeTheaterFacade facade = new HomeTheaterFacade();
        facade.ready();
        System.out.println("------");
        facade.play();
        System.out.println("------");
        facade.pause();
        System.out.println("------");
        facade.end();
    }
}
