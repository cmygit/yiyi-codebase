package org.example.prototype.deepclone;

import java.io.*;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 0:37
 */
public class DeepPrototype implements Serializable, Cloneable {

    private static final long serialVersionUID = 4345808452084368138L;

    public String name;

    /**
     * 引用类型
     */
    public DeepCloneableTarget deepCloneableTarget;

    public DeepPrototype() {
        super();
    }

    /**
     * 深拷贝 - 方式1 使用 clone 方法
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 完成基本数据类型和 String 类型的属性的克隆
        Object deep = super.clone();
        // 对引用类型的属性，进行单独处理
        DeepPrototype deepPrototype = (DeepPrototype) deep;
        deepPrototype.deepCloneableTarget = (DeepCloneableTarget) this.deepCloneableTarget.clone();

        return deep;
    }

    /**
     * 深拷贝 - 方式2 通过对象的序列化实现（推荐）
     * 若有多个引用类型，或有更深层次的引用类型，使用序列化方式克隆更加方便
     *
     * @return
     */
    public Object deepClone() {
        // 创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // 把当前对象的实例以对象流的方式输出
            oos.writeObject(this);

            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepPrototype deepPrototype = (DeepPrototype) ois.readObject();
            return deepPrototype;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
