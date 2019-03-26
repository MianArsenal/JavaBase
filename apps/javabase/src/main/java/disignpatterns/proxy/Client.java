package disignpatterns.proxy;

/**
 * Created by MIHE on 3/22/2019.
 * 场景类
 */
public class Client {

  public static void main(String[] args) {
    IGamePlay gamePlay = new MyGamePlay("MiAN");
    IGamePlay proxyGamePlay = new ProxyGamePlay(gamePlay);
    proxyGamePlay.start();
    proxyGamePlay.play();
    proxyGamePlay.stop();
  }

}
