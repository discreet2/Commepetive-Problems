package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    //https://leetcode.com/problems/valid-parentheses/
    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> hm = new HashMap<>();
        hm.put(')', '(');
        hm.put('}', '{');
        hm.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.size() > 0 && stack.peek() == hm.get(ch)) {
                    stack.pop();
                } else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
