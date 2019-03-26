package disignpatterns.proxy.mandatoryproxy;

/**
 * Created by MIHE on 3/22/2019.
 * 强制代理：只有通过真实主题类拿到正确的代理才可以执行代理的业务逻辑，否则都无法执行
 */
public class Client {

  public static void main(String[] args) {
    IGamePlay gamePlay = new MyGamePlay("MiAn");
    gamePlay.start();
    gamePlay.play();
    gamePlay.stop();
    IGamePlay proxyGamePlay = new ProxyGamePlay(gamePlay);
    proxyGamePlay.start();
    proxyGamePlay.play();
    proxyGamePlay.stop();
    IGamePlay proxy = gamePlay.getProxy();
    proxy.start();
    proxy.play();
    proxy.stop();
  }

}
