package org.example.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: University 就是 composite，可以管理 Department
 * @Author: cmy
 * @Date: 2020/9/29 0:03
 */
public class College extends OrganizationComponent{

    /**
     * 存放 Department
     */
    private List<OrganizationComponent> components = new ArrayList<>();

    public College(String name, String desc) {
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

    @Override
    protected void print() {
        System.out.println("-------------" + super.getName() + "-------------");
        for (OrganizationComponent component : this.components) {
            component.print();
        }
    }
}
