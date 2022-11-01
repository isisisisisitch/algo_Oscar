package ca.bytetube._08_dp;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] grids = {{3,1,0,2},{4,3,2,7},{5,2,1,0}};
        System.out.println(minPathSum(grids));
        System.out.println(minPathSum1(grids));
    }

    /**
     * calculate from (0, 0) to (i,j) min path sum
     */
    public static int minPathSum(int[][] grids) {
       int row = grids.length;
       int col = grids[0].length;
       //① Define state
       int[][] dp = new int[row][col];
       //② Set initial state
        dp[0][0] = grids[0][0];
        
        //first row
        for (int i = 1; i < col; i++) {
            dp[0][i] = grids[0][i] + dp[0][i-1];
        }
        //first col
        for (int i = 1; i < row; i++) {
            dp[i][0] = grids[i][0] + dp[i-1][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                //③ Determine the state transition equation
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grids[i][j];
            }
        }



        return dp[row-1][col-1];
    }

    public static int minPathSum1(int[][] grids) {

        return minPathSum(grids, 0, 0);
    }

    /**
     * calculate from (i,j) to (grids.length - 1, grids[0].length - 1) min path sum
     */
    private static int minPathSum(int[][] grids, int i, int j) {
        if (i == grids.length - 1 && j == grids[0].length - 1) return grids[i][j];

        //1.last row
        if (i == grids.length - 1) return grids[i][j] + minPathSum(grids, i, j + 1);

        //2.last col
        if (j == grids[0].length - 1) return grids[i][j] + minPathSum(grids, i + 1, j);

        //3.current
        return grids[i][j] + Math.min( minPathSum(grids,i,j+1),minPathSum(grids,i+ 1,j));
    }
}
