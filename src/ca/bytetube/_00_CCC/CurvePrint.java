package ca.bytetube._00_CCC;

public class CurvePrint {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        curvePrint(matrix);
    }

    public static void curvePrint(int[][] matrix) {
//        int[] a = {0,0};
//        int[] b = {0,0};
//        int height = matrix.length-1;
//        int width = matrix[0].length-1;
//        boolean goingdown = true;
//        while (b[0] != width && b[1] !=height){
//            if (goingdown == true){
//                int[] m = a;
//                while (m!=b){
//                    m[0]--;
//                    m[1]++;
//                    System.out.println(matrix[m[1]][m[0]]);
//                }
//            } else{
//                int[] m = b;
//                while (m!=a){
//                    m[0]++;
//                    m[1]--;
//                    System.out.println(matrix[m[1]][m[0]]);
//                }
//            }
//
//            if(a[0] == width){
//                a[1]++;
//            } else{
//                a[0]++;
//            }
//            if(b[1] == height){
//                b[0]++;
//            } else{
//                b[1]++;
//            }
//
//
//        }
        //1.set a,b pointers
        int aR = 0;
        int aC = 0;

        int bR = 0;
        int bC = 0;

        //2.end gird
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;

        boolean fromUp = false;

        while (aR <= endR) {
            //3.print each level
            printLevel(matrix, aR, aC, bR, bC, fromUp);

            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            bC = bR == endR ? bC + 1 : bC;
            bR = bR == endR ? bR : bR + 1;

            fromUp = !fromUp;
        }
    }
    private static void printLevel(int[][] matrix, int tR, int tC, int dR, int dC, boolean fromUp) {
        //fromUp == true
        //from up to down
        if (fromUp) {
            while (tR <= dR)  System.out.print(matrix[tR++][tC--]+" ");
        }else {//from down to up
            while (dR >= tR) System.out.print(matrix[dR--][dC++]+" ");
        }
    }
}

