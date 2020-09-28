package org.example.composite;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/29 0:07
 */
public class Client {

    public static void main(String[] args) {
        // 从大到小创建对象
        // 创建学校
        OrganizationComponent university = new University("清华大学", "中国顶级大学");

        // 创建学院
        OrganizationComponent computerCollege = new College("计算机学院", "计算机技术");
        OrganizationComponent infoEngineeringCollege = new College("信息工程学院", "信息技术");
        // 将学院添加到学校
        university.add(computerCollege);
        university.add(infoEngineeringCollege);

        // 创建专业
        computerCollege.add(new Department("软件工程", "软件工程技术"));
        computerCollege.add(new Department("网络工程", "网络工程技术"));
        computerCollege.add(new Department("计算机科学", "计算机科学技术"));

        infoEngineeringCollege.add(new Department("通信工程", "通信工程技术"));
        infoEngineeringCollege.add(new Department("信息工程", "信息工程技术"));
        infoEngineeringCollege.add(new Department("电子工程", "电子工程技术"));

        university.print();
    }
}
