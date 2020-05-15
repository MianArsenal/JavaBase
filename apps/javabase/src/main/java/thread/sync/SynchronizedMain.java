package thread.sync;

public class SynchronizedMain {

    private static SynchronizedObject object = new SynchronizedObject("Mi An");

    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> SynchronizedMain.getSynchronizedObject().sayName("sub"));
//        thread.start();
//        Thread.sleep(100);
//        object.sayName();
//        object.sayName("main");

//        Thread thread = new Thread(() -> SynchronizedMain.getSynchronizedObject().sayNameV2("sub"));
//        thread.start();
//        Thread.sleep(100);
//        object.sayName();
//        object.sayNameV2("main");

        Thread thread = new Thread(() -> SynchronizedMain.getSynchronizedObject().sayNameV2("sub", getSynchronizedObject()));
        thread.start();
        Thread.sleep(100);
        object.sayName();
        object.sayNameV2("main", getSynchronizedObject());
    }

    public static SynchronizedObject getSynchronizedObject () {
        return object;
    }

}
