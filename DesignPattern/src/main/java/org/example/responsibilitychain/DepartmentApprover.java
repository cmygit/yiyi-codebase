package org.example.responsibilitychain;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/22 19:01
 */
public class DepartmentApprover extends Approver {

    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getPrice() <= 5000) {
            System.out.println("请求编号 id= " + request.getId() + " 被" + super.name + "处理");
        } else {
            super.approver.processRequest(request);
        }
    }
}
