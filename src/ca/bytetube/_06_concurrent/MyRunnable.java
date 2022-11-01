package ca.bytetube._06_concurrent;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("create a thread:"+ Thread.currentThread().getName());
    }
}
