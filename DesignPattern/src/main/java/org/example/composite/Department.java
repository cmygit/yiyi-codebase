package org.example.composite;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/29 0:05
 */
public class Department extends OrganizationComponent {

    public Department(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void print() {
        System.out.println(super.getName());
    }
}
