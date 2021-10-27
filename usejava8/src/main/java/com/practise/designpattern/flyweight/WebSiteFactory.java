package com.practise.designpattern.flyweight;

import java.util.HashMap;

// 网站工厂类（对象放到map中，当作容器）
public class WebSiteFactory {
    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    //根据网站的类型，只创建一个网站（***作为共享），并放入到池中
    public WebSite getWebSiteCategory(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcreteWebSite(type));
        }
        return pool.get(type);
    }

    //获取网站分类的总数 (池中有多少个网站类型)
    public int getWebSiteCount() {
        return pool.size();
    }
}
