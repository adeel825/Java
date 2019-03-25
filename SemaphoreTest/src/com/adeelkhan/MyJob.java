package com.adeelkhan;
import java.util.concurrent.Semaphore;

public class MyJob {
    static Semaphore semaphore = new Semaphore(4);

    static class MyJobThread extends Thread {
        String name = "";

        MyJobThread(String name) {
            this.name = name;
        }

        public void run() {
            try {

                System.out.println(name + " : acquiring lock...");
                System.out.println(name + " : available Semaphore permits now: "
                        + semaphore.availablePermits());

                semaphore.acquire();
                System.out.println(name + " : got the permit!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : is performing operation " + i
                                + ", available Semaphore permits : "
                                + semaphore.availablePermits());

                        // sleep 1 second
                        Thread.sleep(1000);

                    }

                } finally {

                    // calling release() after a successful acquire()
                    System.out.println(name + " : releasing lock...");
                    semaphore.release();
                    System.out.println(name + " : available Semaphore permits now: "
                            + semaphore.availablePermits());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }
    }
}
