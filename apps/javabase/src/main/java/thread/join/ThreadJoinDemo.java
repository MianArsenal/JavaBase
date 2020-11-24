package thread.join;

public class ThreadJoinDemo extends Thread {

    int i ;
    Thread previousThread;

    public ThreadJoinDemo(Thread previousThread, int i) {
        this.previousThread = previousThread;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        for (int i = 0; i < 30; i++) {
            ThreadJoinDemo joinDemo = new ThreadJoinDemo(thread, i);
            joinDemo.start();
            thread = joinDemo;
        }
        System.out.println("main thread");
    }
}
