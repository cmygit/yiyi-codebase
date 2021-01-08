package org.example.stack;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2021/1/8 20:15
 */
public class Calculator {

    public static void main(String[] args) {
        // 需要运算的表达式
        String expression = "70+20*6-4";
        // 操作数栈
        CalStack numStack = new CalStack(10);
        // 运算符号栈
        CalStack optStack = new CalStack(10);

        // 用于扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int opt = 0;
        int res = 0;
        char ch = ' ';
        // 保存操作数
        StringBuilder keepNum = new StringBuilder();

        // 扫描表达式
        while (true) {
            // 判断是否扫描到最后
            if (index >= expression.length()) {
                break;
            }

            // 逐个提取表达式的字符
            ch = expression.substring(index, index + 1)
                           .charAt(0);

            // 如果是运算符
            if (optStack.isOperation(ch)) {
                if (!optStack.isEmpty()) {
                    /*
                        如果当前操作符的优先级小于或等于栈顶操作符的优先级，就从数栈中pop出2个数，
                        再从符号栈中pop出一个符号进行运算，得到的结果再存入数栈中，然后把当前操作符入栈
                    */
                    if (optStack.priority(ch) <= optStack.priority(optStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        opt = optStack.pop();
                        res = numStack.cal(num1, num2, opt);
                        numStack.push(res);
                    }
                }

                optStack.push(ch);
            }
            // 如果是操作数
            else {
                keepNum.append(ch);

                // 若已扫描到最后一位，直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum.toString()));
                } else {
                    /*
                        需要考虑操作数是否为多位数，继续扫描表达式的下一位，
                        若为操作符，说明扫描完了一个完整的操作数，将结果入栈，否则继续遍历。
                    */
                    char nextCh = expression.substring(index + 1, index + 2)
                                            .charAt(0);

                    if (optStack.isOperation(nextCh)) {
                        numStack.push(Integer.parseInt(keepNum.toString()));
                        // 入栈后清空辅助变量
                        keepNum.delete(0, keepNum.length());
                    }
                }
            }

            // 移位
            index++;
        }

        // 扫描完毕后，继续进行运算
        while (true) {
            // 符号栈为空，表示计算完毕
            if (optStack.isEmpty()) {
                break;
            }

            num1 = numStack.pop();
            num2 = numStack.pop();
            opt = optStack.pop();
            res = numStack.cal(num1, num2, opt);
            numStack.push(res);
        }

        System.out.printf("表达式 %s = %d\n", expression, numStack.peek());
    }
}

/**
 * 计算器栈
 */
class CalStack {

    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 数组模拟栈，用数组存放数据
     */
    private int[] stack;

    /**
     * 栈顶
     */
    private int top = -1;

    public CalStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return this.top == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void push(int value) {
        if (this.isFull()) {
            System.out.println("栈已满，无法入栈");
            return;
        }

        this.top++;
        this.stack[this.top] = value;
    }

    public int peek() {
        return this.stack[this.top];
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("栈已空，无法出栈");
        }

        int value = this.stack[this.top];
        this.top--;

        return value;
    }

    public int priority(int operation) {
        if (operation == '*' || operation == '/') {
            return 1;
        } else if (operation == '+' || operation == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOperation(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int operation) {
        int res = 0;

        switch (operation) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                // 减法和除法要注意顺序跟加法的顺序是相反的。
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }

        return res;
    }

    public void list() {
        if (this.isEmpty()) {
            System.out.println("栈已空");
            return;
        }

        // 从栈顶开始遍历
        for (int i = this.top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, this.stack[i]);
        }
    }
}
