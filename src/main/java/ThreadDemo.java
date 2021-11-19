public class ThreadDemo{
    public static void main(String[] args)  throws InterruptedException{
        ThreadDemo obj = new ThreadDemo();


        Runnable r1 = () -> {
            System.out.println("T1 started");
            try {
                obj.threadWaitWithSynchronized();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1 ended");
        };

        Thread t1 = new Thread(r1);
        t1.start();

        t1.join(); //just to make sure t1 finish execution before t2

        Runnable r2 = () -> {
            System.out.println("T2 started");
            try {
                obj.threadWaitWithhoutSynchronized();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2 ended");
        };

        Thread t2 = new Thread(r2);
        t2.start();

        Thread.sleep(1500);
        System.out.println("Main thread ended");

    }

    private void threadWaitWithSynchronized() throws InterruptedException {
        synchronized (this){
            this.wait(500);
        }
    }

    private void threadWaitWithhoutSynchronized() throws InterruptedException {
        this.wait(500);
    }
}

/*
//Output:

T1 started
T1 ended
T2 started
Exception in thread "Thread-1" java.lang.IllegalMonitorStateException
	at java.base/java.lang.Object.wait(Native Method)
	at ThreadDemo.threadWaitWithhoutSynchronized(ThreadDemo.java:46)
	at ThreadDemo.lambda$main$1(ThreadDemo.java:24)
	at java.base/java.lang.Thread.run(Thread.java:829)
Main thread ended

 */

