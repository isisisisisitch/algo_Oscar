package ca.bytetube._07_greedy;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return  o2 - o1 ;//<0
    }
}
