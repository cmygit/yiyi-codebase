package org.example.proxy.staticproxy;

/**
 * @Title: 代理对象，静态代理
 * @Author: cmy
 * @Date: 2020/10/4 12:09
 */
public class TeacherDaoProxy implements ITeacherDao {

    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println(" 开始代理 ");
        this.target.teach();
        System.out.println(" 结束代理 ");
    }
}
