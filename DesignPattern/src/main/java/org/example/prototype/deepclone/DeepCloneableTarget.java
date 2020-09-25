package org.example.prototype.deepclone;

import java.io.Serializable;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/26 0:34
 */
public class DeepCloneableTarget implements Serializable, Cloneable {

    private static final long serialVersionUID = -238349098566000307L;

    private String cloneName;

    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    /**
     * 因为此类的字段类型都是 String ，使用默认的 clone 方法即可（浅拷贝）
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
