package ca.bytetube._06_concurrent;

public class Drop {
    private String food;
    //true ---> nothing to eat --->consumer wait
    //false ---> have sth to eat --->producer wait
    private boolean empty = true;

    public synchronized void add(String food) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.food = food;
        empty = false;
        notifyAll();

    }


    public synchronized String get() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        empty = true;

        notifyAll();
        return food;


    }

}
