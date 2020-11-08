package org.example.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/8 20:22
 */
public class Client {

    public static void main(String[] args) {
        List<College> collegeList = new ArrayList<>();

        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        collegeList.add(computerCollege);
        collegeList.add(infoCollege);

        OutputImpl output = new OutputImpl(collegeList);
        output.printColleges();
    }
}
