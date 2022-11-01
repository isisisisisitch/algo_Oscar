package ca.bytetube._06_concurrent;

public class DeadLock {
    public static void main(String[] args) {
        test1();
    }

    //how to prevent from deadlock?
    public static void test1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized ("1"){
                    System.out.println("1-1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized ("2"){
                        System.out.println("1-2");
                    }
                }

            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized ("2"){
                    System.out.println("2-1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized ("1"){
                        System.out.println("2-2");
                    }
                }

            }
        }).start();
    }



}
