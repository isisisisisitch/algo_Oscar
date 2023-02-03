package ca.bytetube._13_stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid(")"));
    }


    public static boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
                stack.push(arr[i]);
            } else {
                if (stack.isEmpty()) return false;
                else {
                    Character leftBracket = stack.pop();
                    if (leftBracket == '(' && arr[i] != ')') return false;
                    if (leftBracket == '{' && arr[i] != '}') return false;
                    if (leftBracket == '[' && arr[i] != ']') return false;
                }
            }

        }

        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean valid = false;
        boolean check = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
                stack.push(arr[i]);
            } else if (!stack.isEmpty()) {
                Character leftBracket = stack.pop();

                if (leftBracket == '(' && arr[i] != ')' ||
                        leftBracket == '{' && arr[i] != '}' ||
                        leftBracket == '[' && arr[i] != ']') {
                    return false;
                } else {
                    check = false;
                    break;
                }
            } else {
                check = false;
                break;
            }
        }
        if (stack.isEmpty() && check) {
            valid = true;
        }
        return valid;
    }
}
