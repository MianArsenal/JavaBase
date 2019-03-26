package disignpatterns.proxy.mandatoryproxy;

/**
 * Created by MIHE on 3/22/2019.
 */
public class MyGamePlay implements IGamePlay {

  private String name;
  private IGamePlay proxy;

  public MyGamePlay(String name) {
    this.name = name;
  }

  private boolean isProxy() {
    return null != this.proxy;
  }

  @Override
  public void start() {
    if (isProxy()) {
      System.out.println(this.name + " starts to play!");
    } else {
      System.out.println("Please try to find my proxy!");
    }
  }

  @Override
  public void play() {
    if (isProxy()) {
      System.out.println(this.name + " is playing!");
    } else {
      System.out.println("Please try to find my proxy!");
    }
  }

  @Override
  public void stop() {
    if (isProxy()) {
      System.out.println(this.name + " stops playing!");
    } else {
      System.out.println("Please try to find my proxy!");
    }
  }

  @Override
  public IGamePlay getProxy() {
    if (this.proxy == null) {
      this.proxy = new ProxyGamePlay(this);
    }
    return this.proxy;
  }
}
