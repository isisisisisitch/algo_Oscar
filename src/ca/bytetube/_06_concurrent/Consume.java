package ca.bytetube._06_concurrent;

public class Consume implements Runnable {
    private Drop drop;


    public Consume(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        String food = null;
       while ((food = drop.get()) != null){
           System.out.println("get a new food :" + food);
       }
    }
}
