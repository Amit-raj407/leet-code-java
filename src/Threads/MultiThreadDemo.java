package Threads;

public class MultiThreadDemo {
    public static void main(String[] args) {
        System.out.println("Start");

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task 1 - " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task 2 - " + i);
            }
        });

        t1.start();
        t2.start();
        try{
            t1.join();
        } catch(InterruptedException ex) {
            System.out.println(ex);
        }
       

        try{
            t2.join();
        } catch(InterruptedException ex) {
            System.out.println(ex);
        }
        

        System.out.println("Main thread ends");
    }
}

// join pauses the main thread
// t1.join means main thread will wait until t1 finishes
