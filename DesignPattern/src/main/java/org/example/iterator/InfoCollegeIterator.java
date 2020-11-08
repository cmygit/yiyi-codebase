package org.example.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/8 19:56
 */
public class InfoCollegeIterator implements Iterator {

    List<Department> departments;

    int index = -1;

    public InfoCollegeIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (this.index >= this.departments.size() - 1) {
            return false;
        } else {
            this.index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return this.departments.get(this.index);
    }

    @Override
    public void remove() {

    }
}
