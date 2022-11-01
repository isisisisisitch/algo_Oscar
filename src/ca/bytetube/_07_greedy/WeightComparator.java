package ca.bytetube._07_greedy;

import java.util.Comparator;

public class WeightComparator implements Comparator<Article> {

    @Override
    public int compare(Article o1, Article o2) {
        return o1.weight - o2.weight;
    }
}
