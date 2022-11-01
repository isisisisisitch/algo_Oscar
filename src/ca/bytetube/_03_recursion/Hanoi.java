package ca.bytetube._03_recursion;

public class Hanoi {
    public static void main(String[] args) {
        hanoi(3, "A", "C", "B");
    }

    public static void hanoi(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("move " + 1 + " from " + from + " to " + to);
        } else {
            //Move n – 1 plates from A to B
            hanoi(n - 1, from, help, to);
            //Move the plate n from A to C
            System.out.println("move " + n + " from " + from + " to " + to);
            //Move n – 1 plates from B to C
            hanoi(n - 1, help, to, from);

        }

    }


}
