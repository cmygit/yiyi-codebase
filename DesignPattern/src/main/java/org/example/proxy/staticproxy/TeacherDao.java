package org.example.proxy.staticproxy;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/4 12:09
 */
public class TeacherDao implements ITeacherDao {

    @Override
    public void teach() {
        System.out.println(" 老师授课中 ");
    }
}
