package ca.bytetube._00_CCC;


import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
       String s = "{[()]()}]";
        System.out.println(isValid(s));

    }

    //queue

    public static boolean isValid(String str){
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '{' || arr[i] == '[' || arr[i] == '('  ){
                stack.push(arr[i]);
            } else if (!stack.isEmpty() && (stack.peek() == '{' && arr[i] == '}' ||
                    stack.peek() == '(' && arr[i] == ')' ||
                    stack.peek() == '[' && arr[i] == ']')) {
                stack.pop();
            } else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }


    public static boolean isValid1(String str){

        while (str.contains("{}")||str.contains("[]")||str.contains("()") ) {
            str = str.replace("{}","");
            str = str.replace("[]","");
            str = str.replace("()","");
        }
        return str.isEmpty();
    }
}
