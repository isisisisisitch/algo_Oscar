package ca.bytetube._06_concurrent;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        int count = 10;
        while (count > 0){
            pool.execute(() -> {
                System.out.println(11+"_"+Thread.currentThread().getName());
            });
            pool.execute(() -> {
                System.out.println(12+"_"+Thread.currentThread().getName());
            });
            pool.execute(() -> {
                System.out.println(13+"_"+Thread.currentThread().getName());
            });
            pool.execute(() -> {
                System.out.println(14+"_"+Thread.currentThread().getName());
            });
            pool.execute(() -> {
                System.out.println(15+"_"+Thread.currentThread().getName());
            });
            Thread.sleep(1000);
            count--;
            System.out.println("==================");
        }
        pool.shutdown();

    }
}
