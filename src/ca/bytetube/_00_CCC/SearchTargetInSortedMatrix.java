package ca.bytetube._00_CCC;

public class SearchTargetInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{5,7,14,23,65},{9,15,18,42,70},{11,19,22,53,81},{27,36,45,66,98}};
        System.out.println(searchTargetInSortedMatrix(matrix,36));
    }


    public static boolean searchTargetInSortedMatrix(int[][] matrix, int target){
        int m = 0;
        int n = matrix[0].length - 1;
        while (m != matrix.length && n != -1) {

            if (matrix[m][n] > target) {
                n -= 1;
            } else if (matrix[m][n] < target) {
                m += 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
