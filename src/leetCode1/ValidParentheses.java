package leetCode1;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }

        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (c.equals('{')) {
                stack.push('{');
            } else if (c.equals('[')) {
                stack.push('[');
            } else if (c.equals('(')) {
                stack.push('(');
            } else if (c.equals('}')) {
                if (stack.empty() || !stack.pop().equals('{')) {
                    return false;
                }
            } else if (c.equals(']')) {
                if (stack.empty() || !stack.pop().equals('[')) {
                    return false;
                }
            } else if (c.equals(')')) {
                if (stack.empty() || !stack.pop().equals('(')) {
                    return false;
                }
            }
        }


        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        ValidParentheses test = new ValidParentheses();
        if (test.isValid(s)) {
            System.out.println("true");
        }
    }
}
