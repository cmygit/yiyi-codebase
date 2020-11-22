package org.example.responsibilitychain;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/11/22 19:00
 */
public abstract class Approver {

    Approver approver;

    String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void processRequest(PurchaseRequest request);
}
