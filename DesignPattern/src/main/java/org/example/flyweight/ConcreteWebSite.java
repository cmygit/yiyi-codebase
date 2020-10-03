package org.example.flyweight;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/3 23:02
 */
public class ConcreteWebSite extends WebSite {

    /**
     * 网站发布的形式（类型）
     * 共享的内部状态
     */
    private String type;

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站的发布形式为：" + this.type + "，使用者为：" + user.getName());
    }
}
