package ca.bytetube._08_dp;

public class FindAimInArray {
    public static void main(String[] args) {
        int[] arr = {3,2,7,14};

        System.out.println(findAimInArray(arr,12));
    }

    public static boolean findAimInArray(int[] arr,int aim){
        //① Define state
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];
        //② Set initial state
        for (int i = 0; i < dp.length; i++) dp[i][aim] = true;

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0 ; j--) {
                if (dp[i+1][j] == true) {
                    dp[i][j] = dp[i+1][j];//hard code
                } else if (j+arr[i] <= aim) {
                    //③ Determine the state transition equation
                    dp[i][j] = dp[i+ 1][j] || dp[i+ 1][j+arr[i]];
                }

            }
        }

        return dp[0][0];
    }

    public static boolean findAimInArray1(int[] arr,int aim){

        return findAimInArray(arr,0,0, aim);

    }
    //abc      0        ""
    private static boolean findAimInArray(int[] arr,int index, int sum, int aim){
        if (sum == aim) return true;
        if (index == arr.length) return false;

       return findAimInArray(arr,index + 1,sum, aim)|| findAimInArray(arr,index + 1,sum + arr[index], aim);
    }

}
