package com.adeelkhan;

public class MyThreadClass extends Thread {

    public
    MyThreadClass() {}

    public void run() {
        try {
            Thread.sleep(10000);
            //while (true) {}
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("The current thread is: " + Thread.currentThread().getId());
    }
}
