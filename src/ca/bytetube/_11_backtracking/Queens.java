package ca.bytetube._11_backtracking;

public class Queens {

    int[] cols;//cols[4] = 5; index : row val:col
    int ways;

    public int totalNQueens(int n) {
        cols = new int[n];
        place(0);

        return ways;
    }


    private void place(int row) {
        if (row == cols.length) {
            ways++;
            return;
        }
        for (int col = 0; col < cols.length; col++) {

            if (isValid(row, col)) {
                cols[row] = col;
                place(row + 1);
            }

        }
    }

    private boolean isValid(int row, int col) {
        //col
        for (int i = 0; i < row; i++) {
            if (cols[i] == col) return false;

            //diagonal
            if (Math.abs(col - cols[i]) == row - i) return false;
        }


        return true;
    }
}
