package org.example.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/8 20:12
 */
public class InfoCollege implements College {

    List<Department> departments;

    public InfoCollege() {
        this.departments = new ArrayList<>();
        this.addDepartment("信息安全", "信息安全专业");
        this.addDepartment("网络安全", "网络安全专业");
        this.addDepartment("服务器安全", "服务器安全专业");
    }

    @Override
    public String getName() {
        return "信息学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        this.departments.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(this.departments);
    }
}
