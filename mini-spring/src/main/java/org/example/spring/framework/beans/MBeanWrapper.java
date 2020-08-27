package org.example.spring.framework.beans;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/26 21:44
 */
public class MBeanWrapper {

    private Object wrapperInstance;

    private Class<?> wrapperClass;

    public MBeanWrapper(Object instance) {
        this.wrapperInstance = instance;
        this.wrapperClass = this.wrapperInstance.getClass();
    }

    public Object getWrapperInstance() {
        return this.wrapperInstance;
    }

    public Class<?> getWrapperClass() {
        return this.wrapperClass;
    }
}
