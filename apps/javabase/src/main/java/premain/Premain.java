package premain;

/**
 * Created by MIHE on 1/21/2019.
 */

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class Premain {
  public static void premain(String agentArgs, Instrumentation inst) throws ClassNotFoundException, UnmodifiableClassException {
    System.out.println("Premain.premain() start!");
    System.out.println(agentArgs);
    String[] args = getArgs(agentArgs);
    if (null != args) {
      inst.addTransformer(new Transformer(args));
    }
    System.out.println("Premain.premain() end!");
  }

  private static String[] getArgs(String agentArgs) {
    if (null == agentArgs || "".equals(agentArgs)) {
      return null;
    }
    String[] args = agentArgs.split("--");
    if (args.length != 2) {
      return null;
    }
    String[] mainArgs = args[0].split("-");
    String[] monitorArgs = args[1].split("-");
    if (mainArgs.length != 2 || monitorArgs.length != 2) {
      return null;
    }
    String[] result = new String[4];
    result[0] = mainArgs[0];
    result[1] = mainArgs[1];
    result[2] = monitorArgs[0];
    result[3] = monitorArgs[1];
    return result;
  }
}