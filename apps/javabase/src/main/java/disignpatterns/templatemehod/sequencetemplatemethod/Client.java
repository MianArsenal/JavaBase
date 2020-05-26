package disignpatterns.templatemehod.sequencetemplatemethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MIHE on 3/21/2019.
 */
public class Client {

  public static void main(String[] args) {
    List<String> sequence1 = new ArrayList<>();
    sequence1.add("Stop");
    sequence1.add("Start");
    sequence1.add("Shift");
    List<String> sequence2 = new ArrayList<>();
    sequence2.add("Start");
    sequence2.add("Shift");
    sequence2.add("Stop");
    AbstractCar bike = new Bike();
    System.out.println("bike1");
    bike.setSequence(sequence1);
    bike.run();
    System.out.println("bike2");
    bike.setSequence(sequence2);
    bike.run();
    System.out.println("bus1");
    AbstractCar bus = new Bus();
    bus.setSequence(sequence1);
    bus.run();
    System.out.println("bus2");
    bus.setSequence(sequence2);
    bus.run();
  }

}
