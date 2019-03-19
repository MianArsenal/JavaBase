package disignpatterns.abstractfactory;

/**
 * Created by MIHE on 3/19/2019.
 * 调用时只需要调用不同工厂生产对应的产品使用，无需关心工厂的具体实现。
 */
public class Client {

  public static void main(String[] args) {
    AbstractFactory productOneFactory = new ProductOneFactory();
    AbstractFactory productTwoFactory = new ProductTwoFactory();
    ProductA productA1 = productOneFactory.createProductA();
    ProductA productA2 = productTwoFactory.createProductA();
    ProductB productB1 = productOneFactory.createProductB();
    ProductB productB2 = productTwoFactory.createProductB();
    productA1.doSomething();
    productA2.doSomething();
    productB1.doSomething();
    productB2.doSomething();
  }

}
