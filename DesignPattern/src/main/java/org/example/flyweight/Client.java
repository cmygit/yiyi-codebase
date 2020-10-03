package org.example.flyweight;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/3 23:09
 */
public class Client {

    public static void main(String[] args) {
        // 创建一个工厂类
        WebSiteFactory factory = new WebSiteFactory();
        // 创建以不同形式发布的网站
        WebSite webSite1 = factory.getWebSite("新闻");
        webSite1.use(new User("tom"));
        WebSite webSite2 = factory.getWebSite("博客");
        webSite2.use(new User("jack"));
        WebSite webSite3 = factory.getWebSite("博客");
        webSite3.use(new User("smith"));
        WebSite webSite4 = factory.getWebSite("博客");
        webSite4.use(new User("lucy"));

        System.out.println("网站类型总数：" + factory.getWebSiteCount());
    }
}
