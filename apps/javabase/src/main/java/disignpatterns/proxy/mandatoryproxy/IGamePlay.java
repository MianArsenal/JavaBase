package disignpatterns.proxy.mandatoryproxy;

/**
 * Created by MIHE on 3/22/2019.
 */
public interface IGamePlay {

  void start();

  void play();

  void stop();

  IGamePlay getProxy();
}
