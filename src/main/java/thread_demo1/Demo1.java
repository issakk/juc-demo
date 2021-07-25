package thread_demo1;


import java.util.concurrent.*;

/**
 * how to run a new thread
 * 1. extend Thread
 * 2. implements Runnable
 * 3.implements Callable
 */
public class Demo1 {
    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        thread1.start();

        Runnable runnable = () -> System.out.println(Thread.currentThread().getName() +" this is a new thread from runnable");
        new Thread(runnable).start();

        Callable<String> callable= () -> Thread.currentThread().getName() +" this is a new thread from callable";
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(callable);
        try {
            System.out.println("future.get() = " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " this is a new thread from myThread");
        }
    }


}
