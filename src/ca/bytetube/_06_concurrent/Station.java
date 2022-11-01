package ca.bytetube._06_concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class Station implements Runnable{
    private static int tickets = 100;

    //A B
    ReentrantLock lock = new ReentrantLock();
    public  boolean sellTickets(){
        try{
            lock.lock();
            if (tickets < 1) return false;
            //A
            tickets--;
            String name = Thread.currentThread().getName();
            System.out.println(name + " sell a ticket and remaining : " + tickets + " tickets");
            return tickets > 0;
        }finally {
            lock.unlock();
        }





    }


    @Override
    public void run() {
        while (sellTickets());
    }
}
