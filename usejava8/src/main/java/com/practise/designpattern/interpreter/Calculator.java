package com.practise.designpattern.interpreter;

import java.util.HashMap;
import java.util.Stack;

/**
 * 将表达式组装到Expression。最终输出为
 */
public class Calculator {
    private Expression expression;

    public Calculator(String expStr) { // expStr = a+b
        Stack<Expression> stack = new Stack<>();// 通过stack 安排运算先后顺序
        char[] charArray = expStr.toCharArray(); // 表达式拆分成字符数组
        Expression left = null;
        Expression right = null;


        /**
         * stack：实现将表达式进行拼装（到Expression），通过pop+push迭代最终输出到一个Expression
         *
         */
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                //判断为减法
                case '-':
                    left = stack.pop(); //左边的可能是数字或表达式
                    right = new VarExpression(String.valueOf(charArray[++i])); //右边一定是数字（只有一位因为）
                    stack.push(new SubtractionExpression(left, right));
                    break;
                //判断为变量
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                    break;
            }
        }
        //最终pop的是由嵌套的Expression组成的有完整表达式的Expression
        this.expression = stack.pop();
    }

    /**
     * 调用解释器逻辑
     *
     * @param var 输入值 {变量名1,值1;变量名2,值2}
     * @return
     */
    public int run(HashMap<String, Integer> var) {
        return this.expression.interpreter(var);
    }
}