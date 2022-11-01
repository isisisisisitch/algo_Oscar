package ca.bytetube._03_recursion;

public class TailCall {
    public static void main(String[] args) {
//        test1();
        System.out.println(factorial0(5l));
        System.out.println(factorial(5l));
    }


    public static long factorial0(long n){
        if (n <= 1) return n;
        return n * factorial0(n-1);
    }

    //1*2*3*4*5*6*...n
    public static long factorial(long n){
        if (n <= 1) return n;
        return factorial(n,1);
    }

    private static long factorial(long n,long res){
        if (n <= 1) return res;
        return factorial(n-1,n * res);
    }




    public static void test1(){
        int a = 10;
        int b = a + 20;
        test2(b);

        int c = a + b;//40
        System.out.println(c);
    }

    public static void test2(int n){
        int x1 = 200;
        int x3 = 300;

    }



}
