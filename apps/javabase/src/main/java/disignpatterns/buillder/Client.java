package disignpatterns.buillder;

/**
 * Created by MIHE on 3/21/2019.
 * 场景类
 */
public class Client {

  public static void main(String[] args) {
    Director director = new Director();
    director.setBuilder(new ConcreteBuilder1());
    Product product1 = director.construct();
    System.out.println(product1.getPartA());
    System.out.println(product1.getPartB());
    director.setBuilder(new ConcreteBuilder2());
    Product product2 = director.construct();
    System.out.println(product2.getPartA());
    System.out.println(product2.getPartB());
  }

}
