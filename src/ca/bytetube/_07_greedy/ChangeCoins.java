package ca.bytetube._07_greedy;

import java.util.Arrays;

public class ChangeCoins {
    public static void main(String[] args) {
        System.out.println(changeCoins0(new int[]{25,20,5,1 },41));
        System.out.println("=============");
        System.out.println(changeCoins(new int[]{25,20,5,1 },41));
    }

    public static int changeCoins(int[] faces, int money) {//25,10,5,1  81
        int count = 0;
        Arrays.sort(faces);
        for (int i = faces.length - 1; i >= 0 ; i--) {
            if (money < faces[i]) continue;
            System.out.println(faces[i]);
            money -= faces[i];
            count++;
            i++;
        }

        return count;


    }


    public static int changeCoins0(int[] faces, int money) {//25,10,5,1  41
        int count = 0;
        int index = 0;
        while (money > 0) {
            if ((money - faces[index]) >= 0) {
                System.out.println(faces[index]);
                money = money - faces[index];
                count++;
                continue;
            }
            index++;

        }
        return count;

    }
}
