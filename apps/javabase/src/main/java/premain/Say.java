package premain;

/**
 * Created by MIHE on 1/21/2019.
 */
public class Say {
  public void sayHelloWorld() {
    try {
      Thread.sleep(3000L);
      System.out.println("Hello World!");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
