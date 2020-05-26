package disignpatterns.proxy.commonproxy;

import disignpatterns.proxy.IGamePlay;

/**
 * Created by MIHE on 3/22/2019.
 * 场景类
 */
public class Client {

  public static void main(String[] args) {

    IGamePlay proxyGamePlay = new CommonProxyGamePlay("MiAn");
    proxyGamePlay.start();
    proxyGamePlay.play();
    proxyGamePlay.stop();

  }

}
