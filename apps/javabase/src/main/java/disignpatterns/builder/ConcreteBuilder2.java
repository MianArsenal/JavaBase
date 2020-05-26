package disignpatterns.builder;

/**
 * Created by MIHE on 3/21/2019.
 * 实现建造类
 */
public class ConcreteBuilder2 extends AbstractBuilder{
  @Override
  protected void buildPartA() {
    this.product.setPartA("Product A2");
  }

  @Override
  protected void buildPartB() {
    this.product.setPartB("Product B2");
  }
}
