package ca.bytetube._00_CCC._00_array;
//4:45~5:45pm
//6:15~7:25pm
public class CountNumOfDigitsAddUp {
    public static void main(String[] args) {
        countNumOfDigitsAddUp(200,5);
    }
    
    
    public static void countNumOfDigitsAddUp(int x, int y){
        int numOfY = 0;
        for (int i = 0; i < x+1; i++) {
            int sum = 0;
            int next = i/10;
            int digit = i%10;
            sum += digit;
            while (next != 0){
                digit = next%10;
                next = next/10;

                sum += digit;
            }
            if (sum == y) {
                System.out.println(i);
                numOfY++;
            }
        }
        System.out.println(numOfY);
    }
}
