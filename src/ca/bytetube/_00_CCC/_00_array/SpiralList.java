package ca.bytetube._00_CCC._00_array;

import java.util.ArrayList;
import java.util.List;

public class SpiralList {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = spiralList(matrix);
        System.out.println(list);
    }


    public static List<Integer> spiralList(int[][] matrix){
        List<Integer> list = new ArrayList<Integer>();

        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while (top <= bottom && left <= right){
            //left top ---> right top
            for (int i = left; i <= right ; i++) {
                list.add(matrix[top][i]) ;
            }
            top++;

            //right top ---> right bottom
            for (int i = top; i <= bottom ; i++) {
                list.add(matrix[i][right]) ;

            }
            right--;

            if (top > bottom || left > right) break;

            //right bottom ---> left bottom
            for (int i = right; i >= left ; i--) {
                list.add(matrix[bottom][i]) ;

            }

            bottom--;
            //left bottom ---> left top
            for (int i = bottom; i >= top ; i--) {
                list.add(matrix[i][left]) ;

            }
            left++;
        }


        return list;
    }

    public static List<Integer> spiralList1(int[][] matrix){
        List<Integer> list = new ArrayList<Integer>();
        int leftBorder = -1;
        int rightBorder = matrix[0].length;
        int upBorder = -1;
        int downBorder = matrix.length;
        int m = 0;
        int n = 0;
        while (isStop(m,n,leftBorder,rightBorder,upBorder,downBorder)) {
            while (n != rightBorder) {
                list.add(matrix[m][n]);
                n += 1;

            }
            n -=1;
            rightBorder -= 1;
            while (m != downBorder) {
                list.add(matrix[m][n]);
                m += 1;

            }
            m-=1;
            downBorder -= 1;
            while (n != leftBorder) {
                list.add(matrix[m][n]);
                n -= 1;

            }
            n+=1;
            leftBorder += 1;
            while (m != upBorder) {
                list.add(matrix[m][n]);
                m -= 1;

            }
            m+=1;
            upBorder += 1;
        }
        return list;
    }

    public static boolean isStop(int m,int n,int lb,int rb,int ub, int db){
        int total = 0;
        if(m+1==rb) total += 1;
        if(n+1 == db) total += 1;
        if(n-1 == ub) total += 1;
        if(m-1==lb) total += 1;
        if(total ==3){
            return false;
        }
        return true;
    }
}
