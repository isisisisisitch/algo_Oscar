package ca.bytetube._06_concurrent;

public class CommunicationBetweenThreads {
    public static void main(String[] args) {
       //java.lang.IllegalMonitorStateException
        Drop drop = new Drop();
        Thread thread1 = new Thread(new Produce(drop));
        thread1.start();
        Thread thread2 = new Thread(new Consume(drop));
        thread2.start();

    }
}
