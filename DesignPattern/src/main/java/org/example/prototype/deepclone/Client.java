package org.example.prototype.deepclone;

/**
 * @Title: 深拷贝
 * @Author: cmy
 * @Date: 2020/9/26 0:44
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype prototype = new DeepPrototype();
        prototype.name = "sg";
        prototype.deepCloneableTarget = new DeepCloneableTarget("ddd", "aaaClass");

        // 方式1 完成深拷贝
        DeepPrototype prototype2 = (DeepPrototype) prototype.clone();
        System.out.println("prototype.name = " + prototype.name + ", " + "prototype.deepCloneableTarget.hashCode() = " + prototype.deepCloneableTarget.hashCode());
        System.out.println("prototype2.name = " + prototype2.name + ", " + "prototype2.deepCloneableTarget.hashCode() = " + prototype2.deepCloneableTarget.hashCode());

        // 方式2 完成深拷贝
        DeepPrototype prototype3 = (DeepPrototype) prototype.deepClone();
        System.out.println("prototype.name = " + prototype.name + ", " + "prototype.deepCloneableTarget.hashCode() = " + prototype.deepCloneableTarget.hashCode());
        System.out.println("prototype3.name = " + prototype3.name + ", " + "prototype3.deepCloneableTarget.hashCode() = " + prototype3.deepCloneableTarget.hashCode());
    }
}
