package ca.bytetube._05_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        String email = "bytetube_111";
////        System.out.println(validate(email));
//        String regex = "[a-zA-Z]\\w{5,17}";
//        System.out.println(email.matches(regex));
            //test1();
//        test2();

        String input = "1";
        String regex = "1?";
        //System.out.println(input.matches(regex));

        findAll(regex,input);


    }

    public static void findAll(String regex,String input){

        findAll(regex,input,0);
    }

    private static void findAll(String regex,String input,int flags){
        if (regex == null || input == null) return;
        Pattern pattern = Pattern.compile(regex,flags);
        Matcher matcher = pattern.matcher(input);
        boolean found = false;
        while ( matcher.find()){
            found = true;
            //[0,3)---> 3-0 = 3
            System.out.format("\"%s\",[%d ,%d)%n",matcher.group(),matcher.start(),matcher.end());

        }
        if (!found) {
            System.out.println("no match! ");
        }

    }





    public static void test2(){
        String regex = "6?";
        System.out.println("".matches(regex));
    }

    public static void test1(){
        //00001  //11110
        String regex = "\\[123\\]";
        System.out.println("1".matches(regex));
        System.out.println("2".matches(regex));
        System.out.println("3".matches(regex));
        System.out.println("123".matches(regex));
        System.out.println("[123]".matches(regex));
    }


    //create a gmail account ---> 6~18 chars(letter,digit,_),start with letter
    public static boolean validate(String email) {
        if (email == null) return false;
        char[] chars = email.toCharArray();
        if (chars.length < 6 || chars.length > 18) return false;
        if (!isLetter(chars[0])) return false;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (isLetter(c) || isDigit(c) || '_' == c) continue;//{ *
            return false;
        }
        return true;
    }

    private static boolean isLetter(char c) {

        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isDigit(char c) {

        return (c >= '0' && c <= '9');
    }
}
