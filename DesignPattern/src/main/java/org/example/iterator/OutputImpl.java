package org.example.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/8 20:16
 */
public class OutputImpl {

    List<College> colleges;

    public OutputImpl(List<College> colleges) {
        this.colleges = colleges;
    }

    public void printColleges() {
        Iterator<College> iterator = this.colleges.iterator();

        while (iterator.hasNext()) {
            College college = iterator.next();
            System.out.println("===" + college.getName() + "===");
            this.printDepartments(college.createIterator());
        }
    }

    public void printDepartments(Iterator iterator) {
        while (iterator.hasNext()) {
            Department department = (Department) iterator.next();
            System.out.println(department.getName());
        }
    }
}
