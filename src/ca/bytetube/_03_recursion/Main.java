package ca.bytetube._03_recursion;

public class Main {
    public static void main(String[] args) {
        System.out.println(sum0(6));
        int sum = sum(6);//21
        System.out.println(sum);
    }

    public static int sum(int n){//Sum(n) = Sum(n-1) + n;
        if (n <= 1) return n;
        return sum(n-1) + n;//15 + 6 = 21

    }

    //1 + 2 + 3 + 4 + 5+ ...+ n-1 + n
    //Sum(n)
    //Sum(n-1)
    //Sum(4) = Sum(3) + 4;
    public static int sum0(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        return res;
    }


}
