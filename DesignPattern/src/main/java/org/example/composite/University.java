package org.example.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: University 就是 composite，可以管理 College
 * @Author: cmy
 * @Date: 2020/9/28 23:58
 */
public class University extends OrganizationComponent {

    /**
     * 存放 College
     */
    private final List<OrganizationComponent> components = new ArrayList<>();

    public University(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void add(OrganizationComponent component) {
        this.components.add(component);
    }

    @Override
    protected void remove(OrganizationComponent component) {
        this.components.remove(component);
    }

    /**
     * 输出 University 包含的 College
     */
    @Override
    protected void print() {
        System.out.println("-------------" + super.getName() + "-------------");
        for (OrganizationComponent component : this.components) {
            component.print();
        }
    }
}
