package ca.bytetube._13_stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * @author dal
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            boolean add = tokens[i].equals("+");
            boolean mult = tokens[i].equals("*");
            boolean min = tokens[i].equals("-");
            boolean div = tokens[i].equals("/");
            if (add||mult||min||div){
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                if (add) stack.push(num1+num2);
                if (mult) stack.push(num1*num2);
                if (min) stack.push(num2-num1);
                if (div) stack.push(num2/num1);
            } else stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }

}
