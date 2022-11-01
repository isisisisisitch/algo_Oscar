package ca.bytetube._07_greedy;

import java.util.Comparator;

public class ValueDensityComparator implements Comparator<Article> {

    @Override
    public int compare(Article o1, Article o2) {
        return Double.compare(o2.density,o1.density);
    }
}
