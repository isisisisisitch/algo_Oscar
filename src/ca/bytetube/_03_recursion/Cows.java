package ca.bytetube._03_recursion;

public class Cows {

    public static void main(String[] args) {

        System.out.println(cows3(40));//3914488 //706
    }

    public static int cows(int n) {
        if (n < 1) return 0;
        if (n <= 4) return n;
        return cows(n - 1) + cows(n - 3);

    }

    public static int cows1(int n){
        if (n<=1) return 1;
        if (n<=4) return n;
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        return cows1(n,arr);


    }

    private static int cows1(int n, int[] arr){
        if (arr[n] == 0){
            arr[n] = cows1(n-1,arr) + cows1(n-3,arr);
        }
        return arr[n];
    }

    public static int cows2(int n) {//n = 6
        if (n<=1) return 1;
        if (n<=4) return n;
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;

        for (int i = 4; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 3];
        }

        return arr[n];

    }

    public static int cows3(int n) {//n = 6
        if (n < 1) return 0;
        if (n <= 4) return n;
        int first = 2;
        int second = 3;
        int third = 4;
        for (int i = n; i > 4; i--) {//累加的次数 n-1
            int temp = third;
            third = first + third;
            first = second;
            second = temp;
        }
        return third;
    }


}
