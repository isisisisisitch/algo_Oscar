package ca.bytetube._07_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {
        Article[] articles = new Article[]{
                new Article(35,10),
                new Article(30,40),
                new Article(60,30),
                new Article(50,50),
                new Article(40,35),
                new Article(10,40),
                new Article(25,30)
        };

        //Value-oriented
        //select(articles,new ValueComparator());
        //select(articles,new WeightComparator());
        select(articles,new ValueDensityComparator());
    }



    public static void select(Article[] articles, Comparator<Article> comparator){

        Arrays.sort(articles,comparator);
        int capacity = 150;
        int value = 0;
        int weight = 0;
        List<Article> selected = new ArrayList<>();

        for (int i = 0; i < articles.length; i++) {
            int newWeight = articles[i].weight + weight;
            if (newWeight <= capacity) {
                weight = newWeight;
                value += articles[i].value;
                selected.add(articles[i]);
            }
        }

        System.out.println(value);
        System.out.println(selected);

    }
}
