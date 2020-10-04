package org.example.proxy.staticproxy;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/4 12:11
 */
public class Client {

    public static void main(String[] args) {
        // 创建目标对象（被代理对象）
        TeacherDao teacherDao = new TeacherDao();
        // 创建代理对象，同时将目标对象交给代理对象
        TeacherDaoProxy proxy = new TeacherDaoProxy(teacherDao);
        // 通过代理对象，调用到目标对象的方法
        proxy.teach();
    }
}
