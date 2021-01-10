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
        System.out.println("中缀表达式：" + expList);
        List<String> suffixExpList = parseSuffixExpressionList(expList);
        System.out.println("后缀表达式：" + suffixExpList);
        int res = calculate(suffixExpList);
        System.out.println("res: " + res);
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

    public static List<String> parseSuffixExpressionList(List<String> expList) {
        Stack<String> optStack = new Stack<>();
        List<String> suffixExpList = new ArrayList<>();

        for (String item : expList) {
            if (item.matches("\\d+")) {
                // 如果是数
                suffixExpList.add(item);
            } else if ("(".equals(item)) {
                // 如果是左括号
                optStack.push(item);
            } else if (")".equals(item)) {
                // 如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，然后消除一对括号
                while (!"(".equals(optStack.peek())) {
                    suffixExpList.add(optStack.pop());
                }
                // 消除一对括号
                optStack.pop();
            } else {
                // 如果是操作符
                // 当操作符优先级小于等于 optStack 栈顶操作符的优先级，将栈顶操作符弹出并压入 suffixExpList 中，然后继续比较
                while (optStack.size() > 0 && Operation.getPriority(item) <= Operation.getPriority(optStack.peek())) {
                    suffixExpList.add(optStack.pop());
                }
                // 比较完毕，入栈
                optStack.push(item);
            }
        }

        // 将 optStack 剩余的运算符压入 suffixExpList
        while (optStack.size() > 0) {
            suffixExpList.add(optStack.pop());
        }

        return suffixExpList;
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
        StringBuilder numStr = new StringBuilder();
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
                    numStr.append(c);
                    // 移位
                    index++;

                    if (index < exp.length()) {
                        // 继续遍历下一个字符
                        c = exp.charAt(index);
                    }
                }

                expList.add(numStr.toString());
                // 重置辅助变量
                numStr.delete(0, numStr.length());
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

class Operation {

    private final static int ADD = 1;

    private final static int SUB = 1;

    private final static int MUL = 2;

    private final static int DIV = 2;

    public static int getPriority(String opt) {
        int res = 0;

        switch (opt) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println("不支持该运算符");
                break;
        }

        return res;
    }
}
