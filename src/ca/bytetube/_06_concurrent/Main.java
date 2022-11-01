package ca.bytetube._06_concurrent;

public class Main {
    public static void main(String[] args) {
//        Thread thread = Thread.currentThread();
//        thread.setPriority(10);
//        System.out.println(thread);//Thread[main,5,main]
        //test1();
//        MyThread thread = new MyThread();
//        thread.run();//create a thread:main
//        //thread.start();//create a thread:Thread-0
//        System.out.println(thread.getState());
//        test2();
//        test3();
        test4();
        //test5();
    }

    public static void test5(){
        synchronized ("1"){
            synchronized ("1"){
                System.out.println(123);
            }

        }

    }


    public static void test4(){
        Station station = new Station();
        for (int i = 1; i <= 4 ; i++) {
            Thread thread = new Thread(station);
            thread.setName("Thread " + i);
            thread.start();
        }

    }


    public static void test3(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(2);
            }
        });
        System.out.println(0);

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        // thread.interrupt();

        System.out.println(3);

    }


    public static void test2(){
        Thread thread1 = new Thread(new MyRunnable());

        thread1.start();//create a thread:Thread-0
        Thread thread2 = new Thread(new MyRunnable());

        thread2.start();//create a thread:Thread-0
        Thread thread3 = new Thread(new MyRunnable());

        thread3.start();//create a thread:Thread-0

    }



    public static void test1(){
        Thread thread = new Thread(new MyRunnable());
        //Thread call start method ---> call Runnable run method
        thread.start();//create a thread:Thread-0
    }



}
