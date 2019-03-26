package disignpatterns.proxy.commonproxy;

import disignpatterns.proxy.IGamePlay;
import disignpatterns.proxy.MyGamePlay;

/**
 * Created by MIHE on 3/22/2019.
 * 普通代理类：屏蔽了真实角色对高层模块的影响
 */
public class CommonProxyGamePlay implements IGamePlay {

  private IGamePlay gamePlay;

  public CommonProxyGamePlay(String name) {
    this.gamePlay = new MyGamePlay(name);
  }

  @Override
  public void start() {
    this.gamePlay.start();
  }

  @Override
  public void play() {
    this.gamePlay.play();
  }

  @Override
  public void stop() {
    this.gamePlay.stop();
  }
}
