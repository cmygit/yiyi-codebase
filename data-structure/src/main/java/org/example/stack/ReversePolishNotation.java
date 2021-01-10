package org.example.stack;

import java.util.ArrayList;
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
        // 中缀表达式转后缀表达式
        // 1、1 + ( ( 2 + 3 ) * 4 ) - 5 -> 1 2 3 + 4 * + 5 -
        String expression = "1+((2+3)*4)-5";
        List<String> expList = toInfixExpressionList(expression);
        System.out.println(expList);

    }

    public static void testSuffixExpression() {
        // 逆波兰表达式（后缀表达式）
        // (3+4)*5-6 -> 3 4 + 5 * 6 -
        String suffixExpression = "3 4 + 5 * 6 -";

        List<String> expressionList = getExpressionList(suffixExpression);
        System.out.println("expression: " + expressionList);

        int res = calculate(expressionList);
        System.out.println("res: " + res);
    }

    /**
     * 将表达式转为链表
     *
     * @param exp 表达式
     * @return
     */
    public static List<String> toInfixExpressionList(String exp) {
        List<String> expList = new ArrayList<>();
        // 遍历指针
        int index = 0;
        // 保存多位数
        StringBuilder str = new StringBuilder();
        // 遍历字符
        char c;

        while (index < exp.length()) {
            c = exp.charAt(index);

            // 非数字
            if (c < 48 || c > 57) {
                expList.add(String.valueOf(c));
                index++;
            } else {
                // 如果是数字，还需要考虑多位数的情况
                while (index < exp.length() && c >= 48 && c <= 57) {
                    str.append(c);
                    // 移位
                    index++;

                    if (index < exp.length()) {
                        // 继续遍历下一个字符
                        c = exp.charAt(index);
                    }
                }

                expList.add(str.toString());
                // 重置辅助变量
                str.delete(0, str.length());
            }
        }

        return expList;
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
