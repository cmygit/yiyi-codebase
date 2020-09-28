package org.example.composite;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/28 23:55
 */
public abstract class OrganizationComponent {

    private String name;

    private String desc;

    public OrganizationComponent(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    protected void add(OrganizationComponent component) {
        // 默认实现
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent component) {
        // 默认实现
        throw new UnsupportedOperationException();
    }

    /**
     * 由子类实现
     */
    protected abstract void print();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
