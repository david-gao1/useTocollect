package com.practise.designpattern.interpreter;

import java.util.HashMap;

/**
 * ����1��
 * ʵ��������Ǳ������ӷ���������
 */
public abstract class Expression {

    /**
     * ͨ������������ó��������Ϊ�������ʽ�������ߵ�Ԫ�أ����е�������
     *
     * @param var
     * @return
     */
    public abstract int interpreter(HashMap<String, Integer> var);
}
