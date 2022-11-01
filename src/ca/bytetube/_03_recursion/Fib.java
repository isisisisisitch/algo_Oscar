package ca.bytetube._03_recursion;


public class Fib {

    public static void main(String[] args) {
        int n = 50;
//        int res = fib5(6);
//        System.out.println(res);
//        System.out.println(fib0(3));
////        System.out.println(fib2(5));
//        Times.test("fib0", new Times.Task() {
//            @Override
//            public void execute() {
//                System.out.println(fib0(n));
//            }
//        });
//
//        Times.test("fib1", new Times.Task() {
//            @Override
//            public void execute() {
//                System.out.println(fib1(n));
//            }
//        });
//
//        Times.test("fib2", new Times.Task() {
//            @Override
//            public void execute() {
//                System.out.println(fib2(n));
//            }
//        });
//
        Times.test("fib5", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib5(n));
            }
        });

        Times.test("fib6", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib6(n));
            }
        });

    }


    public static int fib0(int n) {
        if (n <= 1) return 1;
        //fib(n) = fib(n - 1) + fib(n - 2)
        return fib0(n - 1) + fib0(n - 2);

    }

    public static int fib1(int n) {//n = 6
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        return fib1(n, arr);

    }

    private static int fib1(int n, int[] arr) {

        if (arr[n] == 0) {
            arr[n] = fib1(n - 1, arr) + fib1(n - 2, arr);
        }

        return arr[n];
    }


    public static int fib2(int n) {//n = 6
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];

    }

    public static int fib3(int n) {
        if (n <= 1) return n;
        int[] arr = new int[2];//table view
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 3; i <= n; i++) {
            arr[i % 2] = arr[(i - 1) % 2] + arr[(i - 2) % 2];
        }

        return arr[n % 2];

    }

    public static int fib4(int n) {
        if (n <= 1) return n;
        int[] arr = new int[2];//table view
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 3; i <= n; i++) {
            arr[i & 1] = arr[(i - 1) & 1] + arr[(i - 2) & 1];
        }

        return arr[n & 1];

    }

    public static int fib5(int n) {
        if (n <= 1) return n;
        int first = 1;
        int second = 1;
        //   iteration  Iterator
        for (int i = 0; i < n - 1; i++) {//累加的次数 n-1
            int sum = first + second;
            first = second;
            second = sum;

        }
        return second;


    }


    public static int fib6(int n) {
        if (n <= 1) return n;
        return fib6(n, 1, 1);
    }


    private static int fib6(int n, int first, int second) {
        if (n <= 1) return second;
        return fib6(n - 1, second, first + second);
    }


}
