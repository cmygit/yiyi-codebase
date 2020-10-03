package org.example.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: 网站工厂类，根据需要返回一个网站
 * @Author: cmy
 * @Date: 2020/10/3 23:04
 */
public class WebSiteFactory {

    /**
     * 池
     */
    private Map<String, ConcreteWebSite> pool = new HashMap<>();

    /**
     * 根据网站的类型，返回一个网站，如果没有就创建一个网站，并放入到池中，并返回
     *
     * @param type
     * @return
     */
    public WebSite getWebSite(String type) {
        if (!this.pool.containsKey(type)) {
            this.pool.put(type, new ConcreteWebSite(type));
        }

        return this.pool.get(type);
    }

    /**
     * 获取网站类型总数
     *
     * @return
     */
    public int getWebSiteCount() {
        return this.pool.size();
    }
}
