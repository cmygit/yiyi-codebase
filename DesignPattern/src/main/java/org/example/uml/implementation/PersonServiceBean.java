package org.example.uml.implementation;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/22 20:03
 */
public class PersonServiceBean implements PersonService {

    @Override
    public void delete(Integer id) {
        System.out.println("delete...");
    }
}
