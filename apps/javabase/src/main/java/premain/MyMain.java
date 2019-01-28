package premain;

/**
 * Created by MIHE on 1/21/2019.
 * java -javaagent:javabase.jar=YourCommand -cp javabase.jar premain.MyMain
 * java -javaagent:javabase.jar=premain/MyMain-main--premain/Say-sayHelloWorld -cp javabase.jar premain.MyMain
 */
public class MyMain {
  public static void main(String[] args) {
    System.out.println("MyMain.main() start!");
    new Say().sayHelloWorld();
    System.out.println("MyMain.main() end!");
  }
}
