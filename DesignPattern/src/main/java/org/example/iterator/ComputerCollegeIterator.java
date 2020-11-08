package org.example.iterator;

import java.util.Iterator;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/8 19:51
 */
public class ComputerCollegeIterator implements Iterator {

    Department[] departments;

    int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (this.position >= this.departments.length || this.departments[this.position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Department department = this.departments[this.position];
        this.position += 1;
        return department;
    }

    @Override
    public void remove() {

    }
}
