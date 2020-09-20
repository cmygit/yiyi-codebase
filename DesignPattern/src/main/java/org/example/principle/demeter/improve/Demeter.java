package org.example.principle.demeter.improve;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 客户端
 * @Author: cmy
 * @Date: 2020/9/20 19:27
 */
public class Demeter {

    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployees(new CollegeManager());
    }
}

/**
 * 学校总部员工
 */
class Employee {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

/**
 * 学院员工
 */
class CollegeEmployee {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

/**
 * 管理学院员工
 */
class CollegeManager {

    /**
     * 返回所有学院员工
     *
     * @return
     */
    public List<CollegeEmployee> getAllEmployees() {
        List<CollegeEmployee> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            CollegeEmployee employee = new CollegeEmployee();
            employee.setId("学院员工id= " + i);
            list.add(employee);
        }

        return list;
    }

    /**
     * 输出学院所有员工
     */
    public void printEmployees() {
        List<CollegeEmployee> subEmployees = this.getAllEmployees();
        System.out.println("------分公司员工------");
        for (CollegeEmployee emp : subEmployees) {
            System.out.println(emp.getId());
        }
    }
}

/**
 * 管理学校总部员工
 */
class SchoolManager {

    /**
     * 返回所有学校总部员工
     *
     * @return
     */
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setId("学校总部员工id= " + i);
            list.add(employee);
        }

        return list;
    }

    /**
     * 输出学校所有员工
     *
     * @param sub
     */
    public void printAllEmployees(CollegeManager sub) {
        /*
        * 将输出学院员工的方法，封装到 CollegeManager
        * */
        sub.printEmployees();

        System.out.println("------总部员工------");
        List<Employee> employees = this.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp.getId());
        }
    }
}
