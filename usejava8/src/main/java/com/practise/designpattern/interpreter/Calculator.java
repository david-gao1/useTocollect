package com.practise.designpattern.interpreter;

import java.util.HashMap;
import java.util.Stack;

/**
 * �����ʽ��װ��Expression���������Ϊ
 */
public class Calculator {
    private Expression expression;

    public Calculator(String expStr) { // expStr = a+b
        Stack<Expression> stack = new Stack<>();// ͨ��stack ���������Ⱥ�˳��
        char[] charArray = expStr.toCharArray(); // ���ʽ��ֳ��ַ�����
        Expression left = null;
        Expression right = null;


        /**
         * stack��ʵ�ֽ����ʽ����ƴװ����Expression����ͨ��pop+push�������������һ��Expression
         *
         */
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                //�ж�Ϊ����
                case '-':
                    left = stack.pop(); //��ߵĿ��������ֻ���ʽ
                    right = new VarExpression(String.valueOf(charArray[++i])); //�ұ�һ�������֣�ֻ��һλ��Ϊ��
                    stack.push(new SubtractionExpression(left, right));
                    break;
                //�ж�Ϊ����
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                    break;
            }
        }
        //����pop������Ƕ�׵�Expression��ɵ����������ʽ��Expression
        this.expression = stack.pop();
    }

    /**
     * ���ý������߼�
     *
     * @param var ����ֵ {������1,ֵ1;������2,ֵ2}
     * @return
     */
    public int run(HashMap<String, Integer> var) {
        return this.expression.interpreter(var);
    }
}