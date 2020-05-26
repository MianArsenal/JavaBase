package thread.daemon;

public class DaemonRunnable implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(this.getClass().getName() + i++ + ":" + System.currentTimeMillis());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
