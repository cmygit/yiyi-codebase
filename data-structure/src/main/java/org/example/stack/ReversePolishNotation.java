package org.example.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/1/10 17:08
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        // 逆波兰表达式（后缀表达式）
        // (3+4)*5-6 -> 3 4 + 5 * 6 -
        String suffixExpression = "3 4 + 5 * 6 -";

        List<String> expressionList = getExpressionList(suffixExpression);
        System.out.println("expression: " + expressionList);

        int res = calculate(expressionList);
        System.out.println("res: " + res);
    }

    public static List<String> getExpressionList(String expression) {
        String[] strs = expression.split(" ");
        return Arrays.asList(strs);
    }

    public static int calculate(List<String> expressionList) {
        Stack<String> stack = new Stack<>();
        for (String item : expressionList) {
            // 正则表达式匹配多位数
            if (item.matches("\\d+")) {
                stack.push(item);
            }
            // 匹配到符号
            else {
                // 注意 num2 是栈顶元素，num1 是次顶元素
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;

                if ("+".equals(item)) {
                    res = num1 + num2;
                } else if ("-".equals(item)) {
                    // 注意运算顺序
                    res = num1 - num2;
                } else if ("*".equals(item)) {
                    res = num1 * num2;
                } else if ("/".equals(item)) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }

                // 将结果入栈
                stack.push(String.valueOf(res));
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
