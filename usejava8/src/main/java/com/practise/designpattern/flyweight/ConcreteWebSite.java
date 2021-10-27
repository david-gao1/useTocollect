package com.practise.designpattern.flyweight;

import static java.lang.System.*;

//������վ��������
public class ConcreteWebSite extends WebSite {

    /**
     * ����Ĳ��֣��ڲ�״̬
     * ��վ��������ʽ(����)
     */
    private String type = "";

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        out.println("��վ�ķ�����ʽΪ:" + type + " ��ʹ���� .. ʹ������" + user.getName());
    }
}
