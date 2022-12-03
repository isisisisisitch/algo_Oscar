package ca.bytetube._00_CCC._00_array;

public class Q1 {
    public static void main(String[] args) {
        printChessBoard1(6);
    }

    public static void printChessBoard(int input) {
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                if (((i & 1) == 0 && (j & 1) == 0) || ((i & 1) != 0 && (j & 1) != 0)) {
                    System.out.print("W" + " ");
                } else {
                    System.out.print("B" + " ");
                }
            }
            System.out.println();

        }
    }

    public static void printChessBoard1(int input) {
        String last = "B";
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                if (last == "W") {
                    last = "B";
                } else {
                    last = "W";
                }
                System.out.print(last + " ");
            }
            if ((input & 1) == 0) {
                if (last == "W") {
                    last = "B";
                } else {
                    last = "W";
                }
            }
            System.out.println();

        }
    }

}
