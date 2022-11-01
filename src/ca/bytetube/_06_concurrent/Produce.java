package ca.bytetube._06_concurrent;

public class Produce implements Runnable {
    private Drop drop;

    public Produce(Drop drop) {
        this.drop = drop;
    }


    @Override
    public void run() {
        String[] foods = {"beef","bread","apple","cookies"};
        for (int i = 0; i < foods.length; i++) {
            drop.add(foods[i]);
        }
        drop.add(null);
    }
}
