package ca.bytetube._03_recursion;

import java.util.Stack;

public class RecursiveToNonRecursive {
    public static void main(String[] args) {
        log2(4);
    }

    public static void log(int n){
        if (n < 1) return;
        log(n - 1);
        int v = n + 10;
        System.out.println(v);
    }

    private static class Frame{
        public int n;
        public int v;

        public Frame(int n, int v) {
            this.n = n;
            this.v = v;
        }
    }


    public static void log2(int n ){
        Stack<Frame> stack = new Stack();
        while (n > 0){
            stack.push(new Frame(n,n+10));

            n--;
        }

        while (n < 4){
            Frame frame = stack.pop();
            System.out.println(frame.v);
            n++;
        }


    }


}
