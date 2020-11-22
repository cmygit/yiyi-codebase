package org.example.responsibilitychain;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/22 19:05
 */
public class Client {

    public static void main(String[] args) {
        PurchaseRequest request = new PurchaseRequest(1, 9999, 1);

        Approver approver1 = new DepartmentApprover("张主任");
        Approver approver2 = new CollegeApprover("李院长");

        approver1.setApprover(approver2);

        approver1.processRequest(request);
    }
}
