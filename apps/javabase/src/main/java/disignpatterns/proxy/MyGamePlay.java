package disignpatterns.proxy;

/**
 * Created by MIHE on 3/22/2019.
 * 真实主题类
 */
public class MyGamePlay implements IGamePlay {

  private String name;

  public MyGamePlay(String name) {
    this.name = name;
  }

  @Override
  public void start() {
    System.out.println(this.name + " starts to play!");
  }

  @Override
  public void play() {
    System.out.println(this.name + " is playing!");
  }

  @Override
  public void stop() {
    System.out.println(this.name + " stops playing!");
  }
}
