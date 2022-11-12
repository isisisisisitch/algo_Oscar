package ca.bytetube._00_CCC;

public class Q1 {
    public static void main(String[] args) {
        printChessBoard(5);
    }

    public static void printChessBoard(int input) {
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    System.out.print("W" + " ");
                } else {
                    System.out.print("B" + " ");
                }
            }
            System.out.println();

        }
    }

}
