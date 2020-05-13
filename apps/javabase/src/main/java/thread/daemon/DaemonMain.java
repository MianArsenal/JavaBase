package thread.daemon;

public class DaemonMain {
    public static void main(String[] args) throws Exception {
        Runnable runnable = new DaemonRunnable();
        Thread daemonThread = new Thread(runnable);
        daemonThread.setDaemon(true);
        daemonThread.start();
        Thread.sleep(5000);
    }
}
