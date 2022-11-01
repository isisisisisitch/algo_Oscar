package ca.bytetube._07_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class SmallestLexicographicalOrder {


    public static void main(String[] args) {
        System.out.println(smallestLexicographicalOrder(new String[]{"dog","cat","pig"}));
    }


    public static String smallestLexicographicalOrder(String[] strs) {

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }

        return res;
    }
}
