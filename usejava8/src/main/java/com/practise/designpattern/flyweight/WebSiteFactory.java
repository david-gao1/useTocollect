package com.practise.designpattern.flyweight;

import java.util.HashMap;

// ��վ�����ࣨ����ŵ�map�У�����������
public class WebSiteFactory {
    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    //������վ�����ͣ�ֻ����һ����վ��***��Ϊ�����������뵽����
    public WebSite getWebSiteCategory(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcreteWebSite(type));
        }
        return pool.get(type);
    }

    //��ȡ��վ��������� (�����ж��ٸ���վ����)
    public int getWebSiteCount() {
        return pool.size();
    }
}
