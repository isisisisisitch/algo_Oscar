package ca.bytetube._07_greedy;

import java.util.Comparator;

public class ValueComparator implements Comparator<Article> {
    @Override
    public int compare(Article o1, Article o2) {
        return o2.value - o1.value;
    }
}
