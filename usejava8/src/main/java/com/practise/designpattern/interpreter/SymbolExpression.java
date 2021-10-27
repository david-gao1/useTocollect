package com.practise.designpattern.interpreter;

import java.util.HashMap;


/**
 * "���๫��"����ȡ�������ߵı��ʽʵ��
 * ���ÿ��������ţ���ֻ���Լ����������й�ϵ��
 *  ���߿���������Ҳ�����Ǳ��ʽ ������Expression���ʵ����
 */
public class SymbolExpression extends Expression {

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }


    //Ĭ��ʵ�֣������ʵ��
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}
