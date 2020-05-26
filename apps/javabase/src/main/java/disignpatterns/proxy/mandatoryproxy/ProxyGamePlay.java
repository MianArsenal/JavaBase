package disignpatterns.proxy.mandatoryproxy;

/**
 * Created by MIHE on 3/22/2019.
 */
public class ProxyGamePlay implements IGamePlay {

  IGamePlay gamePlay;

  public ProxyGamePlay(IGamePlay gamePlay) {
    this.gamePlay = gamePlay;
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

  @Override
  public IGamePlay getProxy() {
    return this;
  }
}
