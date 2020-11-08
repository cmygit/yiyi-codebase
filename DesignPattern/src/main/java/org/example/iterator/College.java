package org.example.iterator;

import java.util.Iterator;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/8 19:59
 */
public interface College {

    String getName();

    void addDepartment(String name, String desc);

    Iterator createIterator();
}
