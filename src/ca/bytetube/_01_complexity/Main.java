package ca.bytetube._01_complexity;

public class Main {

    public static void main(String[] args) {
        int n = 45;
//        System.out.println(fib2(5));
        Times.test("fib", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib(n));
            }
        });

        Times.test("fib1", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib1(n));
            }
        });
        Times.test("fib2", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib2(n));
            }
        });
    }

    //reversion
    public static int fib(int n) {//2^n

        //fib(6) = fib(5) + fib(4)
        //fib(n) = fib(n - 1) + fib(n - 2)
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib1(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;

        for (int i = 0; i < n - 1; i++) {//plus times
            int temp = second;
            second = first + second;
            first = temp;

        }
        return second;
    }

    public static int fib2(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }


        return arr[n];
    }



    public static void test1(int n){

        //1
        if (n > 10) {
            System.out.println("n > 10");
        } else if (n > 5) {
            System.out.println("n > 5");
        } else {
            System.out.println("n < 5 ");
        }


        //1 + 4 + 4 + 4 = 13
        for (int i = 0; i < 4; i++) {
            System.out.println("test1");
        }

        //14 ---> O(1)
    }

    public static void test2(int n){
        // 1 + n + n + n = 3n + 1   --->   O(n)
        for (int i = 0; i < n; i++) {
            System.out.println("test2");
        }
    }

    public static void test3(int n){
        //1 + n + n + n*(1+3n) = 3n^2+3n+1 ---> O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("test3");
            }
        }

    }

    public static void test4(int n){
        //1 + 2log2n + log2n(1+ 3n) = (3n + 3)log2n + 1 ---> O(nlogn)
        for (int i = 1; i < n; i = i*2) {
            for (int j = 0; j < n; j++) {
                System.out.println("test4");
            }
        }

    }

    public static void test5(int n){
        //logn
        /**
         * n = 8
         *
         * n = 4 1
         *
         * n = 2 1
         *
         * n = 1 1
         *
         * n = 0
         *
         * n = 8 = 2^3 ---> 3
         *
         * n = 16 = 2^4---> 4
         *
         *
         */
     while ((n = n/5) > 0){
         System.out.println("test5");
     }

    }




}
