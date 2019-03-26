package disignpatterns.proxy;

/**
 * Created by MIHE on 3/22/2019.
 * 代理类
 */
public class ProxyGamePlay implements IGamePlay, IProxy {

  private IGamePlay gamePlay;

  public ProxyGamePlay(IGamePlay gamePlay) {
    this.gamePlay = gamePlay;
  }

  @Override
  public void start() {
    this.doSomething();
    this.gamePlay.start();
  }

  @Override
  public void play() {
    this.gamePlay.play();
  }

  @Override
  public void stop() {
    this.gamePlay.stop();
    this.doSomething();
  }

  @Override
  public void doSomething() {
    System.out.println("Proxy is doing something!");
  }
}
