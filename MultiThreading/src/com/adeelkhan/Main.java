package com.adeelkhan;

public class Main {

    public static void main(String[] args) {

        System.out.println("The current thread is: " + Thread.currentThread().getId());

/*
        MyThreadClass m = new MyThreadClass();
        m.start();
        try {
            m.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MyThreadClass m1 = new MyThreadClass();
        m1.start();

        System.out.println("Done.");
*/
        MyThreadClass[] myArr = new MyThreadClass[5];

        for (int i=0; i < 5; i++) {
            MyThreadClass m = new MyThreadClass();
            myArr[i] = m;
            m.start();
        }

        for (int i=0; i < 5; i++) {
            try {
                myArr[i].join(500);
                myArr[i].interrupt();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println("FAIL " + i);
            }
        }


        System.out.println("The current thread is: " + Thread.currentThread().getId());


        System.out.println("Done.");

    }
}

