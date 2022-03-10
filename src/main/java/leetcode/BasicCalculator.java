package leetcode;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = " 30/2 ";
        BasicCalculator calculator = new BasicCalculator();
        System.out.println(calculator.calculate("1-1+1"));
        System.out.println(calculator.calculate(s));
        System.out.println(calculator.calculate("3+2*2"));
        System.out.println(calculator.calculate("3/2"));
        System.out.println(calculator.calculate(" 3+5 / 2 "));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int value = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    value = 10 * value + s.charAt(i) - '0';
                    i++;
                }
                i--;
                if (operation == '+') {
                    stack.push(value);
                } else if (operation == '-') {
                    stack.push(-value);
                } else if (operation == '*') {
                    stack.push(stack.pop() * value);
                } else if (operation == '/') {
                    stack.push(stack.pop() / value);
                }
            } else if (s.charAt(i) != ' ') {
                operation = s.charAt(i);
            }

        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }


}
