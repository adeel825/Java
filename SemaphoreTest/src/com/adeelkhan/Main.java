package com.adeelkhan;


public class Main {

    public static void main(String[] args) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        System.out.println("Total available Semaphore permits : "
                + MyJob.semaphore.availablePermits());

        /*
        MyJob.MyJobThread myJob =  new MyJob.MyJobThread("A");
        myJob.start();

        MyJob.MyJobThread myJob2 =  new MyJob.MyJobThread("B");
        myJob2.start();

        MyJob.MyJobThread myJob3 =  new MyJob.MyJobThread("C");
        myJob3.start();

        MyJob.MyJobThread myJob4 =  new MyJob.MyJobThread("D");
        myJob4.start();

        MyJob.MyJobThread myJob5 =  new MyJob.MyJobThread("E");
        myJob5.start();
        */
        MyJob.MyJobThread[] threads = new MyJob.MyJobThread[6];

        for (int i=0; i <= 5; i++) {
            MyJob.MyJobThread thread = new MyJob.MyJobThread(Character.toString(alphabet[i]));
            threads[i] = thread;
            thread.start();
        }


        for(int i = 0; i < threads.length; i++) {

            try {
                threads[i].join();
            }
            catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }

        }
        System.out.println("Done.");

    }
}
