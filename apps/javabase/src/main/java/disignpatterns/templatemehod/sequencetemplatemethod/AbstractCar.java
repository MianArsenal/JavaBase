package disignpatterns.templatemehod.sequencetemplatemethod;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created by MIHE on 3/21/2019.
 * 模板类
 */
public abstract class AbstractCar {

  private static final String START = "Start";
  private static final String SHIFT = "Shift";
  private static final String STOP = "Stop";
  private List<String> sequence;

  protected abstract void start();

  protected abstract void shift();

  protected abstract void stop();

  public void setSequence(List<String> sequence) {
    this.sequence = sequence;
  }

  public final void run() {
    if (CollectionUtils.isEmpty(sequence)) {
      return;
    }
    for (String seq : sequence) {
      if (START.equals(seq)) {
        this.start();
      } else if (SHIFT.equals(seq)) {
        this.shift();
      } else if (STOP.equals(seq)) {
        this.stop();
      }
    }
  }
}
