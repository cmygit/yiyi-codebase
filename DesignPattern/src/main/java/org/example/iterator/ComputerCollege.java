package org.example.iterator;

import java.util.Iterator;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/8 20:01
 */
public class ComputerCollege implements College {

    Department[] departments;
    int numOfDepartments = 0;

    public ComputerCollege() {
        this.departments = new Department[5];
        this.addDepartment("java", "java专业");
        this.addDepartment("python", "python专业");
        this.addDepartment("大数据", "大数据专业");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        this.departments[this.numOfDepartments] = department;
        this.numOfDepartments += 1;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(this.departments);
    }
}
