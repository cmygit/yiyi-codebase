package org.example.proxy.dynamic;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/4 16:10
 */
public class Client {

    public static void main(String[] args) {
        // 创建目标对象
        ITeacherDao teacherDao = new TeacherDao();
        // 创建代理对象
        ProxyFactory factory = new ProxyFactory(teacherDao);
        ITeacherDao proxyInstance = (ITeacherDao) factory.getProxyInstance();
        // 通过代理对象调用目标对象的方法
        proxyInstance.teach();

        System.out.println("proxyInstance = " + proxyInstance);
        System.out.println("proxyInstance.getClass() = " + proxyInstance.getClass());
    }
}
