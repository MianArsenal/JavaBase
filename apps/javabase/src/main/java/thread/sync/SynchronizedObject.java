package thread.sync;

public class SynchronizedObject {

    private String name;

    public SynchronizedObject() {
    }

    public SynchronizedObject(String name) {
        this.name = name;
    }

    public synchronized void sayName(String who) {
        System.out.println(who + " says " + name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sayNameV2(String who) {
        synchronized (this) {
            System.out.println(who + " says " + name);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sayNameV2(String who, SynchronizedObject object) {
        synchronized (object) {
            System.out.println(who + " says " + name);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sayName() {
        System.out.println("my name is " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
